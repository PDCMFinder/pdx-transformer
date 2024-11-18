package org.pdxfinder.services.common.dto;


import com.fasterxml.jackson.annotation.*;
import org.pdxfinder.services.result.dto.MetadataCellModelTsv;
import org.pdxfinder.services.result.dto.MetadataSampleTsv;
import org.pdxfinder.services.result.dto.MetadataSharingTsv;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "Model ID",
        "Patient ID",
        "Gender",
        "Age",
        "Race",
        "Ethnicity",
        "Specimen Site",
        "Primary Site",
        "Initial Diagnosis",
        "Clinical Diagnosis",
        "Clinical Diagnosis Notes",
        "Tumor Type",
        "Stage Classification",
        "Stage Value",
        "Grade Classification",
        "Grade Value",
        "Sample Type",
        "Samples",
        "Host Strain",
        "host_strain_full",
        "Mouse Sex",
        "Treatments",
        "Treatment Naive",
        "Engraftment Site",
        "Engraftment Type",
        "Extraction Method",
        "Date At Collection",
        "Age at Collection",
        "Accessibility",
        "Validations",
        "Source url",

        "model_name",
        "model_name_aliases",
        "model_type",
        "parent_id",
        "origin_patient_sample_id",
        "growth_properties",
        "media_id",
        "growth_media",
        "plate_coating",
        "other_plate_coating",
        "passage_number",
        "contaminated",
        "contamination_details",
        "supplements",
        "drug",
        "drug_concentration",
        "publications",
        "supplier",
        "supplier_type",
        "catalog_number",
        "vendor_link",
        "rrid",
        "external_ids",
        "comments",

        "sample_state",
        "publications",
        "history",
        "smokingStatus",
        "ethnicity_assessment_method",
        "age_at_initial_diagnosis",
        "sample_meta_data",
        "sharing",

})
public class MetadataDto {

    private Integer id;

    @JsonProperty("Model ID")
    private String modelID;

    @JsonProperty("Patient ID")
    private String patientID;

    @JsonProperty("Gender")
    private String gender;

    @JsonProperty("Age")
    private String age;

    @JsonProperty("Race")
    private String race;

    @JsonProperty("Ethnicity")
    private String ethnicity;

    @JsonProperty("Specimen Site")
    private String specimenSite;

    @JsonProperty("Primary Site")
    private String primarySite;

    @JsonProperty("Initial Diagnosis")
    private String initialDiagnosis;

    @JsonProperty("Clinical Diagnosis")
    private String clinicalDiagnosis;

    @JsonProperty("Clinical Diagnosis Notes")
    private String clinicalDiagnosisnotes;

    @JsonProperty("Tumor Type")
    private String tumorType;

    @JsonProperty("Stage Classification")
    private String stageClassification;

    @JsonProperty("Stage Value")
    @JsonAlias("Tumor Stage")
    private String stageValue;

    @JsonProperty("Grade Classification")
    private String gradeClassification;

    @JsonProperty("Grade Value")
    @JsonAlias("Grades")
    private String gradeValue;

    @JsonProperty("Sample Type")
    private String sampleType;

    @JsonProperty("Host Strain")
    @JsonAlias("Strain")
    private String hostStrain;

    @JsonProperty("host_strain_full")
    private String hostStrainFull;

    @JsonProperty("Mouse Sex")
    private String mouseSex;

    @JsonProperty("Treatment Naive")
    private String treatmentNaive;

    @JsonProperty("smokingSatus")
    private String smokingStatus;

    @JsonProperty("Engraftment Site")
    private String engraftmentSite;

    @JsonProperty("Engraftment Type")
    private String engraftmentType;

    @JsonProperty("Source url")
    private String sourceUrl;

    @JsonProperty("Extraction Method")
    private String extractionMethod;

    @JsonProperty("Date At Collection")
    private String dateAtCollection;
    @JsonProperty("Age At Collection")
    private String age_in_years_at_collection;

