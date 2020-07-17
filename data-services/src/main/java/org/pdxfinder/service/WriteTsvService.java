package org.pdxfinder.service;

import org.pdxfinder.constant.Directories;
import org.pdxfinder.dto.PdxDto;
import org.pdxfinder.dto.tsv.OmicTsv;
import org.pdxfinder.util.tsv.*;
import org.springframework.stereotype.Service;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class WriteTsvService {

    public void execute(List<PdxDto> pdxDtos, List<OmicTsv> omicTsvs, String outputDirectory) throws IOException {

        String destination = String.format("%s%s", outputDirectory, Directories.PDMR_OUT_DIR);
        String treatment = String.format("%s%s%s", outputDirectory, Directories.PDMR_OUT_DIR, Directories.TREATMENT_OUT_DIR);
        String omic = String.format("%s%s%s", outputDirectory, Directories.PDMR_OUT_DIR, Directories.MUTATION_OUT_DIR);

        FileUtils.forceMkdir(new File(destination));
        FileUtils.forceMkdir(new File(treatment));
        FileUtils.forceMkdir(new File(omic));

        WriteModelTsvUtil.writeTsv(pdxDtos, destination);

        WritePatientTsvUtil.writeTsv(pdxDtos, destination);

        WriteSampleTsvUtil.writeTsv(pdxDtos, destination);

        WriteSharingTsvUtil.writeTsv(pdxDtos, destination);

        WriteModelValidationTsvUtil.writeTsv(pdxDtos, destination);

        WriteSamplePlatformTsvUtil.writeTsv(pdxDtos, destination);

        WritePatientTreatmentTsvUtil.writeTsv(pdxDtos, treatment);

        WriteOmicTsv.writeTsv(omicTsvs,  omic);
    }
}
