package org.pdxfinder.service.jax;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.pdxfinder.constant.DataConstants;
import org.pdxfinder.constant.Directories;
import org.pdxfinder.constant.TumorTypeConstants;
import org.pdxfinder.constant.UrlConstants;
import org.pdxfinder.dto.PdxDto;
import org.pdxfinder.dto.template.CnaTsv;
import org.pdxfinder.dto.template.ExpressionTsv;
import org.pdxfinder.dto.template.MutationTsv;
import org.pdxfinder.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class JaxDataService {

    @Value("${output.directory}")
    private String outputDirectory;

    private final Logger log = LoggerFactory.getLogger(JaxDataService.class);
    private ObjectMapper mapper = new ObjectMapper();


    public List<PdxDto> getAllMetadata() throws IOException {
        String metadataJson = FileUtil.parseJsonURL(UrlConstants.JAX_METADATA);
        this.writeJAXToFile(metadataJson, Directories.METADATA_OUT_DIR, "models");
        return mapper.convertValue(mapper.readTree(metadataJson).get(DataConstants.METADATA_KEY), new TypeReference<List<PdxDto>>() {});
    }

    public List<MutationTsv> getAllMutationData(String modelId) throws IOException {
        log.info(" Getting Mutation Data for Model: {}", modelId);

        String omicData = FileUtil.parseJsonURL(UrlConstants.JAX_MUTATION + modelId);
        this.writeJAXToFile(omicData, Directories.MUTATION_OUT_DIR, modelId);
        List<MutationTsv> mutationTsvList = mapper.convertValue(mapper.readTree(omicData).get(DataConstants.MUTATION_KEY), new TypeReference<List<MutationTsv>>() {});
        return fixMutationData(mutationTsvList, modelId);
    }

    public List<CnaTsv> getAllCopyNumberAlterationData(String modelId) throws IOException {
        log.info(" Getting Copy Number Alteration Data for Model: {}", modelId);

        String cnaData = FileUtil.parseJsonURL(UrlConstants.JAX_CNA + modelId);
        this.writeJAXToFile(cnaData, Directories.CNA_OUT_DIR, modelId);
        List<CnaTsv> cnaTsvList = mapper.convertValue(mapper.readTree(cnaData).get(DataConstants.DATA_KEY), new TypeReference<List<CnaTsv>>() {});
        return fixCnaData(cnaTsvList);
    }

    public List<ExpressionTsv> getAllExpressionData(String modelId) throws IOException {
        log.info(" Getting Expression Data for Model: {}", modelId);

        String data = FileUtil.parseJsonURL(UrlConstants.JAX_RNA_SEQ + modelId);
        this.writeJAXToFile(data, Directories.EXPRESSION_OUT_DIR, modelId);
        List<ExpressionTsv> expressionTsvList = mapper.convertValue(mapper.readTree(data).get(DataConstants.DATA_KEY),
                                                                   new TypeReference<List<ExpressionTsv>>() {});
        return fixExpData(expressionTsvList);
    }

    public void getAllHistologyData(String modelId) throws IOException {
        log.info(" Getting Histology Data for Model: {}", modelId);
        String omicData = FileUtil.parseJsonURL(UrlConstants.JAX_HISTOLOGY + modelId);
        this.writeJAXToFile(omicData, Directories.HISTOLOGY_OUT_DIR, modelId);
    }






    public List<ExpressionTsv> fixExpData(List<ExpressionTsv> expressionTsvs){
        expressionTsvs.forEach(exp -> exp.setPassage(exp.getPassage().replace("P", ""))
                .setSampleOrigin(TumorTypeConstants.ENGRAFTED_TUMOR)
                .setHostStrainNomenclature(DataConstants.NSG_HOST_STRAIN_FULL).build());
        return expressionTsvs;
    }


    public List<CnaTsv> fixCnaData(List<CnaTsv> cnaTsvs){
        cnaTsvs.forEach(cnaTsv -> cnaTsv.setPassage(cnaTsv.getPassage().replace("P", ""))
                .setSampleOrigin(TumorTypeConstants.ENGRAFTED_TUMOR)
                .setHostStrainNomenclature(DataConstants.NSG_HOST_STRAIN_FULL).build());
        return cnaTsvs;
    }

    public List<MutationTsv> fixMutationData(List<MutationTsv> mutationTsvs, String modelId){
        mutationTsvs.forEach(mutationTsv -> {
            mutationTsv.setPassage(mutationTsv.getPassage().replace("P", ""));
            mutationTsv.setSampleOrigin(TumorTypeConstants.ENGRAFTED_TUMOR);
            mutationTsv.setModelId(modelId);
            mutationTsv.setHostStrainName(DataConstants.NSG_HOST_STRAIN_FULL);
        });
        return mutationTsvs;
    }


    public void writeJAXToFile(String pdxInfo, String dataType, String modelID) throws IOException {

        String destination = String.format("%s%s%s", outputDirectory, Directories.JAX_RAW_DATA, dataType);
        FileUtils.forceMkdir(new File(destination));
        String output = String.format("%s/%s.json", destination, modelID);
        FileUtil.write(pdxInfo, output);
    }

}