    @JsonProperty("Accessibility")
    private String accessibility;

    @JsonProperty("Treatments")
    private List<TreatmentDto> treatmentDtos;

    @JsonProperty("Validations")
    private List<ValidationDto> validationDtos;

    @JsonProperty("Samples")
    private List<SampleDto> sampleDtos;


    @JsonProperty("sample_state")
    private String sampleState;

    @JsonProperty("publications")
    private String publications;

    @JsonProperty("history")
    private String history;

    @JsonProperty("ethnicity_assessment_method")
    private String ethnicityAssessmentMethod;

    @JsonProperty("age_at_initial_diagnosis")
    private String ageAtInitialDiagnosis;

    @JsonProperty("sample_meta_data")
    private MetadataSampleTsv metadataSampleTsv;

    @JsonProperty("sharing")
    private MetadataSharingTsv metadataSharingTsv;

    @JsonProperty("cellmodel")
    private MetadataCellModelTsv metadataCellModelTsv;


    @JsonProperty("model_name")
    private String model_name;

    @JsonProperty("model_name_aliases")
    private String model_name_aliases;


    @JsonProperty("parent_id")
    private String parent_id;

    @JsonProperty("origin_patient_sample_id")
    private String origin_patient_sample_id;

    @JsonProperty("growth_properties")
    private String growth_properties;

    @JsonProperty("media_id")
    private String media_id;

    @JsonProperty("growth_media")
    private String growth_media;

    @JsonProperty("plate_coating")
    private String plate_coating;

    @JsonProperty("other_plate_coating")
    private String other_plate_coating;

    @JsonProperty("passage_number")
    private String passage_number;

    @JsonProperty("contaminated")
    private String contaminated;

    @JsonProperty("contamination_details")
    private String contamination_details;

    @JsonProperty("supplements")
    private String supplements;

    @JsonProperty("drug")
    private String drug;

    @JsonProperty("drug_concentration")
    private String drug_concentration;

    @JsonProperty("supplier")
    private String supplier;

    @JsonProperty("supplier_type")
    private String supplier_type;

    @JsonProperty("catalog_number")
    private String catalog_number;

    @JsonProperty("vendor_link")
    private String vendor_link;

    @JsonProperty("rrid")
    private String rrid;

    @JsonProperty("external_ids")
    private String external_ids;

    @JsonProperty("comments")
    private String comments;

    @JsonProperty("model_type")
    private String model_type;

    @JsonProperty("gene_mutation_status")
    private String geneMutationStatus;

    @JsonProperty("response_to_treatment")
    private String responseToTreatment;

    @JsonProperty("collection_method")
    private String collectionMethod;

    @JsonProperty("collection_site")
    private String collectionSite;

    public MetadataDto setsmokingStatus(String smokingStatus) {
        this.smokingStatus = smokingStatus;
        return this;
    }

    public MetadataDto setgeneMutationStatus(String geneMutationStatus) {
        this.geneMutationStatus = geneMutationStatus;
        return this;
    }
    public MetadataDto setresponseToTreatment(String responseToTreatment) {
        this.responseToTreatment = responseToTreatment;
        return this;
    }
    public MetadataDto setcollectionMethod(String collectionMethod) {
        this.collectionMethod = collectionMethod;
        return this;
    }

    public MetadataDto setcollectionSite(String collectionSite) {
        this.collectionSite = collectionSite;
        return this;
    }
    public String getSmokingStatus() {
        return smokingStatus;
    }

    public String collectionSite() {
        return collectionSite;
    }
    public String collectionMethod() {
        return collectionMethod;
    }

    public String responseToTreatment() {
        return responseToTreatment;
    }

    public String geneMutationStatus() {
        return geneMutationStatus;
    }

    public String getModel_type() {
        return model_type;
    }

    public MetadataDto setModel_type(String model_type) {
        this.model_type = model_type;
        return this;
    }

