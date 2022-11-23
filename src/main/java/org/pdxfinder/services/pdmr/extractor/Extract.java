package org.pdxfinder.services.pdmr.extractor;

import org.pdxfinder.constant.*;
import org.pdxfinder.data.model.*;
import org.pdxfinder.services.common.dto.MetadataDto;
import org.pdxfinder.services.pdmr.dto.AccessionsDTO;
import org.pdxfinder.services.pdmr.dto.OracleDataDto;
import org.pdxfinder.services.common.dto.SampleDto;
import org.pdxfinder.services.common.dto.ValidationDto;
import org.pdxfinder.data.model.projection.HistologyProjection;
import org.pdxfinder.services.common.FileUtil;
import org.pdxfinder.services.result.dto.MetadataSampleTsv;
import org.pdxfinder.services.result.dto.MetadataSharingTsv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Extract {

    private Logger log = LoggerFactory.getLogger(Extract.class);
    private SpecimenSearch specimenSearch;
    private OracleDataDto extracted;
    private Map<String,String> accessions;

    public Extract(SpecimenSearch specimenSearch, OracleDataDto extracted, AccessionsDTO accessions) {
        this.specimenSearch = specimenSearch;
        this.extracted = extracted;
        this.accessions = accessions.getAccessionMap();
    }

    public String getModelId(){
        String pdmTypeDesc = specimenSearch.getPdmtypedescription();
        String tissueTypeDesc = specimenSearch.getTissuetypedescription();
        String modelID = "";
        String sampleId = "";
        if ((pdmTypeDesc.equals(CancerModelTypes.PDX_MODEL) || pdmTypeDesc.equals(CancerModelTypes.PATIENT_SPECIMEN) ||
                pdmTypeDesc.equals(CancerModelTypes.ORGANOID_MODEL) || pdmTypeDesc.equals(CancerModelTypes.CELL_MODEL) )
                && (tissueTypeDesc.equals(TissueTypeConstants.RESECTION) || tissueTypeDesc.equals(TissueTypeConstants.TUMOR_BIOPSY))) {
            // Separate model ids for cell model and organoid models
            if (pdmTypeDesc.equals(CancerModelTypes.ORGANOID_MODEL) || pdmTypeDesc.equals(CancerModelTypes.CELL_MODEL)){
                for (Sample dSample : extracted.getSamples()) {
                    if (specimenSearch.getSpecimenseqnbr().equals(dSample.getSpecimenseqnbr())) {
                        if(dSample.getPdmtypeseqnbr().equals(specimenSearch.getPdmtypeseqnbr())) {
                            sampleId = dSample.getSampleid();
                        }
                    }
                }
                modelID = String.format("%s-%s-%s", specimenSearch.getPatientid(), specimenSearch.getSpecimenid(), sampleId);
            }
            // Model id for pdx and patient specimen
            else if ((pdmTypeDesc.equals(CancerModelTypes.PDX_MODEL) || pdmTypeDesc.equals(CancerModelTypes.PATIENT_SPECIMEN))){
                modelID = String.format("%s-%s", specimenSearch.getPatientid(), specimenSearch.getSpecimenid());
            }
        }
        return modelID;
    }

    public String getClinicalDiagnosis(){
        StringBuilder clinicalDiagnosis = new StringBuilder(specimenSearch.getMeddradescription());
        /*for (PatientInfo patient : extracted.getPatientList()) {
            if (specimenSearch.getPatientseqnbr().equals(patient.getPatientseqnbr())) {
                if (patient.getDiagnosissubtype() != null) {
                    clinicalDiagnosis.append(DataConstants.PIPE_CHARACTER).append(patient.getDiagnosissubtype());
                }
                if (patient.getAdditionalmedicalhistory() != null) {
                    clinicalDiagnosis.append(DataConstants.PIPE_CHARACTER).append(patient.getAdditionalmedicalhistory());
                }
                if (patient.getNotes() != null) {
                    clinicalDiagnosis.append(DataConstants.PIPE_CHARACTER).append(patient.getNotes());
                }
            }
        }
        clinicalDiagnosis = new StringBuilder(clinicalDiagnosis.toString().replaceAll("[^a-zA-Z,0-9 +_-]", DataConstants.EMPTY).trim());
        */
        clinicalDiagnosis = new StringBuilder(clinicalDiagnosis.toString().replaceAll("\\s\\s", " "));
        return clinicalDiagnosis.toString();
    }

    public String getClinicalDiagnosisNotes(){
        StringBuilder clinicalDiagnosisNotes = new StringBuilder(specimenSearch.getMeddradescription());
        for (PatientInfo patient : extracted.getPatientList()) {
            if (specimenSearch.getPatientseqnbr().equals(patient.getPatientseqnbr())) {
                if (patient.getDiagnosissubtype() != null) {
                    clinicalDiagnosisNotes.append(DataConstants.PIPE_CHARACTER).append(patient.getDiagnosissubtype());
                }
                if (patient.getAdditionalmedicalhistory() != null) {
                    clinicalDiagnosisNotes.append(DataConstants.PIPE_CHARACTER).append(patient.getAdditionalmedicalhistory());
                }
                if (patient.getNotes() != null) {
                    clinicalDiagnosisNotes.append(DataConstants.PIPE_CHARACTER).append(patient.getNotes());
                }
            }
        }
        //clinicalDiagnosisNotes = new StringBuilder(clinicalDiagnosisNotes.toString().replaceAll("[^a-zA-Z,0-9 +_-]", DataConstants.EMPTY).trim());

        //clinicalDiagnosisNotes = new StringBuilder(clinicalDiagnosisNotes.toString().replaceAll("\\s\\s", " "));
        return clinicalDiagnosisNotes.toString();
    }


    public List<SampleDto> getSamples(String modelId){
        List<SampleDto> sampleDtoList = new ArrayList<>();
        for (Sample dSample : extracted.getSamples()) {
            if (specimenSearch.getSpecimenseqnbr().equals(dSample.getSpecimenseqnbr())) {
                String sampleId = dSample.getSampleid();
                String wholeExomeSeqYn = dSample.getWholeexomesequenceftpyn();
                String rnaSeqYn = dSample.getRnasequenceftpyn();
                String samplePassage = String.valueOf(dSample.getPassageofthissample());
                String sampleTumorType = "";
                String enaAccession = "";
                if (modelId.contains("organoid")){
                    enaAccession = getAccession(modelId, "");
                }else {
                    enaAccession = getAccession(modelId, sampleId);
                }
                if (FileUtil.isNumeric(samplePassage)) {
                    if (!sampleId.contains(CancerModelTypes.CANCER_ASSOCIATED_FIBROBLASTS)) {
                        sampleTumorType = TumorTypeConstants.ENGRAFTED_TUMOR;
                        sampleDtoList.add(new SampleDto().setSampleID(sampleId)
                                                  .setTumorType(sampleTumorType)
                                                  .setPassage(samplePassage)
                                                  .setPlatform(Platforms.PDMR_ONKOKB.get())
                                                  .setRawDataUrl(enaAccession)
                                                  .setPlatformUrl(Platforms.PDMR_ONKOKB.url())
                                                  .setwESVCFFile(wholeExomeSeqYn)
                                                  .setwESFastaFile(wholeExomeSeqYn)
                                                  .setnCIGenePanel(wholeExomeSeqYn)
                                                  .setrNASeqFastaFile(rnaSeqYn)
                                                  .setrNASeqRSEMFile(rnaSeqYn)
                                                  .build());
                    }else {
                        log.warn("This is Strange, CAF Culture that has passage number");
                    }
                } else {
                    if (sampleId.equals(DataConstants.PDMR_PATIENT_SAMPLE_ID)) {
                        sampleTumorType = TumorTypeConstants.PATIENT_TUMOR;
                        samplePassage = "";
                        sampleDtoList.add(new SampleDto().setSampleID(sampleId)
                                                  .setTumorType(sampleTumorType)
                                                  .setPassage(samplePassage)
                                                  .setPlatform(Platforms.PDMR_ONKOKB.get())
                                                  .setRawDataUrl(enaAccession)
                                                  .setPlatformUrl(Platforms.PDMR_ONKOKB.url())
                                                  .setwESVCFFile(wholeExomeSeqYn)
                                                  .setwESFastaFile(wholeExomeSeqYn)
                                                  .setnCIGenePanel(wholeExomeSeqYn)
                                                  .setrNASeqFastaFile(rnaSeqYn)
                                                  .setrNASeqRSEMFile(rnaSeqYn)
                                                  .build());
                    }else {
                        if(dSample.getPdmtypeseqnbr().equals("6")){
                            sampleTumorType = TumorTypeConstants.CELL_MODEL;
                            samplePassage = "";
                            sampleDtoList.add(new SampleDto().setSampleID(modelId)
                                    .setTumorType(sampleTumorType)
                                    .setPassage(samplePassage)
                                    .setPlatform(Platforms.PDMR_ONKOKB.get())
                                    .setRawDataUrl(enaAccession)
                                    .setPlatformUrl(Platforms.PDMR_ONKOKB.url())
                                    .setwESVCFFile(wholeExomeSeqYn)
                                    .setwESFastaFile(wholeExomeSeqYn)
                                    .setnCIGenePanel(wholeExomeSeqYn)
                                    .setrNASeqFastaFile(rnaSeqYn)
                                    .setrNASeqRSEMFile(rnaSeqYn)
                                    .build());
                        }else {
                        log.info(String.format("%s-%s is neither PDX nor Patient Sample ", modelId, sampleId));
                        }
                    }
                }
            }
        }
        return sampleDtoList;
    }

    public String getAccession(String modelId, String sampleId){
        String key = "";
        if(sampleId.equals("")){
            key = modelId;
        }else {
            key = String.format("%s-%s", modelId, sampleId);
        }
        //System.out.println(key);
        return accessions.getOrDefault(key, "");
    }
    public String getGrowth_properties(){
        String growth_property = "";
        Map <String, String> gp_map = new HashMap<String, String>();
        for (Sample dSample : extracted.getSamples()) {
            if (specimenSearch.getSpecimenseqnbr().equals(dSample.getSpecimenseqnbr())) {
                //String sampleId = dSample.getSampleid();
                if(dSample.getPdmtypeseqnbr().equals("6")) {
                    growth_property = dSample.getGrowthpropertyseqnbr();
                }
            }
        }

        return growth_property;
    }
    public String getcomments(){
        String comments = "";
        Map<String, String> MSIStatus = new HashMap<String, String>();
        MSIStatus.put("0", "Unkown");
        MSIStatus.put("1", "MSI-High");
        MSIStatus.put("2", "MSI-Stable");
        for (Sample dSample : extracted.getSamples()) {
            if (specimenSearch.getSpecimenseqnbr().equals(dSample.getSpecimenseqnbr())) {
                //String sampleId = dSample.getSampleid();
                if(dSample.getPdmtypeseqnbr().equals("6")) {
                    if (dSample.getCulturederivation() != null) {
                        StringBuilder comment = new StringBuilder(dSample.getCulturederivation());
                        if (dSample.getSubculturerecommendations() != null) {
                            comment.append("; ").append(dSample.getSubculturerecommendations());
                        }
                        if (specimenSearch.getMsistatusseqnbr() != null) {
                            comment.append("; MSI Status: ").append(MSIStatus.get(specimenSearch.getMsistatusseqnbr()));
                        }
                        comments = comment.toString();
                    }
                }
            }
        }

        return comments;
    }
    public String getParentID(){
        String ParentId = "";
        for (Sample dSample : extracted.getSamples()) {
            if (specimenSearch.getSpecimenseqnbr().equals(dSample.getSpecimenseqnbr())) {
                if(dSample.getPdmtypeseqnbr().equals("6")) {
                    if(dSample.getCultureoriginseqnbr().equals("1")){
                        ParentId = String.format("%s-%s", specimenSearch.getPatientid(), specimenSearch.getSpecimenid());
                    }
                }
            }
        }

        return ParentId;

    }
    public String getSupplier(){
        String supplier = "";
        for (Sample dSample : extracted.getSamples()) {
            if (specimenSearch.getSpecimenseqnbr().equals(dSample.getSpecimenseqnbr())) {
                if(dSample.getPdmtypeseqnbr().equals("6")) {
                    String sampleId = dSample.getSampleid();
                    supplier = String.format("PDMR:%s-%s-%s", specimenSearch.getPatientid(), specimenSearch.getSpecimenid(), sampleId);
                }
            }
        }

        return supplier;
    }


    public String getGradeValue(){
        String gradeValue = "";
        for (Sample dSample : extracted.getSamples()) {
            if (specimenSearch.getSpecimenseqnbr().equals(dSample.getSpecimenseqnbr())) {
                for (HistologyProjection histology : extracted.getHistologies()) {
                    if (dSample.getSampleseqnbr().equals(histology.getSampleSeqnbr())) {
                        for (TumorGrades tumorGrade : extracted.getTumorGradesList()) {
                            if (histology.getTumorGradeSeqNbr().equals(tumorGrade.getTumorgradeseqnbr())) {
                                gradeValue = tumorGrade.getTumorgradeshortname();
                                gradeValue = gradeValue.equals("---") ? DataConstants.NOT_SPECIFIED : gradeValue;
                            }
                        }
                    }
                }
            }
        }
        return gradeValue;
    }


    public String getStageClassification() {
        String stageClassification = "";
        for (TumorGradeStageTypes dTumorGradeStageType : extracted.getTumorGradeStageTypes()) {
            if (specimenSearch.getTumorgradestageseqnbr().equals(dTumorGradeStageType.getTumorgradestageseqnbr())) {
                String x = specimenSearch.getTumorgradestageseqnbr();
                if (x.equals("1") || x.equals("8") || x.equals("9") || x.equals("10") || x.equals("11")) {
                    //1,8,9,10,11
                    stageClassification = dTumorGradeStageType.getTumorgradestageshortname();
                } else {
                    //2,3,4,5,6,7,12,13
                    stageClassification = DataConstants.NOT_SPECIFIED ;
                }
            }
        }
        return stageClassification;
    }

    public String getGradeClassification() {
        String gradeClassification = "";
        for (TumorGradeStageTypes dTumorGradeStageType : extracted.getTumorGradeStageTypes()) {
            if (specimenSearch.getTumorgradestageseqnbr().equals(dTumorGradeStageType.getTumorgradestageseqnbr())) {

                String x = specimenSearch.getTumorgradestageseqnbr();
                if (x.equals("1") || x.equals("8") || x.equals("9") || x.equals("10") || x.equals("11")) {
                    //1,8,9,10,11
                    gradeClassification = DataConstants.NOT_SPECIFIED ;
                } else {
                    //2,3,4,5,6,7,12,13
                    gradeClassification = dTumorGradeStageType.getTumorgradestageshortname();
                    gradeClassification = gradeClassification.equals(DataConstants.NA) ? DataConstants.NOT_SPECIFIED  : gradeClassification;
                }
            }
        }
        return gradeClassification;
    }

    public String getExtractionMethod() {
        String extractionMethod = "";
        for (TissueTypes tissueType : extracted.getTissueTypes()) {
            if (specimenSearch.getTissuetypeshortname().equals(tissueType.getTissuetypeshortname())) {
                extractionMethod = tissueType.getTissuetypedescription();
            }
        }
        return extractionMethod;
    }

    public List<ValidationDto> getValidations(){
        // Hardcode the validation techniques.
        List<ValidationDto> validationDtos = new ArrayList<>();
        validationDtos.add(new ValidationDto(ValidationConstants.FINGER_PRINTING, ValidationConstants.FINGER_PRINTING_DESC, DataConstants.PASSAGE_ALL));
        validationDtos.add(new ValidationDto(ValidationConstants.HUMAN_MOUSE_DNA, ValidationConstants.FINGER_PRINTING_DESC, DataConstants.PASSAGE_ALL));
        validationDtos.add(new ValidationDto(ValidationConstants.HISTOLOGY, ValidationConstants.HISTOLOGY_DESC, DataConstants.PASSAGE_ALL));

        return validationDtos;
    }

    public MetadataSampleTsv sampleTsv(MetadataDto metadataDto){
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

    public MetadataSharingTsv sharingTsv(MetadataDto metadataDto) {
        return new MetadataSharingTsv()
                .setField(DataConstants.EMPTY)
                .setModelId(metadataDto.getModelID())
                .setProviderType(DataConstants.EMPTY)
                .setAccessibility(DataConstants.EMPTY)
                .setEuropdxAccessModality(DataConstants.EMPTY)
                .setEmail(DataConstants.EMPTY)
                .setName(DataConstants.EMPTY)
                .setFormUrl(UrlConstants.PDMR_CONTACT_URL)
                .setDatabaseUrl(metadataDto.getSourceUrl())
                .setProviderName(DataConstants.PDMR_FULL_NAME)
                .setProviderAbbreviation(DataConstants.PDMR_ABBREV)
                .setProject(DataConstants.EMPTY);
    }
}
