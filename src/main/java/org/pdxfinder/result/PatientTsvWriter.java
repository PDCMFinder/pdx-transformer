package org.pdxfinder.result;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.pdxfinder.constant.DataConstants;
import org.pdxfinder.constant.FileNames;
import org.pdxfinder.constant.TemplateLocations;
import org.pdxfinder.result.dto.MetadataPatientTsv;
import org.pdxfinder.dto.MetadataDto;
import org.pdxfinder.FileUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PatientTsvWriter {

    private PatientTsvWriter(){
        // Never Called
    }

    public static void writeTsv(List<MetadataDto> metadataDtoList, String outputDirectory) throws IOException {

        InputStream contents = FileUtil.class.getResourceAsStream(TemplateLocations.METADATA_PATIENT);
        CsvSchema.Builder builder = CsvSchema.builder();
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = builder.build().withHeader().withColumnSeparator('\t');

        MappingIterator<MetadataPatientTsv> iterator =
                mapper.readerFor(MetadataPatientTsv.class).with(schema).readValues(contents);

        List<MetadataPatientTsv> patients = iterator.readAll();
        metadataDtoList.forEach(pdxDto -> patients.add(new MetadataPatientTsv()
                                                    .setField(DataConstants.EMPTY)
                                                    .setPatientId(pdxDto.getPatientID())
                                                    .setSex(pdxDto.getGender())
                                                    .setHistory(pdxDto.getHistory())
                                                    .setEthnicity(pdxDto.getEthnicity())
                                                    .setEthnicityAssessmentMethod(pdxDto.getEthnicityAssessmentMethod())
                                                    .setInitialDiagnosis(pdxDto.getInitialDiagnosis())
                                                    .setAgeAtInitialDiagnosis(pdxDto.getAgeAtInitialDiagnosis())));

        String patientMetaData = FileUtil.serializePojoToTsv(patients);
        String output = String.format("%s%s", outputDirectory, FileNames.METADATA_PATIENT_TSV);
        FileUtil.write(patientMetaData, output);
    }

}
