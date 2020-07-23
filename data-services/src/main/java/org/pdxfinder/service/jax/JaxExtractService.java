package org.pdxfinder.service.jax;

import org.pdxfinder.dto.PdxDto;
import org.pdxfinder.dto.SampleDto;
import org.pdxfinder.dto.ValidationDto;
import org.pdxfinder.dto.template.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.pdxfinder.constant.*;
import org.springframework.stereotype.Service;

@Service
public class JaxExtractService {

    private final Logger log = LoggerFactory.getLogger(JaxExtractService.class);
    private List<MutationTsv> fullMutationData = new ArrayList<>();
    private List<CnaTsv> fullCnaData = new ArrayList<>();
    private List<ExpressionTsv> fullExpressionData = new ArrayList<>();

    private JaxDataService dataService;

    public JaxExtractService(JaxDataService dataService) {
        this.dataService = dataService;
    }

    public List<PdxDto> fromJAXFeed() throws IOException {
        log.info("Start Loading JAX meta data");

        List<PdxDto> pdxDtoList = dataService.getAllMetadata();

        for (PdxDto pdxDto : pdxDtoList) {

            String modelId = pdxDto.getModelID();

            List<MutationTsv> mutationTsvList = dataService.getAllMutationData(modelId);
            List<CnaTsv> cnaTsvList = dataService.getAllCopyNumberAlterationData(modelId);
            List<ExpressionTsv> expressionTsvList = dataService.getAllExpressionData(modelId);
            dataService.getAllHistologyData(modelId);

            List<SampleDto> sampleDtos = this.getSamplesFromGenomicData(mutationTsvList);
            pdxDto.setSampleDtos(sampleDtos)
                    .setHostStrainFull(DataConstants.NSG_HOST_STRAIN_FULL)
                    .setSampleState(DataConstants.NOT_SPECIFIED)
                    .setPublications(DataConstants.EMPTY)
                    .setHistory(DataConstants.EMPTY)
                    .setEthnicityAssessmentMethod(DataConstants.EMPTY)
                    .setAgeAtInitialDiagnosis(DataConstants.EMPTY)
                    .setValidationDtos(getValidations())

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
                                                   .setFormUrl(String.format("%s%s", DataConstants.JAX_CONTACT, pdxDto.getModelID()))
                                                   .setDatabaseUrl(String.format("%s%s", DataConstants.JAX_SOURCE_URL, pdxDto.getModelID()))
                                                   .setProviderName(DataConstants.JAX_FULL_NAME)
                                                   .setProviderAbbreviation(DataConstants.JAX_ABBREV)
                                                   .setProject(DataConstants.EMPTY));

            fullExpressionData.addAll(expressionTsvList);
            fullCnaData.addAll(cnaTsvList);
            fullMutationData.addAll(mutationTsvList);
        }

        log.info("Finished Loading JAX meta data");
        return pdxDtoList;
    }


    public List<MutationTsv> getFullMutationData() {
        return fullMutationData;
    }

    public List<CnaTsv> getFullCnaData() {
        return fullCnaData;
    }

    public List<ExpressionTsv> getFullExpressionData() {
        return fullExpressionData;
    }

    public List<ValidationDto> getValidations() {
        List<ValidationDto> validationDtos = new ArrayList<>();
        validationDtos.add(new ValidationDto(ValidationConstants.FINGER_PRINTING, ValidationConstants.JAX_VALIDATION_DESC, DataConstants.NOT_SPECIFIED));
        return validationDtos;
    }

    public List<SampleDto> getSamplesFromGenomicData(List<MutationTsv> mutationTsvList) {
        List<String> sampleIds = new ArrayList<>();
        List<SampleDto> sampleDtos = new ArrayList<>();
        mutationTsvList.forEach(mutationTsv -> {
            if (!sampleIds.contains(mutationTsv.getSampleId())) {
                sampleDtos.add(new SampleDto()
                                       .setSampleID(mutationTsv.getSampleId())
                                       .setPassage(mutationTsv.getPassage())
                                       .setPlatform(mutationTsv.getPlatform())
                                       .setPlatformUrl(Platforms.urlFor(mutationTsv.getPlatform()))
                                       .setwESVCFFile("")
                                       .setwESFastaFile("")
                                       .setnCIGenePanel("")
                                       .setrNASeqFastaFile("")
                                       .setrNASeqRSEMFile("").build());
            }
            sampleIds.add(mutationTsv.getSampleId());
        });
        return sampleDtos;
    }


}
