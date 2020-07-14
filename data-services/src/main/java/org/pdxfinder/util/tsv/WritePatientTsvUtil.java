package org.pdxfinder.util.tsv;

import org.pdxfinder.dto.tsv.MetadataPatientTsv;
import org.pdxfinder.dto.PdxDto;
import org.pdxfinder.util.FileUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WritePatientTsvUtil {

    private WritePatientTsvUtil(){
        // Never Called
    }

    public static void writeTsv(List<PdxDto> pdxDtoList, String outputDirectory) throws IOException {
        List<MetadataPatientTsv> patients = new ArrayList<>();
        pdxDtoList.forEach(pdxDto -> patients.add(new MetadataPatientTsv()
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
