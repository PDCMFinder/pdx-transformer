package org.pdxfinder.dto;


import com.fasterxml.jackson.annotation.*;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
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
        "Tumor Type",
        "Stage Classification",
        "Stage Value",
        "Grade Classification",
        "Grade Value",
        "Sample Type",
        "Samples",
        "Strain",
        "host_strain_full",
        "Mouse Sex",
        "Treatments",
        "Treatment Naive",
        "Engraftment Site",
        "Engraftment Type",
        "Extraction Method",
        "Date At Collection",
        "Accessibility",
        "Validations",
        "Source url"
})
public class PdxDto {

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

    @JsonProperty("Strain")
    private String hostStrain;

    @JsonProperty("host_strain_full")
    private String hostStrainFull;

    @JsonProperty("Mouse Sex")
    private String mouseSex;

    @JsonProperty("Treatment Naive")
    private String treatmentNaive;

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

    @JsonProperty("Accessibility")
    private String accessibility;

    @JsonProperty("Treatments")
    private List<TreatmentDto> treatmentDtos;

    @JsonProperty("Validations")
    private List<ValidationDto> validationDtos;

    @JsonProperty("Samples")
    private List<SampleDto> sampleDtos;


    public PdxDto() {
    }

    public String getModelID() {
        return modelID;
    }

    public PdxDto setModelID(String modelID) {
        this.modelID = modelID;
        return this;
    }

    public String getPatientID() {
        return patientID;
    }

    public PdxDto setPatientID(String patientID) {
        this.patientID = patientID;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public PdxDto setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getAge() {
        return age;
    }

    public PdxDto setAge(String age) {
        this.age = age;
        return this;
    }

    public String getRace() {
        return race;
    }

    public PdxDto setRace(String race) {
        this.race = race;
        return this;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public PdxDto setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
        return this;
    }

    public String getSpecimenSite() {
        return specimenSite;
    }

    public PdxDto setSpecimenSite(String specimenSite) {
        this.specimenSite = specimenSite;
        return this;
    }

    public String getPrimarySite() {
        return primarySite;
    }

    public PdxDto setPrimarySite(String primarySite) {
        this.primarySite = primarySite;
        return this;
    }

    public String getInitialDiagnosis() {
        return initialDiagnosis;
    }

    public PdxDto setInitialDiagnosis(String initialDiagnosis) {
        this.initialDiagnosis = initialDiagnosis;
        return this;
    }

    public String getClinicalDiagnosis() {
        return clinicalDiagnosis;
    }

    public PdxDto setClinicalDiagnosis(String clinicalDiagnosis) {
        this.clinicalDiagnosis = clinicalDiagnosis;
        return this;
    }

    public String getTumorType() {
        return tumorType;
    }

    public PdxDto setTumorType(String tumorType) {
        this.tumorType = tumorType;
        return this;
    }

    public String getStageClassification() {
        return stageClassification;
    }

    public PdxDto setStageClassification(String stageClassification) {
        this.stageClassification = stageClassification;
        return this;
    }

    public String getStageValue() {
        return stageValue;
    }

    public PdxDto setStageValue(String stageValue) {
        this.stageValue = stageValue;
        return this;
    }

    public String getGradeClassification() {
        return gradeClassification;
    }

    public PdxDto setGradeClassification(String gradeClassification) {
        this.gradeClassification = gradeClassification;
        return this;
    }

    public String getGradeValue() {
        return gradeValue;
    }

    public PdxDto setGradeValue(String gradeValue) {
        this.gradeValue = gradeValue;
        return this;
    }

    public String getSampleType() {
        return sampleType;
    }

    public PdxDto setSampleType(String sampleType) {
        this.sampleType = sampleType;
        return this;
    }

    public String getHostStrainFull() {
        return hostStrainFull;
    }

    public PdxDto setHostStrainFull(String hostStrainFull) {
        this.hostStrainFull = hostStrainFull;
        return this;
    }

    public String getHostStrain() {
        return hostStrain;
    }

    public PdxDto setHostStrain(String hostStrain) {
        this.hostStrain = hostStrain;
        return this;
    }

    public String getMouseSex() {
        return mouseSex;
    }

    public PdxDto setMouseSex(String mouseSex) {
        this.mouseSex = mouseSex;
        return this;
    }

    public PdxDto setTreatmentDtos(List<TreatmentDto> treatmentDtos) {
        this.treatmentDtos = treatmentDtos;
        return this;
    }

    public List<TreatmentDto> getTreatmentDtos() {
        return treatmentDtos;
    }

    public String getTreatmentNaive() {
        return treatmentNaive;
    }

    public PdxDto setTreatmentNaive(String treatmentNaive) {
        this.treatmentNaive = treatmentNaive;
        return this;
    }

    public String getEngraftmentSite() {
        return engraftmentSite;
    }

    public PdxDto setEngraftmentSite(String engraftmentSite) {
        this.engraftmentSite = engraftmentSite;
        return this;
    }

    public String getEngraftmentType() {
        return engraftmentType;
    }

    public PdxDto setEngraftmentType(String engraftmentType) {
        this.engraftmentType = engraftmentType;
        return this;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public PdxDto setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
        return this;
    }

    public String getExtractionMethod() {
        return extractionMethod;
    }

    public PdxDto setExtractionMethod(String extractionMethod) {
        this.extractionMethod = extractionMethod;
        return this;
    }

    public String getDateAtCollection() {
        return dateAtCollection;
    }

    public PdxDto setDateAtCollection(String dateAtCollection) {
        this.dateAtCollection = dateAtCollection;
        return this;
    }

    public String getAccessibility() {
        return accessibility;
    }

    public PdxDto setAccessibility(String accessibility) {
        this.accessibility = accessibility;
        return this;
    }

    public List<ValidationDto> getValidationDtos() {
        return validationDtos;
    }

    public List<SampleDto> getSampleDtos() {
        return sampleDtos;
    }

    public PdxDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public PdxDto setValidationDtos(List<ValidationDto> validationDtos) {
        this.validationDtos = validationDtos;
        return this;
    }

    public PdxDto setSampleDtos(List<SampleDto> sampleDtos) {
        this.sampleDtos = sampleDtos;
        return this;
    }

    public PdxDto build() {
        return this;
    }
}



