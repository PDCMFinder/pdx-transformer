package org.pdxfinder.util.tsv;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.pdxfinder.constant.DataConstants;
import org.pdxfinder.constant.MolCharTypes;
import org.pdxfinder.constant.OutputFileNames;
import org.pdxfinder.constant.TemplateLocations;
import org.pdxfinder.dto.PdxDto;
import org.pdxfinder.dto.SampleDto;
import org.pdxfinder.dto.tsv.SamplePlatformDataTsv;
import org.pdxfinder.util.FileUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class WriteSamplePlatformTsvUtil {

    private static final String PROTOCOL = "https://pdmr.cancer.gov/content/docs/MCCRD_SOP0053_Generating_oncoKB_Report.pdf";

    private WriteSamplePlatformTsvUtil() {
        // Never Called
    }

    public static void writeTsv(List<PdxDto> pdxDtoList, String outputDirectory) throws IOException {

        InputStream contents = FileUtil.class.getResourceAsStream(TemplateLocations.SAMPLE_PLATFORM);
        CsvSchema.Builder builder = CsvSchema.builder();
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = builder.build().withHeader().withColumnSeparator('\t');

        MappingIterator<SamplePlatformDataTsv> iterator =
                mapper.readerFor(SamplePlatformDataTsv.class).with(schema).readValues(contents);
        List<SamplePlatformDataTsv> samplePlatformDataTsvs = iterator.readAll();

        pdxDtoList.forEach(pdxDto -> {
            List<SampleDto> sampleDtos = pdxDto.getSampleDtos();
            sampleDtos.forEach(sampleDto -> samplePlatformDataTsvs.add(new SamplePlatformDataTsv()
                                                                               .setField(DataConstants.EMPTY)
                                                                               .setSampleId(sampleDto.getSampleID())
                                                                               .setSampleOrigin(sampleDto.getTumorType())
                                                                               .setPassage(sampleDto.getPassage())
                                                                               .setEngraftedTumorCollectionSite(DataConstants.EMPTY)
                                                                               .setModelId(pdxDto.getModelID())
                                                                               .setHostStrainName(pdxDto.getHostStrain())
                                                                               .setHostStrainNomenclature(pdxDto.getHostStrainFull())
                                                                               .setMolecularCharacterisationType(MolCharTypes.MUTATION)
                                                                               .setPlatform(DataConstants.PDMR_PLATFORM)
                                                                               .setPlatformType(DataConstants.EMPTY)
                                                                               .setPlatformNotes(DataConstants.EMPTY)
                                                                               .setAnalysisProtocol(DataConstants.EMPTY)
                                                                               .setProcessedDataFile(DataConstants.EMPTY)
                                                                               .setRawDataSharable(DataConstants.EMPTY)
                                                                               .setRawDataFile(DataConstants.EMPTY)
                                                                               .setInternalProtocolUrl(PROTOCOL)));

        });

        String modelMetaData = FileUtil.serializePojoToTsv(samplePlatformDataTsvs);
        String output = String.format("%s%s", outputDirectory, OutputFileNames.SAMPLE_PLATFORM_TSV);
        FileUtil.write(modelMetaData, output, false);
    }
}
