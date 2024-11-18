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
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Extract {

    private Logger log = LoggerFactory.getLogger(Extract.class);
    private SpecimenSearch specimenSearch;
    private OracleDataDto extracted;
    private Map<String,String> accessions;
    private List growthProperties;

    public Extract(SpecimenSearch specimenSearch, OracleDataDto extracted, AccessionsDTO accessions) {
        this.specimenSearch = specimenSearch;
        this.extracted = extracted;
        this.accessions = accessions.getAccessionMap();
        this.growthProperties = extracted.getGrowthProperties();
    }

    public String getModelId(){
        String pdmTypeDesc = specimenSearch.getPdmtypedescription();
        String tissueTypeDesc = specimenSearch.getTissuetypedescription();
        String modelID = "";
        String sampleId = "";
        if (!pdmTypeDesc.equals(CancerModelTypes.CANCER_ASSOCIATED_FIBROBLASTS_CULTURE) && (tissueTypeDesc.equals(TissueTypeConstants.RESECTION) || tissueTypeDesc.equals(TissueTypeConstants.TUMOR_BIOPSY))) {
            // Separate model ids for cell model and organoid models
            if (pdmTypeDesc.equals(CancerModelTypes.ORGANOID_MODEL) || pdmTypeDesc.equals(CancerModelTypes.CELL_MODEL)){
                for (Sample dSample : extracted.getSamples()) {
                    if (specimenSearch.getSpecimenseqnbr().equals(dSample.getSpecimenseqnbr())) {
                        if(dSample.getPdmtypeseqnbr().equals(specimenSearch.getPdmtypeseqnbr())) {
                            sampleId = dSample.getSampleid().trim();
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

    public String getAgeAtDiagnosis(){
        String AgeAtDiagnosis = "";
        for (PatientInfo patient : extracted.getPatientList()) {
            if (specimenSearch.getPatientseqnbr().equals(patient.getPatientseqnbr())) {
                AgeAtDiagnosis = patient.getAgeatdiagnosisrange();
                AgeAtDiagnosis = AgeAtDiagnosis == null ? "" : AgeAtDiagnosis;
            }
        }
        return AgeAtDiagnosis;
    }
    public List<SampleDto> getSamples(String modelId){
        List<SampleDto> sampleDtoList = new ArrayList<>();
        for (Sample dSample : extracted.getSamples()) {
            if (specimenSearch.getSpecimenseqnbr().equals(dSample.getSpecimenseqnbr())) {
                String sampleId = dSample.getSampleid().trim().toUpperCase();
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
                    }
                    else if( (dSample.getPdmtypeseqnbr().equals(CancerModelTypes.ORGANOID_MODEL_seqNR) || dSample.getPdmtypeseqnbr().equals(CancerModelTypes.PDC_MODEL_seqNR))
                            && !dSample.getPdmtypeseqnbr().equals("5")){   // Organoid and cell models
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
                        }
                    else {
                        log.info(String.format("%s-%s is neither PDX, Patient Sample, Organoid nor PDC.", modelId, sampleId));
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
        Map<String, String> gp_map = extracted.getGrowthProperties().stream().collect(Collectors.toMap(GrowthProperties::getGrowthpropertyseqnbr, GrowthProperties::getGrowthpropertydescription));
        for (Sample dSample : extracted.getSamples()) {
            if (specimenSearch.getSpecimenseqnbr().equals(dSample.getSpecimenseqnbr())) {
                //String sampleId = dSample.getSampleid();
                if(dSample.getPdmtypeseqnbr().equals(CancerModelTypes.ORGANOID_MODEL_seqNR) || dSample.getPdmtypeseqnbr().equals(CancerModelTypes.PDC_MODEL_seqNR)) {
                    growth_property = gp_map.get(dSample.getGrowthpropertyseqnbr());
                    growth_property = growth_property.equals("Organoids") == true ? "" : growth_property ;
                }
            }
        }

        return growth_property;
    }

    public String getSupplements(){
        String supplements = "";
        Map<String, String> supplement_map = extracted.getRequiredMedia().stream().collect(Collectors.toMap(RequiredMedia::getRequiredmediaseqnbr, RequiredMedia::getRequiredmediadescription));
        for (Sample dSample : extracted.getSamples()) {
            if (specimenSearch.getSpecimenseqnbr().equals(dSample.getSpecimenseqnbr())) {
                //String sampleId = dSample.getSampleid();
                if(dSample.getPdmtypeseqnbr().equals(CancerModelTypes.ORGANOID_MODEL_seqNR) || dSample.getPdmtypeseqnbr().equals(CancerModelTypes.PDC_MODEL_seqNR)) {
                    supplements = supplement_map.get(dSample.getRequiredmediaseqnbr());
                }
            }
        }
        return supplements;
    }


    public String getcomments(){
        String comments = "";
        Map<String, String> MSIStatus = new HashMap<String, String>();
        MSIStatus.put("0", "Unkown");
        MSIStatus.put("1", "MSI-High");
        MSIStatus.put("2", "MSI-Stable");

        Map<String, String> CultureOrigin = new HashMap<String, String>();
        CultureOrigin.put("0", "Patient Tissue");
        CultureOrigin.put("1", "PDX Fragment");
        CultureOrigin.put("2", "Patient-Derived Organoid");
        CultureOrigin.put("3", "PDX-Derived Organoid");
        CultureOrigin.put("9", "Unkown");

        for (Sample dSample : extracted.getSamples()) {
            if (specimenSearch.getSpecimenseqnbr().equals(dSample.getSpecimenseqnbr())) {
                //String sampleId = dSample.getSampleid();
                if(dSample.getPdmtypeseqnbr().equals(CancerModelTypes.ORGANOID_MODEL_seqNR) || dSample.getPdmtypeseqnbr().equals(CancerModelTypes.PDC_MODEL_seqNR)) {
                    if (dSample.getCulturederivation() != null) {
                        StringBuilder comment = new StringBuilder(dSample.getCulturederivation());
                        if (dSample.getCultureoriginseqnbr() != null){
                            comment.append("; Origin: ").append(CultureOrigin.get(dSample.getCultureoriginseqnbr()));
                        }
                        if (dSample.getSubculturerecommendations() != null) {
                            comment.append("; Sub-culture: ").append(dSample.getSubculturerecommendations());
                        }
                        if (specimenSearch.getMsistatusseqnbr() != null) {
                            comment.append("; MSI Status: ").append(MSIStatus.get(specimenSearch.getMsistatusseqnbr()));
                        }
                        if (dSample.getProliferationrate() != null) {
                            comment.append("; Proliferation rate: ").append(dSample.getProliferationrate());
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
                if(dSample.getPdmtypeseqnbr().equals(CancerModelTypes.ORGANOID_MODEL_seqNR) || dSample.getPdmtypeseqnbr().equals(CancerModelTypes.PDC_MODEL_seqNR)) {
                    if(dSample.getCultureoriginseqnbr().equals("1")){
                        ParentId = String.format("%s-%s", specimenSearch.getPatientid(), specimenSearch.getSpecimenid());
                    }
                    //else if(dSample.getCultureoriginseqnbr().equals("2")){
                    //    ParentId = String.format("%s-%s", specimenSearch.getPatientid(), specimenSearch.getSpecimenid());
                    //}
                }
            }
        }

        return ParentId;

    }

    public String getgeneMutationStatus(){
        String geneMutationStatus = "";
        for (Sample dSample : extracted.getSamples()) {
            if (specimenSearch.getSpecimenseqnbr().equals(dSample.getSpecimenseqnbr())) {
                        geneMutationStatus = dSample.getFacsCharacterization() == null ? "" : dSample.getFacsCharacterization() ;
            }
        }
        return geneMutationStatus;

    }

    public String getresponseToTreatment(){
        String responseToTreatment = specimenSearch.getPriorbestresponse();
        responseToTreatment = responseToTreatment.equals("NA") ? "" : responseToTreatment;
        return responseToTreatment;
    }


    public String getcollectionSite(){
        String collectionSite = "";
        for (Specimen specimen : extracted.getSpecimenList()) {
            if (specimenSearch.getSpecimenseqnbr().equals(specimen.getSpecimenseqnbr())) {
                collectionSite = specimen.getBiopsysite() == null ? "" : specimen.getBiopsysite() ;
            }
        }
        return collectionSite;

    }
    public String getSupplier(){
        String contributor = "";
        Map<String, String> contributor_map = extracted.getContributors().stream().collect(Collectors.toMap(Contributors::getContributorseqnbr, Contributors::getContributorshortname));
        for (PatientInfo patient : extracted.getPatientList()) {
            if (specimenSearch.getPatientid().equals(patient.getPatientid())) {
                contributor = contributor_map.get(patient.getContributorseqnbr());
                contributor = contributor.equals("PDMR") == true ? "PDMR": "PDMR/"+contributor;
            }
        }
        return contributor;
    }



    public String getexternalID(){
        String externalID = "";
        String contributor = "";
        Map<String, String> contributor_map = extracted.getContributors().stream().collect(Collectors.toMap(Contributors::getContributorseqnbr, Contributors::getContributorshortname));

        for (PatientInfo patient : extracted.getPatientList()) {
            if (specimenSearch.getPatientid().equals(patient.getPatientid())) {
                externalID = patient.getContributorpdxid();
                externalID = externalID == null ? "" : externalID;

                contributor = contributor_map.get(patient.getContributorseqnbr());
                externalID = contributor + ": " + externalID;
                //contributor = contributor.equals("PDMR") == true ? "PDMR": "PDMR/"+contributor;
            }
        }
        return externalID;
    }

    public String getNotes(){
        String notes = "";
        for (PatientInfo patient : extracted.getPatientList()) {
            if (specimenSearch.getPatientseqnbr().equals(patient.getPatientseqnbr())) {
                if (patient.getNotes() != null) {
                    notes = patient.getNotes();
                }
            }
        }
        return notes;
    }

    public String getCollectionDate(){
        String collectionDate = "";
        for (Specimen specimen : extracted.getSpecimenList()) {
            if (specimenSearch.getSpecimenseqnbr().equals(specimen.getSpecimenseqnbr())) {
                if (specimen.getCollectiondate().toString() != null) {
                    collectionDate = specimen.getCollectiondate().toString();
                }
            }
        }
        return collectionDate;
    }
    public String getAgeInYearsAtCollection(){
        String ageAtCollection = "";
        for (Specimen specimen : extracted.getSpecimenList()) {
            if (specimenSearch.getSpecimenseqnbr().equals(specimen.getSpecimenseqnbr())) {
                if (specimen.getAgeatsamplingrange() != null) {
                    ageAtCollection = specimen.getAgeatsamplingrange();
                }
            }
        }
        return ageAtCollection;
    }
    public String gethistory(){
        String history = "";
        for (PatientInfo patient : extracted.getPatientList()) {
            if (specimenSearch.getPatientseqnbr().equals(patient.getPatientseqnbr())) {
                if (patient.getNotes() != null) {
                    history = patient.getAdditionalmedicalhistory();
                }
            }
        }
        return history;
    }

    public String getSmokingHistory(){
        String history = "";
        if (specimenSearch.getSmoked100Description().equals("Yes")){
            history = "Current Smoker";
            /*
            for (PatientInfo patient : extracted.getPatientList()) {
                if (specimenSearch.getPatientseqnbr().equals(patient.getPatientseqnbr())) {
                    if (patient.getNotes() != null) {
                        history = patient.getNotes();
                    }
                }
            }
            */
        }

        return history;
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
    public String getAvailability(String modelId){
        String availability = "";
        Map<String, String> availmap = new HashMap<String, String>();
        availmap.put("1", "Available");
        availmap.put("2", "Currently Unavailable");
        availmap.put("3", "Not for Distribution");
        availmap.put("4", "Available Upon Request");
        availmap.put("5", "Not Applicable");
        availmap.put("6", "DCTD Only (Restricted Use)");
        for (DistributionLot distributionLot: extracted.getDistributionLot()){
            if (distributionLot.distributionlotname().equals(modelId)){
                availability = distributionLot.cryopreservedfragmentsseqnbr() == "5" ? distributionLot.invitroculturematerialseqnbr() : distributionLot.cryopreservedfragmentsseqnbr();
                availability = availmap.get(availability);
            }
        }

        return availability;
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
                .setAgeInYearsAtCollection(metadataDto.getAge_in_years_at_collection())
                .setDiagnosis(metadataDto.getClinicalDiagnosis())
                .setTumourType(metadataDto.getTumorType())
                .setPrimarySite(metadataDto.getPrimarySite())
                .setStage(metadataDto.getStageValue())
                .setGrade(metadataDto.getGradeValue())
                .setCollectionMethod(metadataDto.getExtractionMethod())
                .setgeneMutationStatus(metadataDto.geneMutationStatus())
                .setCollectionMethod(metadataDto.collectionMethod())
                .setresponseToTreatment(metadataDto.responseToTreatment())

                .setStagingSystem(DataConstants.EMPTY)
                .setCollectionDate(metadataDto.getDateAtCollection())
                .setCollectionEvent(DataConstants.EMPTY)
                .setMonthsSinceCollectionOne(DataConstants.EMPTY)
                .setCollectionSite(metadataDto.collectionSite())
                .setGradingSystem(DataConstants.EMPTY)
                .setVirologyStatus(DataConstants.EMPTY)
                .setSharable("Yes")
                .setTreatmenNaiveAtCollection(metadataDto.getTreatmentNaive())
                .setTreated(DataConstants.EMPTY)
                .setPriorTreatment(DataConstants.EMPTY)
                .setModelId(metadataDto.getModelID());
    }
    LocalDate today = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String formattedDate = today.format(formatter);

    public MetadataSharingTsv sharingTsv(MetadataDto metadataDto) {
        return new MetadataSharingTsv()
                .setField(DataConstants.EMPTY)
                .setModelId(metadataDto.getModelID())
                .setdateSubmitted(formattedDate)
                .setAccessibility("Academia and Industry")
                .setEuropdxAccessModality(DataConstants.EMPTY)
                .setEmail("hilfikerp@mail.nih.gov")
                .setName("Pete Hilfiker")
                .setFormUrl(UrlConstants.PDMR_CONTACT_URL)
                .setDatabaseUrl(metadataDto.getSourceUrl())
                .setmodelAvailability(metadataDto.getAccessibility())
                .setlicense("CC0");
    }
}
