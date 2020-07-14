package org.pdxfinder.service;

import org.pdxfinder.dto.PdxDto;
import org.pdxfinder.util.tsv.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class WriteTsvService {

    public void execute(List<PdxDto> pdxDtos, String outputDirectory) throws IOException {

        WriteModelTsvUtil.writeTsv(pdxDtos, outputDirectory);

        WritePatientTsvUtil.writeTsv(pdxDtos, outputDirectory);

        WriteSampleTsvUtil.writeTsv(pdxDtos, outputDirectory);

        WriteSharingTsvUtil.writeTsv(pdxDtos, outputDirectory);

        WriteModelValidationTsvUtil.writeTsv(pdxDtos, outputDirectory);

    }
}
