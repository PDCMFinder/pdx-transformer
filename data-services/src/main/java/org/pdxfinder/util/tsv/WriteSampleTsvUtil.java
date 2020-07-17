package org.pdxfinder.util.tsv;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.pdxfinder.constant.DataConstants;
import org.pdxfinder.constant.OutputFileNames;
import org.pdxfinder.constant.TemplateLocations;
import org.pdxfinder.dto.tsv.MetadataSampleTsv;
import org.pdxfinder.dto.PdxDto;
import org.pdxfinder.util.FileUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class WriteSampleTsvUtil {

    private WriteSampleTsvUtil() {
        // Never Called
    }

    public static void writeTsv(List<PdxDto> pdxDtoList, String outputDirectory) throws IOException {

        InputStream contents = FileUtil.class.getResourceAsStream(TemplateLocations.META_DATA_SAMPLE);
        CsvSchema.Builder builder = CsvSchema.builder();
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = builder.build().withHeader().withColumnSeparator('\t');
        MappingIterator<MetadataSampleTsv> iterator = mapper.readerFor(MetadataSampleTsv.class).with(schema).readValues(contents);

        List<MetadataSampleTsv> metadataSampleTsvs = iterator.readAll();
        pdxDtoList.forEach(pdxDto -> metadataSampleTsvs.add(new MetadataSampleTsv()
                                                                    .setField(DataConstants.EMPTY)
                                                                    .setPatientId(pdxDto.getPatientID())
                                                                    .setSampleId(pdxDto.getModelID())
                                                                    .setCollectionDate(DataConstants.EMPTY)
                                                                    .setCollectionEvent(DataConstants.EMPTY)
                                                                    .setMonthsSinceCollectionOne(DataConstants.EMPTY)
                                                                    .setAgeInYearsAtCollection(pdxDto.getAge())
                                                                    .setDiagnosis(pdxDto.getClinicalDiagnosis())
                                                                    .setTumourType(pdxDto.getTumorType())
                                                                    .setPrimarySite(pdxDto.getPrimarySite())
                                                                    .setCollectionSite(DataConstants.NOT_SPECIFIED)
                                                                    .setStage(pdxDto.getStageValue())
                                                                    .setStagingSystem(DataConstants.EMPTY)
                                                                    .setGrade(pdxDto.getGradeValue())
                                                                    .setGradingSystem(DataConstants.EMPTY)
                                                                    .setVirologyStatus(DataConstants.EMPTY)
                                                                    .setSharable(DataConstants.EMPTY)
                                                                    .setTreatmenNaiveAtCollection(DataConstants.EMPTY)
                                                                    .setTreated(DataConstants.EMPTY)
                                                                    .setPriorTreatment(DataConstants.EMPTY)
                                                                    .setModelId(pdxDto.getModelID())));

        String modelMetaData = FileUtil.serializePojoToTsv(metadataSampleTsvs);
        String output = String.format("%s%s", outputDirectory, OutputFileNames.METADATA_SAMPLE_TSV);
        FileUtil.write(modelMetaData, output, false);
    }

}
