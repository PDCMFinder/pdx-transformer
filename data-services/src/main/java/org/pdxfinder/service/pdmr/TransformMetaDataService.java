package org.pdxfinder.service.pdmr;

import org.pdxfinder.constant.DataConstants;
import org.pdxfinder.domain.*;
import org.pdxfinder.dto.*;
import org.pdxfinder.dto.template.MetadataSampleTsv;
import org.pdxfinder.dto.template.MetadataSharingTsv;
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
            List<TreatmentDto> treatmentDtos = TreatmentUtil.getCurrentTherapies(specimenSearch, extracted);

            PdxDto pdxDto = SpecimenDataUtil.get(specimenSearch, extracted);
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
                    .setStageValue(DataConstants.NOT_SPECIFIED)
                    .setHostStrain(pdxDto.getHostStrainFull().isEmpty() ? DataConstants.EMPTY : DataConstants.NSG_HOST_STRAIN)
                    .setMouseSex(DataConstants.EMPTY)
                    .setTreatmentNaive(DataConstants.EMPTY)
                    .setTreatmentDtos(treatmentDtos)
                    .setSampleState(DataConstants.NOT_SPECIFIED)
                    .setPublications(DataConstants.EMPTY)
                    .setHistory(DataConstants.EMPTY)
                    .setEthnicityAssessmentMethod(DataConstants.EMPTY)
                    .setAgeAtInitialDiagnosis(DataConstants.EMPTY)

                    .setMetadataSampleTsv(new MetadataSampleTsv()
                                                  .setField(DataConstants.EMPTY)
                                                  .setPatientId(pdxDto.getPatientID())
                                                  .setSampleId(pdxDto.getModelID())
                                                  .setAgeInYearsAtCollection(pdxDto.getAge())
                                                  .setDiagnosis(pdxDto.getClinicalDiagnosis())
                                                  .setTumourType(pdxDto.getTumorType())
                                                  .setPrimarySite(pdxDto.getPrimarySite())
                                                  .setStage(pdxDto.getStageValue())
                                                  .setGrade(pdxDto.getGradeValue())

                                                  .setStagingSystem(DataConstants.EMPTY)
                                                  .setCollectionDate(DataConstants.EMPTY)
                                                  .setCollectionEvent(DataConstants.EMPTY)
                                                  .setMonthsSinceCollectionOne(DataConstants.EMPTY)
                                                  .setCollectionSite(DataConstants.NOT_SPECIFIED)
                                                  .setGradingSystem(DataConstants.EMPTY)
                                                  .setVirologyStatus(DataConstants.EMPTY)
                                                  .setSharable(DataConstants.EMPTY)
                                                  .setTreatmenNaiveAtCollection(DataConstants.EMPTY)
                                                  .setTreated(DataConstants.EMPTY)
                                                  .setPriorTreatment(DataConstants.EMPTY)
                                                  .setModelId(pdxDto.getModelID()))

                    .setMetadataSharingTsv(new MetadataSharingTsv()
                                                   .setField(DataConstants.EMPTY)
                                                   .setModelId(pdxDto.getModelID())
                                                   .setProviderType(DataConstants.EMPTY)
                                                   .setAccessibility(DataConstants.EMPTY)
                                                   .setEuropdxAccessModality(DataConstants.EMPTY)
                                                   .setEmail(DataConstants.EMPTY)
                                                   .setName(DataConstants.EMPTY)
                                                   .setFormUrl(DataConstants.PDMR_CONTACT_URL)
                                                   .setDatabaseUrl(pdxDto.getSourceUrl())
                                                   .setProviderName(DataConstants.PDMR_FULL_NAME)
                                                   .setProviderAbbreviation(DataConstants.PDMR_ABBREV)
                                                   .setProject(DataConstants.EMPTY))

                    .build();

            pdxDtos.add(pdxDto);
        }
        log.info("Finished Transforming metadata data-sets");

        return pdxDtos;
    }

}
