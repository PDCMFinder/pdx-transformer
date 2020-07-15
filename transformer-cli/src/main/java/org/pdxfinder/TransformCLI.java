package org.pdxfinder;

import org.pdxfinder.dto.ExtractDto;
import org.pdxfinder.dto.PdxDto;
import org.pdxfinder.service.ExtractService;
import org.pdxfinder.service.TransformDataService;
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
    private TransformDataService transformDataService;
    private WriteTsvService writeTsvService;

    public TransformCLI(ExtractService extractService,
                        TransformDataService transformDataService, WriteTsvService writeTsvService) {
        this.extractService = extractService;
        this.transformDataService = transformDataService;
        this.writeTsvService = writeTsvService;
    }

    @Override
    public void run(String... args) throws Exception {
        ExtractDto extracted = extractService.execute();
        List<PdxDto> pdxDtos = transformDataService.transformerData(extracted);
        writeTsvService.execute(pdxDtos, outputDirectory);
    }

}


