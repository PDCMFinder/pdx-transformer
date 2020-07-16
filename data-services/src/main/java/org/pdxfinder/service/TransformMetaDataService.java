package org.pdxfinder.service;

import org.pdxfinder.domain.*;
import org.pdxfinder.dto.*;
import org.pdxfinder.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransformMetaDataService {

    private final Logger log = LoggerFactory.getLogger(TransformMetaDataService.class);

    public List<PdxDto> execute(ExtractDto extracted) {

        log.info("Start Transforming metadata data-sets");
        List<String> modelIds = new ArrayList<>();
        List<PdxDto> pdxDtos = new ArrayList<>();

        for (SpecimenSearch specimenSearch : extracted.getSpecimenSearchList()) {

            TransformUtil transformUtil = new TransformUtil(specimenSearch, extracted);

            String modelId = transformUtil.getModelId();
            if (modelId.isEmpty() || modelIds.contains(modelId)) {
                continue;
            }
            modelIds.add(modelId);

            PdxDto pdxDto = SpecimenDataUtil.get(specimenSearch, extracted);
            List<TreatmentDto> treatmentDtos = TreatmentUtil.getCurrentTherapies(specimenSearch, extracted);

            pdxDto.setModelID(modelId)
                    .setPatientID(specimenSearch.getPatientid())
                    .setPrimarySite(specimenSearch.getDiseaselocationdescription())
                    .setSampleType(specimenSearch.getTissuetypedescription())
                    .setInitialDiagnosis("")
                    .setClinicalDiagnosis(transformUtil.getClinicalDiagnosis())
                    .setStageClassification(transformUtil.getStageClassification())
                    .setGradeClassification(transformUtil.getGradeClassification())
                    .setGradeValue(transformUtil.getGradeValue())
                    .setExtractionMethod(transformUtil.getExtractionMethod())
                    .setValidationDtos(transformUtil.getValidations())
                    .setSampleDtos(transformUtil.getSamples())
                    .setStageValue("Not Specified")
                    .setMouseSex("")
                    .setTreatmentNaive(null)
                    .setTreatmentDtos(treatmentDtos);

            pdxDtos.add(pdxDto);
        }

        return pdxDtos;
    }

}