    public String getModel_name() {
        return model_name;
    }

    public MetadataDto setModel_name(String model_name) {
        this.model_name = model_name;
        return this;
    }

    public String getGrowth_properties() {
        return growth_properties;
    }

    public MetadataDto setGrowth_properties(String growth_properties) {
        this.growth_properties = growth_properties;
        return this;
    }

    public String getParent_id() {
        return parent_id;
    }

    public MetadataDto setParent_id(String parent_id) {
        this.parent_id = parent_id;
        return this;
    }

    public String getOrigin_patient_sample_id() {
        return origin_patient_sample_id;
    }

    public MetadataDto setOrigin_patient_sample_id(String origin_patient_sample_id) {
        this.origin_patient_sample_id = origin_patient_sample_id;
        return this;
    }

    public String getComments() {
        return comments;
    }

    public MetadataDto setComments(String comments) {
        this.comments = comments;
        return this;
    }

    public String getSupplier() {
        return supplier;
    }

    public MetadataDto setSupplier(String supplier) {
        this.supplier = supplier;
        return this;
    }

    public String getExternal_ids() {
        return external_ids;
    }

    public MetadataDto setExternal_ids(String external_ids) {
        this.external_ids = external_ids;
        return this;
    }

    public MetadataDto() {
    }

    public String getModelID() {
        return modelID;
    }

    public MetadataDto setModelID(String modelID) {
        this.modelID = modelID;
        return this;
    }

    public String getPatientID() {
        return patientID;
    }

