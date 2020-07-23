package org.pdxfinder.pdmr.services;

import org.pdxfinder.constant.DataConstants;
import org.pdxfinder.domain.*;
import org.pdxfinder.dto.*;
import org.pdxfinder.result.dto.MetadataSampleTsv;
import org.pdxfinder.result.dto.MetadataSharingTsv;
import org.pdxfinder.pdmr.dto.OracleDataDto;
import org.pdxfinder.pdmr.extractor.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransformMetaDataService {

    private final Logger log = LoggerFactory.getLogger(TransformMetaDataService.class);

    public List<PdxDto> execute(OracleDataDto extracted) {

        log.info("Start Transforming metadata data-sets");
        List<String> modelIds = new ArrayList<>();
        List<PdxDto> pdxDtos = new ArrayList<>();

        for (SpecimenSearch specimenSearch : extracted.getSpecimenSearchList()) {

            Extract extract = new Extract(specimenSearch, extracted);

            String modelId = extract.getModelId();
            if (modelId.isEmpty() || modelIds.contains(modelId)) {
                continue;
            }
            modelIds.add(modelId);
            List<TreatmentDto> treatmentDtos = ExtractTreatment.getCurrentTherapies(specimenSearch, extracted);

            PdxDto pdxDto = ExtractSpecimenData.get(specimenSearch, extracted);
            pdxDto.setModelID(modelId)
                    .setPatientID(specimenSearch.getPatientid())
                    .setPrimarySite(specimenSearch.getDiseaselocationdescription())
                    .setSampleType(specimenSearch.getTissuetypedescription())
                    .setInitialDiagnosis("")
                    .setClinicalDiagnosis(extract.getClinicalDiagnosis())
                    .setStageClassification(extract.getStageClassification())
                    .setGradeClassification(extract.getGradeClassification())
                    .setGradeValue(extract.getGradeValue())
                    .setExtractionMethod(extract.getExtractionMethod())
                    .setValidationDtos(extract.getValidations())
                    .setSampleDtos(extract.getSamples())
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
