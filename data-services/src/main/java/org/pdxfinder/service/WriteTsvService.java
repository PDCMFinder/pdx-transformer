package org.pdxfinder.service;

import org.pdxfinder.constant.Directories;
import org.pdxfinder.dto.PdxDto;
import org.pdxfinder.util.template.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class WriteTsvService {

    @Value("${output.directory}")
    private String workDIrectory;

    public void metaData(List<PdxDto> pdxDtos, String dataSource) throws IOException {

        String destination = String.format("%s%s", workDIrectory, dataSource);
        String treatment = String.format("%s%s%s", workDIrectory, dataSource, Directories.TREATMENT_OUT_DIR);

        FileUtils.forceMkdir(new File(destination));
        FileUtils.forceMkdir(new File(treatment));

        WriteModelTsvUtil.writeTsv(pdxDtos, destination);

        WritePatientTsvUtil.writeTsv(pdxDtos, destination);

        WriteSampleTsvUtil.writeTsv(pdxDtos, destination);

        WriteSharingTsvUtil.writeTsv(pdxDtos, destination);

        WriteModelValidationTsvUtil.writeTsv(pdxDtos, destination);

        WriteSamplePlatformTsvUtil.writeTsv(pdxDtos, destination);

        WritePatientTreatmentTsvUtil.writeTsv(pdxDtos, treatment);

    }

    public void genomicData(List<?> mutationTsvs, String dataSource, String dataDir, String fileName) throws IOException {
        String destination = String.format("%s%s%s", workDIrectory, dataSource, dataDir);
        FileUtils.forceMkdir(new File(destination));
        WriteOmicTsv.writeTsv(mutationTsvs, destination+fileName);
    }

}
