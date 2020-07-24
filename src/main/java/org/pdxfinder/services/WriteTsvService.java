package org.pdxfinder.services;

import org.pdxfinder.constant.Directories;
import org.pdxfinder.services.dto.MetadataDto;
import org.pdxfinder.services.result.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger log = LoggerFactory.getLogger(WriteTsvService.class);

    public void metaData(List<MetadataDto> metadataDtos, String dataSource) throws IOException {

        String destination = String.format("%s%s", workDIrectory, dataSource);
        String treatment = String.format("%s%s%s", workDIrectory, dataSource, Directories.TREATMENT_OUT_DIR);
        FileUtils.forceMkdir(new File(destination));
        FileUtils.forceMkdir(new File(treatment));

        ModelTsvWriter.writeTsv(metadataDtos, destination);

        PatientTsvWriter.writeTsv(metadataDtos, destination);

        SampleTsvWriter.writeTsv(metadataDtos, destination);

        SharingTsvWriter.writeTsv(metadataDtos, destination);

        ModelValidationTsvWriter.writeTsv(metadataDtos, destination);

        SamplePlatformTsvWriter.writeTsv(metadataDtos, destination);

        PatientTreatmentTsvWriter.writeTsv(metadataDtos, treatment);
    }

    public void genomicData(List<?> mutationTsvs, String dataSource, String dataDir, String fileName) throws IOException {
        String destination = String.format("%s%s%s", workDIrectory, dataSource, dataDir);
        FileUtils.forceMkdir(new File(destination));
        GenomicTsvWriter.writeTsv(mutationTsvs, destination+fileName);
    }

}
