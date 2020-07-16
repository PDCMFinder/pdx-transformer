package org.pdxfinder.util.tsv;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
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

        InputStream contents = FileUtil.class.getResourceAsStream("/templates/head_sampleplatform-data.tsv");
        CsvSchema.Builder builder = CsvSchema.builder();
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = builder.build().withHeader().withColumnSeparator('\t');

        MappingIterator<SamplePlatformDataTsv> iterator =
                mapper.readerFor(SamplePlatformDataTsv.class).with(schema).readValues(contents);
        List<SamplePlatformDataTsv> samplePlatformDataTsvs = iterator.readAll();

        pdxDtoList.forEach(pdxDto -> {
            List<SampleDto> sampleDtos = pdxDto.getSampleDtos();
            sampleDtos.forEach(sampleDto -> samplePlatformDataTsvs.add(new SamplePlatformDataTsv()
                                                                               .setField("")
                                                                               .setSampleId(sampleDto.getSampleID())
                                                                               .setSampleOrigin(sampleDto.getTumorType())
                                                                               .setPassage(sampleDto.getPassage())
                                                                               .setEngraftedTumorCollectionSite("")
                                                                               .setModelId(pdxDto.getModelID())
                                                                               .setHostStrainName(pdxDto.getHostStrain())
                                                                               .setHostStrainNomenclature(pdxDto.getHostStrainFull())
                                                                               .setMolecularCharacterisationType("mutation")
                                                                               .setPlatform("OncoKB Gene Panel")
                                                                               .setPlatformType("")
                                                                               .setPlatformNotes("")
                                                                               .setAnalysisProtocol("")
                                                                               .setProcessedDataFile("")
                                                                               .setRawDataSharable("")
                                                                               .setRawDataFile("")
                                                                               .setInternalProtocolUrl(PROTOCOL)));

        });

        String modelMetaData = FileUtil.serializePojoToTsv(samplePlatformDataTsvs);
        String output = String.format("%s/sampleplatform-data.tsv", outputDirectory);
        FileUtil.write(modelMetaData, output, false);
    }
}
