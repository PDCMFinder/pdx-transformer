package org.pdxfinder.util;

import org.pdxfinder.dto.WritePatientDto;
import org.pdxfinder.dto.TransformPdx;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WritePatientTsvUtil {

    private WritePatientTsvUtil(){
        // Never Called
    }

    public static void writeTsv(List<TransformPdx> pdxList, String outputDirectory) throws IOException {
        List<WritePatientDto> patients = new ArrayList<>();
        pdxList.forEach(pdx -> patients.add(new WritePatientDto()
                                                    .setPatientId(pdx.getPatientID())
                                                    .setSex(pdx.getGender())
                                                    .setHistory("")
                                                    .setEthnicity(pdx.getEthnicity())
                                                    .setEthnicityAssessmentMethod("")
                                                    .setInitialDiagnosis(pdx.getInitialDiagnosis())
                                                    .setAgeAtInitialDiagnosis("")));

        String patientMetaData = FileUtil.serializePojoToTsv(patients);
        String output = String.format("%s/metadata-patient.tsv", outputDirectory);
        FileUtil.write(patientMetaData, output, false);
    }

}
