package org.pdxfinder.jax;

import org.pdxfinder.dto.PdxDto;
import org.pdxfinder.dto.SampleDto;
import org.pdxfinder.jax.dto.JaxDataDto;
import org.pdxfinder.jax.extractor.Extract;
import org.pdxfinder.result.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.pdxfinder.constant.*;
import org.springframework.stereotype.Service;

@Service
public class ExtractService {

    private final Logger log = LoggerFactory.getLogger(ExtractService.class);
    private DataService dataService;

    public ExtractService(DataService dataService) {
        this.dataService = dataService;
    }

    public JaxDataDto fromJAXFeed() throws IOException {

        log.info("Start Loading JAX data");
        List<MutationTsv> fullMutationData = new ArrayList<>();
        List<CnaTsv> fullCnaData = new ArrayList<>();
        List<ExpressionTsv> fullExpressionData = new ArrayList<>();

        List<PdxDto> pdxDtoList = dataService.getAllMetadata();
        for (PdxDto pdxDto : pdxDtoList) {

            String modelId = pdxDto.getModelID();
            List<MutationTsv> mutationTsvList = dataService.getAllMutationData(modelId);
            List<CnaTsv> cnaTsvList = dataService.getAllCopyNumberAlterationData(modelId);
            List<ExpressionTsv> expressionTsvList = dataService.getAllExpressionData(modelId);

            List<SampleDto> sampleDtos = Extract.getSamplesFromGenomicData(mutationTsvList);
            pdxDto.setSampleDtos(sampleDtos)
                    .setHostStrainFull(DataConstants.NSG_HOST_STRAIN_FULL)
                    .setSampleState(DataConstants.NOT_SPECIFIED)
                    .setPublications(DataConstants.EMPTY)
                    .setHistory(DataConstants.EMPTY)
                    .setEthnicityAssessmentMethod(DataConstants.EMPTY)
                    .setAgeAtInitialDiagnosis(DataConstants.EMPTY)
                    .setValidationDtos(Extract.getValidations())
                    .setMetadataSampleTsv(Extract.sampleTsv(pdxDto))
                    .setMetadataSharingTsv(Extract.sharingTsv(pdxDto));

            fullExpressionData.addAll(expressionTsvList);
            fullCnaData.addAll(cnaTsvList);
            fullMutationData.addAll(mutationTsvList);

            dataService.getAllHistologyData(modelId);
        }

        log.info("Finished Loading JAX data");
        return new JaxDataDto()
                .setPdxDtos(pdxDtoList)
                .setMutationTsvs(fullMutationData)
                .setCnaTsvs(fullCnaData)
                .setExpressionTsvs(fullExpressionData)
                .build();
    }




//    public List<PdxDto> fromJAXFjkeed() throws IOException {
//        log.info("Start Loading JAX meta data");
//
//        List<MutationTsv> fullMutationData = new ArrayList<>();
//        List<CnaTsv> fullCnaData = new ArrayList<>();
//        List<ExpressionTsv> fullExpressionData = new ArrayList<>();
//
//        List<PdxDto> pdxDtoList = dataService.getAllMetadata();
//
//        for (PdxDto pdxDto : pdxDtoList) {
//
//            String modelId = pdxDto.getModelID();
//
//            List<MutationTsv> mutationTsvList = dataService.getAllMutationData(modelId);
//            List<CnaTsv> cnaTsvList = dataService.getAllCopyNumberAlterationData(modelId);
//            List<ExpressionTsv> expressionTsvList = dataService.getAllExpressionData(modelId);
//            dataService.getAllHistologyData(modelId);
//
//
//
//            fullExpressionData.addAll(expressionTsvList);
//            fullCnaData.addAll(cnaTsvList);
//            fullMutationData.addAll(mutationTsvList);
//        }
//
//        log.info("Finished Loading JAX meta data");
//        return pdxDtoList;
//    }





}
