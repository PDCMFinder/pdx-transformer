package org.pdxfinder;

import org.pdxfinder.dto.ExtractDto;
import org.pdxfinder.dto.PdxDto;
import org.pdxfinder.dto.tsv.OmicTsv;
import org.pdxfinder.service.ExtractService;
import org.pdxfinder.service.TransformMetaDataService;
import org.pdxfinder.service.TransformOmicDataService;
import org.pdxfinder.service.WriteTsvService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class TransformCLI implements CommandLineRunner {

    @Value("${output.directory}")
    private String outputDirectory;

    private ExtractService extractService;
    private TransformMetaDataService transformMetaDataService;
    private TransformOmicDataService transformOmicDataService;
    private WriteTsvService writeTsvService;

    public TransformCLI(ExtractService extractService,
                        TransformMetaDataService transformMetaDataService,
                        TransformOmicDataService transformOmicDataService,
                        WriteTsvService writeTsvService) {
        this.extractService = extractService;
        this.transformMetaDataService = transformMetaDataService;
        this.transformOmicDataService = transformOmicDataService;
        this.writeTsvService = writeTsvService;
    }

    @Override
    public void run(String... args) throws Exception {
        ExtractDto extracted = extractService.fromPdmrOracle();
        List<PdxDto> pdxDtos = transformMetaDataService.execute(extracted);
        List<OmicTsv> omicTsvs = transformOmicDataService.transformOmicData(extracted);
        writeTsvService.execute(pdxDtos, omicTsvs, outputDirectory);
    }

}


