package org.pdxfinder.jax.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.pdxfinder.constant.DataConstants;
import org.pdxfinder.constant.Directories;
import org.pdxfinder.constant.UrlConstants;
import org.pdxfinder.dto.MetadataDto;
import org.pdxfinder.jax.extractor.ExtractJax;
import org.pdxfinder.result.dto.CnaTsv;
import org.pdxfinder.result.dto.ExpressionTsv;
import org.pdxfinder.result.dto.MutationTsv;
import org.pdxfinder.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class DataServiceJax {

    private final Logger log = LoggerFactory.getLogger(DataServiceJax.class);
    private ObjectMapper mapper = new ObjectMapper();

    @Value("${output.directory}")
    private String workDirectory;


    public List<MetadataDto> getAllMetadata() throws IOException {
        String metadataJson = FileUtil.parseJsonURL(UrlConstants.JAX_METADATA);
        this.writeJAXToFile(metadataJson, Directories.METADATA_OUT_DIR, "models");
        return mapper.convertValue(mapper.readTree(metadataJson).get(DataConstants.METADATA_KEY),
                                   new TypeReference<List<MetadataDto>>() {});
    }

    public List<MutationTsv> getAllMutationData(String modelId) throws IOException {
        log.info(" Getting Mutation Data for Model: {}", modelId);

        String omicData = FileUtil.parseJsonURL(UrlConstants.JAX_MUTATION + modelId);
        this.writeJAXToFile(omicData, Directories.MUTATION_OUT_DIR, modelId);
        List<MutationTsv> mutationTsvList = mapper.convertValue(mapper.readTree(omicData).get(DataConstants.MUTATION_KEY),
                                                                new TypeReference<List<MutationTsv>>() {});
        return ExtractJax.moreMutationData(mutationTsvList, modelId);
    }

    public List<CnaTsv> getAllCopyNumberAlterationData(String modelId) throws IOException {
        log.info(" Getting Copy Number Alteration Data for Model: {}", modelId);

        String cnaData = FileUtil.parseJsonURL(UrlConstants.JAX_CNA + modelId);
        this.writeJAXToFile(cnaData, Directories.CNA_OUT_DIR, modelId);
        List<CnaTsv> cnaTsvList = mapper.convertValue(mapper.readTree(cnaData).get(DataConstants.DATA_KEY),
                                                      new TypeReference<List<CnaTsv>>() {});
        return ExtractJax.moreCnaData(cnaTsvList);
    }

    public List<ExpressionTsv> getAllExpressionData(String modelId) throws IOException {
        log.info(" Getting Expression Data for Model: {}", modelId);

        String data = FileUtil.parseJsonURL(UrlConstants.JAX_RNA_SEQ + modelId);
        this.writeJAXToFile(data, Directories.EXPRESSION_OUT_DIR, modelId);
        List<ExpressionTsv> expressionTsvList = mapper.convertValue(mapper.readTree(data).get(DataConstants.DATA_KEY),
                                                                   new TypeReference<List<ExpressionTsv>>() {});
        return ExtractJax.moreExpressionData(expressionTsvList);
    }

    public void getAllHistologyData(String modelId) throws IOException {
        log.info(" Getting Histology Data for Model: {}", modelId);
        String omicData = FileUtil.parseJsonURL(UrlConstants.JAX_HISTOLOGY + modelId);
        this.writeJAXToFile(omicData, Directories.HISTOLOGY_OUT_DIR, modelId);
    }



    public void writeJAXToFile(String pdxInfo, String dataType, String modelID) throws IOException {

        String destination = String.format("%s%s%s", workDirectory, Directories.JAX_RAW_DATA, dataType);
        FileUtils.forceMkdir(new File(destination));
        String output = String.format("%s/%s.json", destination, modelID);
        FileUtil.write(pdxInfo, output);
    }




}