    public MetadataDto setPatientID(String patientID) {
        this.patientID = patientID;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public MetadataDto setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getAge() {
        return age;
    }

    public MetadataDto setAge(String age) {
        this.age = age;
        return this;
    }

    public String getRace() {
        return race;
    }

    public MetadataDto setRace(String race) {
        this.race = race;
        return this;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public MetadataDto setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
        return this;
    }

    public String getSpecimenSite() {
        return specimenSite;
    }

    public MetadataDto setSpecimenSite(String specimenSite) {
        this.specimenSite = specimenSite;
        return this;
    }

    public String getPrimarySite() {
        return primarySite;
    }

    public MetadataDto setPrimarySite(String primarySite) {
        this.primarySite = primarySite;
        return this;
    }

    public String getInitialDiagnosis() {
        return initialDiagnosis;
    }

    public MetadataDto setInitialDiagnosis(String initialDiagnosis) {
        this.initialDiagnosis = initialDiagnosis;
        return this;
    }

    public String getClinicalDiagnosis() {
        return clinicalDiagnosis;
    }

    public String getClinicalDiagnosisnotes() {
        return clinicalDiagnosisnotes;
    }

    public MetadataDto setClinicalDiagnosisnotes(String clinicalDiagnosisnotes) {
        this.clinicalDiagnosisnotes = clinicalDiagnosisnotes;
        return this;
    }

    public String getSampleState() {
        return sampleState;
    }

    public String getPublications() {
        return publications;
    }

    public String getHistory() {
        return history;
    }

    public String getEthnicityAssessmentMethod() {
        return ethnicityAssessmentMethod;
    }

    public String getAgeAtInitialDiagnosis() {
        return ageAtInitialDiagnosis;
    }

    public MetadataSharingTsv getMetadataSharingTsv() {
        return metadataSharingTsv;
    }



    public MetadataDto setClinicalDiagnosis(String clinicalDiagnosis) {
        this.clinicalDiagnosis = clinicalDiagnosis;
        return this;
    }

    public String getTumorType() {
        return tumorType;
    }

    public MetadataDto setTumorType(String tumorType) {
        this.tumorType = tumorType;
        return this;
    }

    public String getStageClassification() {
        return stageClassification;
    }

    public MetadataDto setStageClassification(String stageClassification) {
        this.stageClassification = stageClassification;
        return this;
    }

    public String getStageValue() {
        return stageValue;
    }

    public MetadataDto setStageValue(String stageValue) {
        this.stageValue = stageValue;
        return this;
    }

    public String getGradeClassification() {
        return gradeClassification;
    }

    public MetadataDto setGradeClassification(String gradeClassification) {
        this.gradeClassification = gradeClassification;
        return this;
    }

    public String getGradeValue() {
        return gradeValue;
    }

    public MetadataDto setGradeValue(String gradeValue) {
        this.gradeValue = gradeValue;
        return this;
    }

    public String getSampleType() {
        return sampleType;
    }

    public MetadataDto setSampleType(String sampleType) {
        this.sampleType = sampleType;
        return this;
    }

    public String getHostStrainFull() {
        return hostStrainFull;
    }

    public MetadataDto setHostStrainFull(String hostStrainFull) {
        this.hostStrainFull = hostStrainFull;
        return this;
    }

    public String getHostStrain() {
        return hostStrain;
    }

    public List<ValidationDto> getValidationDtos() {
        return validationDtos;
    }

    public List<TreatmentDto> getTreatmentDtos() {
        return Optional.ofNullable(treatmentDtos).orElse(new ArrayList<>());
    }

    public String getTreatmentNaive() {
        return treatmentNaive;
    }

    public String getEngraftmentSite() {
        return engraftmentSite;
    }

    public String getEngraftmentType() {
        return engraftmentType;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public List<SampleDto> getSampleDtos() {
        return sampleDtos;
    }

    public String getAccessibility() {
        return accessibility;
    }

    public String getDateAtCollection() {
        return dateAtCollection;
    }

    public String getAge_in_years_at_collection() {
        return age_in_years_at_collection;
    }

    public MetadataDto setAge_in_years_at_collection(String age_in_years_at_collection) {
        this.age_in_years_at_collection = age_in_years_at_collection;
        return this;
    }

    public String getExtractionMethod() {
        return extractionMethod;
    }

    public MetadataSampleTsv getMetadataSampleTsv() {
        return metadataSampleTsv;
    }


    public MetadataDto setHostStrain(String hostStrain) {
        this.hostStrain = hostStrain;
        return this;
    }

    public String getMouseSex() {
        return mouseSex;
    }

    public MetadataDto setMouseSex(String mouseSex) {
        this.mouseSex = mouseSex;
        return this;
    }

    public MetadataDto setTreatmentDtos(List<TreatmentDto> treatmentDtos) {
        this.treatmentDtos = treatmentDtos;
        return this;
    }

    public MetadataDto setTreatmentNaive(String treatmentNaive) {
        this.treatmentNaive = treatmentNaive;
        return this;
    }

    public MetadataDto setEngraftmentSite(String engraftmentSite) {
        this.engraftmentSite = engraftmentSite;
        return this;
    }

    public MetadataDto setEngraftmentType(String engraftmentType) {
        this.engraftmentType = engraftmentType;
        return this;
    }

    public MetadataDto setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
        return this;
    }

    public MetadataDto setExtractionMethod(String extractionMethod) {
        this.extractionMethod = extractionMethod;
        return this;
    }

    public MetadataDto setDateAtCollection(String dateAtCollection) {
        this.dateAtCollection = dateAtCollection;
        return this;
    }

    public MetadataDto setAccessibility(String accessibility) {
        this.accessibility = accessibility;
        return this;
    }

    public MetadataDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public MetadataDto setValidationDtos(List<ValidationDto> validationDtos) {
        this.validationDtos = validationDtos;
        return this;
    }

    public MetadataDto setSampleDtos(List<SampleDto> sampleDtos) {
        this.sampleDtos = sampleDtos;
        return this;
    }

    public MetadataDto setSampleState(String sampleState) {
        this.sampleState = sampleState;
        return this;
    }

    public MetadataDto setPublications(String publications) {
        this.publications = publications;
        return this;
    }

    public MetadataDto setHistory(String history) {
        this.history = history;
        return this;
    }

    public MetadataDto setEthnicityAssessmentMethod(String ethnicityAssessmentMethod) {
        this.ethnicityAssessmentMethod = ethnicityAssessmentMethod;
        return this;
    }

    public MetadataDto setAgeAtInitialDiagnosis(String ageAtInitialDiagnosis) {
        this.ageAtInitialDiagnosis = ageAtInitialDiagnosis;
        return this;
    }

    public MetadataDto setMetadataSampleTsv(MetadataSampleTsv metadataSampleTsv) {
        this.metadataSampleTsv = metadataSampleTsv;
        return this;
    }

    public MetadataDto setMetadataSharingTsv(MetadataSharingTsv metadataSharingTsv) {
        this.metadataSharingTsv = metadataSharingTsv;
        return this;
    }


    public MetadataCellModelTsv getMetadataCellModelTsv() {
        return metadataCellModelTsv;
    }

    public MetadataDto setMetadataCellModelTsv(MetadataCellModelTsv metadataCellModelTsv) {
        this.metadataCellModelTsv = metadataCellModelTsv;
        return this;
    }

    public String model_name_aliases() {
        return model_name_aliases;
    }

    public MetadataDto setModel_name_aliases(String model_name_aliases) {
        this.model_name_aliases = model_name_aliases;
        return this;
    }

    public String media_id() {
        return media_id;
    }

    public MetadataDto setMedia_id(String media_id) {
        this.media_id = media_id;
        return this;
    }

    public String growth_media() {
        return growth_media;
    }

    public MetadataDto setGrowth_media(String growth_media) {
        this.growth_media = growth_media;
        return this;
    }

    public String plate_coating() {
        return plate_coating;
    }

    public MetadataDto setPlate_coating(String plate_coating) {
        this.plate_coating = plate_coating;
        return this;
    }

    public String other_plate_coating() {
        return other_plate_coating;
    }

    public MetadataDto setOther_plate_coating(String other_plate_coating) {
        this.other_plate_coating = other_plate_coating;
        return this;
    }

    public String passage_number() {
        return passage_number;
    }

    public MetadataDto setPassage_number(String passage_number) {
        this.passage_number = passage_number;
        return this;
    }

    public String contaminated() {
        return contaminated;
    }

    public MetadataDto setContaminated(String contaminated) {
        this.contaminated = contaminated;
        return this;
    }

    public String contamination_details() {
        return contamination_details;
    }

    public MetadataDto setContamination_details(String contamination_details) {
        this.contamination_details = contamination_details;
        return this;
    }

    public String supplements() {
        return supplements;

    }

    public MetadataDto setSupplements(String supplements) {
        this.supplements = supplements;
        return this;
    }

    public String drug() {
        return drug;
    }

    public MetadataDto setDrug(String drug) {
        this.drug = drug;
        return this;
    }

    public String drug_concentration() {
        return drug_concentration;
    }

    public MetadataDto setDrug_concentration(String drug_concentration) {
        this.drug_concentration = drug_concentration;
        return this;
    }

    public String supplier_type() {
        return supplier_type;
    }

    public MetadataDto setSupplier_type(String supplier_type) {
        this.supplier_type = supplier_type;
        return this;
    }

    public String catalog_number() {
        return catalog_number;
    }

    public MetadataDto setCatalog_number(String catalog_number) {
        this.catalog_number = catalog_number;
        return this;
    }

    public String vendor_link() {
        return vendor_link;
    }

    public MetadataDto setVendor_link(String vendor_link) {
        this.vendor_link = vendor_link;
        return this;
    }

    public String rrid() {
        return rrid;
    }

    public MetadataDto setRrid(String rrid) {
        this.rrid = rrid;
        return this;
    }



    public MetadataDto build() {
        return this;
    }
}



