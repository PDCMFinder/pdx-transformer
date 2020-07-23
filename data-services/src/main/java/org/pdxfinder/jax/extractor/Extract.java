package org.pdxfinder.jax.extractor;

import org.pdxfinder.constant.DataConstants;
import org.pdxfinder.constant.Platforms;
import org.pdxfinder.constant.TumorTypeConstants;
import org.pdxfinder.constant.ValidationConstants;
import org.pdxfinder.dto.PdxDto;
import org.pdxfinder.dto.SampleDto;
import org.pdxfinder.dto.ValidationDto;
import org.pdxfinder.result.dto.*;

import java.util.ArrayList;
import java.util.List;

public class Extract {

    private Extract() {
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

    public static MetadataSharingTsv sharingTsv(PdxDto pdxDto) {
        return new MetadataSharingTsv()
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
                .setProject(DataConstants.EMPTY);
    }

    public static MetadataSampleTsv sampleTsv(PdxDto pdxDto){
        return new MetadataSampleTsv()
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
                .setModelId(pdxDto.getModelID());
    }
}
