package org.pdxfinder.cli;

import org.pdxfinder.constant.DataConstants;
import org.pdxfinder.constant.Directories;
import org.pdxfinder.constant.FileNames;
import org.pdxfinder.services.common.WriteTsvService;
import org.pdxfinder.services.pdmr.dto.AccessionsDTO;
import org.pdxfinder.services.pdmr.dto.OracleDataDto;
import org.pdxfinder.services.common.dto.MetadataDto;
import org.pdxfinder.services.result.dto.MutationTsv;
import org.pdxfinder.services.pdmr.services.ExtractService;
import org.pdxfinder.services.pdmr.services.TransformMetaDataService;
import org.pdxfinder.services.pdmr.services.TransformOmicDataService;
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
        AccessionsDTO extractedAccession = extractService.fromPdmrEna();

       List<MetadataDto> metadataDtos = transformMetaDataService.fromOracleDataDto2Metadata(extracted, extractedAccession);
       writeTsvService.metaDataDto2FileSystem(metadataDtos, DataConstants.PDMR_ABBREV);

        List<MutationTsv> mutationTsvs = transformOmicDataService.fromOracleDataDto2MutationTsv(extracted);
        writeTsvService.genomicTsvDto2FileSystem(mutationTsvs,
                                                 DataConstants.PDMR_ABBREV,
                                                 Directories.MUTATION_OUT_DIR,
                                                 FileNames.MUTATION_DATA_TSV);

      }
}


