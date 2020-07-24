package org.pdxfinder.cli;

import org.pdxfinder.constant.DataConstants;
import org.pdxfinder.constant.Directories;
import org.pdxfinder.constant.FileNames;
import org.pdxfinder.services.WriteTsvService;
import org.pdxfinder.services.jax.services.ExtractServiceJax;
import org.pdxfinder.services.jax.dto.JaxDataDto;
import org.pdxfinder.services.result.dto.CnaTsv;
import org.pdxfinder.services.result.dto.ExpressionTsv;
import org.pdxfinder.services.result.dto.MutationTsv;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class JaxRunner implements CommandLineRunner {

    private ExtractServiceJax extractServiceJax;
    private WriteTsvService writeTsvService;

    public JaxRunner(ExtractServiceJax extractServiceJax, WriteTsvService writeTsvService) {
        this.extractServiceJax = extractServiceJax;
        this.writeTsvService = writeTsvService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.transformJAXData();
    }

    private void transformJAXData() throws IOException {
        JaxDataDto jaxDataDto = extractServiceJax.fromJAXFeed();
        writeTsvService.metaDataDto2FileSystem(jaxDataDto.getMetadataDtos(), DataConstants.JAX_ABBREV);

        List<MutationTsv> mutationData = jaxDataDto.getMutationTsvs();
        writeTsvService.genomicTsvDto2FileSystem(mutationData,
                                                 DataConstants.JAX_ABBREV,
                                                 Directories.MUTATION_OUT_DIR,
                                                 FileNames.MUTATION_DATA_TSV);

        List<CnaTsv> cnaData = jaxDataDto.getCnaTsvs();
        writeTsvService.genomicTsvDto2FileSystem(cnaData,
                                                 DataConstants.JAX_ABBREV,
                                                 Directories.CNA_OUT_DIR,
                                                 FileNames.CNA_DATA_TSV);

        List<ExpressionTsv> expressionData = jaxDataDto.getExpressionTsvs();
        writeTsvService.genomicTsvDto2FileSystem(expressionData,
                                                 DataConstants.JAX_ABBREV,
                                                 Directories.EXPRESSION_OUT_DIR,
                                                 FileNames.EXP_DATA_TSV);
    }




}


