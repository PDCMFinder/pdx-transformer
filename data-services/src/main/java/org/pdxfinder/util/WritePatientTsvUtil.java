package org.pdxfinder.util;

import org.pdxfinder.dto.WritePatientDto;
import org.pdxfinder.dto.PdxDto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WritePatientTsvUtil {

    private WritePatientTsvUtil(){
        // Never Called
    }

    public static void writeTsv(List<PdxDto> pdxDtoList, String outputDirectory) throws IOException {
        List<WritePatientDto> patients = new ArrayList<>();
        pdxDtoList.forEach(pdxDto -> patients.add(new WritePatientDto()
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
