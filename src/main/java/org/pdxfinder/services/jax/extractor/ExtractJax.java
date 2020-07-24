package org.pdxfinder.services.jax.extractor;

import org.pdxfinder.constant.DataConstants;
import org.pdxfinder.constant.Platforms;
import org.pdxfinder.constant.TumorTypeConstants;
import org.pdxfinder.constant.ValidationConstants;
import org.pdxfinder.services.dto.MetadataDto;
import org.pdxfinder.services.dto.SampleDto;
import org.pdxfinder.services.dto.ValidationDto;
import org.pdxfinder.services.result.dto.*;

import java.util.ArrayList;
import java.util.List;

public class ExtractJax {

    private ExtractJax() {
        // Never invoked
    }

    public static List<ExpressionTsv> moreExpressionData(List<ExpressionTsv> expressionTsvs){
        expressionTsvs.forEach(exp -> exp.setPassage(exp.getPassage().replace("P", ""))
                .setSampleOrigin(TumorTypeConstants.ENGRAFTED_TUMOR)
                .setHostStrainNomenclature(DataConstants.NSG_HOST_STRAIN_FULL).build());
        return expressionTsvs;
    }

    public static  List<CnaTsv> moreCnaData(List<CnaTsv> cnaTsvs){
        cnaTsvs.forEach(cnaTsv -> cnaTsv.setPassage(cnaTsv.getPassage().replace("P", ""))
                .setSampleOrigin(TumorTypeConstants.ENGRAFTED_TUMOR)
                .setHostStrainNomenclature(DataConstants.NSG_HOST_STRAIN_FULL).build());
        return cnaTsvs;
    }

    public static List<MutationTsv> moreMutationData(List<MutationTsv> mutationTsvs, String modelId){
        mutationTsvs.forEach(mutationTsv -> {
            mutationTsv.setPassage(mutationTsv.getPassage().replace("P", ""));
            mutationTsv.setSampleOrigin(TumorTypeConstants.ENGRAFTED_TUMOR);
            mutationTsv.setModelId(modelId);
            mutationTsv.setHostStrainName(DataConstants.NSG_HOST_STRAIN_FULL);
        });
        return mutationTsvs;
    }

    public static List<ValidationDto> getValidations() {
        List<ValidationDto> validationDtos = new ArrayList<>();
        validationDtos.add(new ValidationDto(ValidationConstants.FINGER_PRINTING, ValidationConstants.JAX_VALIDATION_DESC, DataConstants.NOT_SPECIFIED));
        return validationDtos;
    }

    public static List<SampleDto> getSamplesFromGenomicData(List<MutationTsv> mutationTsvList) {
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

    public static MetadataSharingTsv sharingTsv(MetadataDto metadataDto) {
        return new MetadataSharingTsv()
                .setField(DataConstants.EMPTY)
                .setModelId(metadataDto.getModelID())
                .setProviderType(DataConstants.EMPTY)
                .setAccessibility(DataConstants.EMPTY)
                .setEuropdxAccessModality(DataConstants.EMPTY)
                .setEmail(DataConstants.EMPTY)
                .setName(DataConstants.EMPTY)
                .setFormUrl(String.format("%s%s", DataConstants.JAX_CONTACT, metadataDto.getModelID()))
                .setDatabaseUrl(String.format("%s%s", DataConstants.JAX_SOURCE_URL, metadataDto.getModelID()))
                .setProviderName(DataConstants.JAX_FULL_NAME)
                .setProviderAbbreviation(DataConstants.JAX_ABBREV)
                .setProject(DataConstants.EMPTY);
    }

    public static MetadataSampleTsv sampleTsv(MetadataDto metadataDto){
        return new MetadataSampleTsv()
                .setField(DataConstants.EMPTY)
                .setPatientId(metadataDto.getPatientID())
                .setSampleId(metadataDto.getModelID())
                .setAgeInYearsAtCollection(metadataDto.getAge())
                .setDiagnosis(metadataDto.getClinicalDiagnosis())
                .setTumourType(metadataDto.getTumorType())
                .setPrimarySite(metadataDto.getPrimarySite())
                .setStage(metadataDto.getStageValue())
                .setGrade(metadataDto.getGradeValue())

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
                .setModelId(metadataDto.getModelID());
    }
}
