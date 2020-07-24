package org.pdxfinder.services.result;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.pdxfinder.constant.DataConstants;
import org.pdxfinder.constant.MolCharTypes;
import org.pdxfinder.constant.FileNames;
import org.pdxfinder.constant.TemplateLocations;
import org.pdxfinder.services.common.dto.MetadataDto;
import org.pdxfinder.services.common.dto.SampleDto;
import org.pdxfinder.services.result.dto.SamplePlatformTsv;
import org.pdxfinder.services.common.FileUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class SamplePlatformTsvWriter {

    private SamplePlatformTsvWriter() {
        // Never Called
    }

    public static void write2FileSystem(List<MetadataDto> metadataDtoList, String outputDirectory) throws IOException {

        InputStream contents = FileUtil.class.getResourceAsStream(TemplateLocations.SAMPLE_PLATFORM);
        CsvSchema.Builder builder = CsvSchema.builder();
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = builder.build().withHeader().withColumnSeparator('\t');

        MappingIterator<SamplePlatformTsv> iterator =
                mapper.readerFor(SamplePlatformTsv.class).with(schema).readValues(contents);
        List<SamplePlatformTsv> samplePlatformTsvs = iterator.readAll();

        metadataDtoList.forEach(pdxDto -> {
            List<SampleDto> sampleDtos = pdxDto.getSampleDtos();
            sampleDtos.forEach(sampleDto -> samplePlatformTsvs.add(new SamplePlatformTsv()
                                                                               .setField(DataConstants.EMPTY)
                                                                               .setSampleId(sampleDto.getSampleID())
                                                                               .setSampleOrigin(sampleDto.getTumorType())
                                                                               .setPassage(sampleDto.getPassage())
                                                                               .setPlatform(sampleDto.getPlatform())
                                                                               .setInternalProtocolUrl(sampleDto.getPlatformUrl())
                                                                               .setEngraftedTumorCollectionSite(DataConstants.EMPTY)
                                                                               .setModelId(pdxDto.getModelID())
                                                                               .setHostStrainName(pdxDto.getHostStrain())
                                                                               .setHostStrainNomenclature(pdxDto.getHostStrainFull())
                                                                               .setMolecularCharacterisationType(MolCharTypes.MUTATION)
                                                                               .setPlatformType(DataConstants.EMPTY)
                                                                               .setPlatformNotes(DataConstants.EMPTY)
                                                                               .setAnalysisProtocol(DataConstants.EMPTY)
                                                                               .setProcessedDataFile(DataConstants.EMPTY)
                                                                               .setRawDataSharable(DataConstants.EMPTY)
                                                                               .setRawDataFile(DataConstants.EMPTY)));

        });

        String modelMetaData = FileUtil.serializePojoToTsv(samplePlatformTsvs);
        String output = String.format("%s%s", outputDirectory, FileNames.SAMPLE_PLATFORM_TSV);
        FileUtil.write(modelMetaData, output);
    }
}
