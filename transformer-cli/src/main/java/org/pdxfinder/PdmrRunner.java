package org.pdxfinder;

import org.pdxfinder.constant.DataConstants;
import org.pdxfinder.constant.Directories;
import org.pdxfinder.constant.FileNames;
import org.pdxfinder.pdmr.dto.OracleDataDto;
import org.pdxfinder.dto.PdxDto;
import org.pdxfinder.result.dto.MutationTsv;
import org.pdxfinder.pdmr.services.ExtractService;
import org.pdxfinder.pdmr.services.TransformMetaDataService;
import org.pdxfinder.pdmr.services.TransformOmicDataService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;

@Component
public class PdmrRunner implements CommandLineRunner {

    private ExtractService extractService;
    private TransformMetaDataService transformMetaDataService;
    private TransformOmicDataService transformOmicDataService;
    private WriteTsvService writeTsvService;

    public PdmrRunner(ExtractService extractService,
                      ExtractService jaxExtractService,
                      TransformMetaDataService transformMetaDataService,
                      TransformOmicDataService transformOmicDataService,
                      WriteTsvService writeTsvService) {
        this.extractService = extractService;
        this.transformMetaDataService = transformMetaDataService;
        this.transformOmicDataService = transformOmicDataService;
        this.writeTsvService = writeTsvService;
        this.extractService = jaxExtractService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.transformPdmrData();
    }

    private void transformPdmrData() throws IOException {
        OracleDataDto extracted = extractService.fromPdmrOracle();

        List<PdxDto> pdxDtos = transformMetaDataService.execute(extracted);
        writeTsvService.metaData(pdxDtos, DataConstants.PDMR_ABBREV);

        List<MutationTsv> mutationTsvs = transformOmicDataService.transformOmicData(extracted);
        writeTsvService.genomicData(mutationTsvs,
                                    DataConstants.PDMR_ABBREV,
                                    Directories.MUTATION_OUT_DIR,
                                    FileNames.MUTATION_DATA_TSV);
    }
}


