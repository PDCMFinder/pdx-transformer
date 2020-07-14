package org.pdxfinder.util;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.pdxfinder.dto.MetadataSampleTsv;
import org.pdxfinder.dto.PdxDto;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class WriteSampleTsvUtil {

    private WriteSampleTsvUtil() {
        // Never Called
    }

    public static void writeTsv(List<PdxDto> pdxDtoList, String outputDirectory) throws IOException {

        InputStream contents = FileUtil.class.getResourceAsStream("/templates/head_metadata-sample.tsv");
        CsvSchema.Builder builder = CsvSchema.builder();
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = builder.build().withHeader().withColumnSeparator('\t');

        MappingIterator<MetadataSampleTsv> iterator = mapper.readerFor(MetadataSampleTsv.class).with(schema).readValues(contents);

        List<MetadataSampleTsv> metadataSampleTsvs = iterator.readAll();

        pdxDtoList.forEach(pdxDto -> metadataSampleTsvs.add(new MetadataSampleTsv()
                                                                    .setField("")
                                                                    .setPatientId(pdxDto.getPatientID())
                                                                    .setSampleId(pdxDto.getModelID())
                                                                    .setCollectionDate("")
                                                                    .setCollectionEvent("")
                                                                    .setMonthsSinceCollectionOne("")
                                                                    .setAgeInYearsAtCollection(pdxDto.getAge())
                                                                    .setDiagnosis(pdxDto.getClinicalDiagnosis())
                                                                    .setTumourType(pdxDto.getTumorType())
                                                                    .setPrimarySite(pdxDto.getPrimarySite())
                                                                    .setCollectionSite("Not Specified")
                                                                    .setStage(pdxDto.getStageValue())
                                                                    .setStagingSystem("")
                                                                    .setGrade(pdxDto.getGradeValue())
                                                                    .setGradingSystem("")
                                                                    .setVirologyStatus("")
                                                                    .setSharable("")
                                                                    .setTreatmenNaiveAtCollection("")
                                                                    .setTreated("")
                                                                    .setPriorTreatment("")
                                                                    .setModelId(pdxDto.getModelID())));

        String modelMetaData = FileUtil.serializePojoToTsv(metadataSampleTsvs);
        String output = String.format("%s/metadata-sample.tsv", outputDirectory);
        FileUtil.write(modelMetaData, output, false);
    }

}
