package org.pdxfinder.util.tsv;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.pdxfinder.dto.tsv.MetadataPatientTsv;
import org.pdxfinder.dto.PdxDto;
import org.pdxfinder.util.FileUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class WritePatientTsvUtil {

    private WritePatientTsvUtil(){
        // Never Called
    }

    public static void writeTsv(List<PdxDto> pdxDtoList, String outputDirectory) throws IOException {

        InputStream contents = FileUtil.class.getResourceAsStream("/templates/head_metadata-patient.tsv");
        CsvSchema.Builder builder = CsvSchema.builder();
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = builder.build().withHeader().withColumnSeparator('\t');

        MappingIterator<MetadataPatientTsv> iterator =
                mapper.readerFor(MetadataPatientTsv.class).with(schema).readValues(contents);

        List<MetadataPatientTsv> patients = iterator.readAll();
        pdxDtoList.forEach(pdxDto -> patients.add(new MetadataPatientTsv()
                                                    .setField("")
                                                    .setPatientId(pdxDto.getPatientID())
                                                    .setSex(pdxDto.getGender())
                                                    .setHistory("")
                                                    .setEthnicity(pdxDto.getEthnicity())
                                                    .setEthnicityAssessmentMethod("")
                                                    .setInitialDiagnosis(pdxDto.getInitialDiagnosis())
                                                    .setAgeAtInitialDiagnosis("")));

        String patientMetaData = FileUtil.serializePojoToTsv(patients);
        String output = String.format("%s/metadata-patient.tsv", outputDirectory);
        FileUtil.write(patientMetaData, output, false);
    }

}
