package org.pdxfinder;

import org.pdxfinder.constant.DataConstants;
import org.pdxfinder.constant.Directories;
import org.pdxfinder.constant.FileNames;
import org.pdxfinder.dto.ExtractDto;
import org.pdxfinder.dto.PdxDto;
import org.pdxfinder.dto.template.CnaTsv;
import org.pdxfinder.dto.template.ExpressionTsv;
import org.pdxfinder.dto.template.MutationTsv;
import org.pdxfinder.service.*;
import org.pdxfinder.service.jax.JaxExtractService;
import org.pdxfinder.service.pdmr.ExtractService;
import org.pdxfinder.service.pdmr.TransformMetaDataService;
import org.pdxfinder.service.pdmr.TransformOmicDataService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;

@Component
public class TransformCLI implements CommandLineRunner {

    private ExtractService extractService;
    private TransformMetaDataService transformMetaDataService;
    private TransformOmicDataService transformOmicDataService;
    private WriteTsvService writeTsvService;
    private JaxExtractService jaxExtractService;

    public TransformCLI(ExtractService extractService,
                        JaxExtractService jaxExtractService,
                        TransformMetaDataService transformMetaDataService,
                        TransformOmicDataService transformOmicDataService,
                        WriteTsvService writeTsvService) {
        this.extractService = extractService;
        this.transformMetaDataService = transformMetaDataService;
        this.transformOmicDataService = transformOmicDataService;
        this.writeTsvService = writeTsvService;
        this.jaxExtractService = jaxExtractService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.transformPdmrData();
       // this.transformJAXData();
    }

    private void transformPdmrData() throws IOException {
        ExtractDto extracted = extractService.fromPdmrOracle();

        List<PdxDto> pdxDtos = transformMetaDataService.execute(extracted);
        writeTsvService.metaData(pdxDtos, DataConstants.PDMR_ABBREV);

//        List<MutationTsv> mutationTsvs = transformOmicDataService.transformOmicData(extracted);
//        writeTsvService.genomicData(mutationTsvs,
//                                    DataConstants.PDMR_ABBREV,
//                                    Directories.MUTATION_OUT_DIR,
//                                    FileNames.MUTATION_DATA_TSV);
    }

    private void transformJAXData() throws IOException {
        List<PdxDto> pdxDtos = jaxExtractService.fromJAXFeed();
        writeTsvService.metaData(pdxDtos, DataConstants.JAX_ABBREV);

        List<MutationTsv> jaxMutation = jaxExtractService.getFullMutationData();
        writeTsvService.genomicData(jaxMutation,
                                    DataConstants.JAX_ABBREV,
                                    Directories.MUTATION_OUT_DIR,
                                    FileNames.MUTATION_DATA_TSV);

        List<CnaTsv> jaxCna = jaxExtractService.getFullCnaData();
        writeTsvService.genomicData(jaxCna,
                                    DataConstants.JAX_ABBREV,
                                    Directories.CNA_OUT_DIR,
                                    FileNames.CNA_DATA_TSV);

        List<ExpressionTsv> expressionTsvList = jaxExtractService.getFullExpressionData();
        writeTsvService.genomicData(expressionTsvList,
                                    DataConstants.JAX_ABBREV,
                                    Directories.EXPRESSION_OUT_DIR,
                                    FileNames.EXP_DATA_TSV);
    }




}


