package org.pdxfinder.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

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

    private String modelID;

    private String patientID;
    private String gender;
    private String age;
    private String race;
    private String ethnicity;
    private String specimenSite;
    private String primarySite;
    private String initialDiagnosis;

    private String clinicalDiagnosis;
    private String tumorType;

    private String stageClassification;
    private String stageValue;
    private String gradeClassification;
    private String gradeValue;

    private String sampleType;
    private String strain;
    private String mouseSex;

    private String treatmentNaive;
    private String engraftmentSite;
    private String engraftmentType;
    private String sourceUrl;

    private String extractionMethod;
    private String dateAtCollection;
    private String accessibility;

    private List<TreatmentDto> treatmentDtos;
    private List<ValidationDto> validationDtos;
    private List<SampleDto> sampleDtos;


    public PdxDto() {
    }

    @JsonProperty("Model ID")
    public String getModelID() {
        return modelID;
    }

    @JsonProperty("Model ID")
    public PdxDto setModelID(String modelID) {
        this.modelID = modelID;
        return this;
    }

    @JsonProperty("Patient ID")
    public String getPatientID() {
        return patientID;
    }

    @JsonProperty("Patient ID")
    public PdxDto setPatientID(String patientID) {
        this.patientID = patientID;
        return this;
    }

    @JsonProperty("Gender")
    public String getGender() {
        return gender;
    }

    @JsonProperty("Gender")
    public PdxDto setGender(String gender) {
        this.gender = gender;
        return this;
    }

    @JsonProperty("Age")
    public String getAge() {
        return age;
    }

    @JsonProperty("Age")
    public PdxDto setAge(String age) {
        this.age = age;
        return this;
    }

    @JsonProperty("Race")
    public String getRace() {
        return race;
    }

    @JsonProperty("Race")
    public PdxDto setRace(String race) {
        this.race = race;
        return this;
    }

    @JsonProperty("Ethnicity")
    public String getEthnicity() {
        return ethnicity;
    }

    @JsonProperty("Ethnicity")
    public PdxDto setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
        return this;
    }

    @JsonProperty("Specimen Site")
    public String getSpecimenSite() {
        return specimenSite;
    }

    @JsonProperty("Specimen Site")
    public PdxDto setSpecimenSite(String specimenSite) {
        this.specimenSite = specimenSite;
        return this;
    }

    @JsonProperty("Primary Site")
    public String getPrimarySite() {
        return primarySite;
    }

    @JsonProperty("Primary Site")
    public PdxDto setPrimarySite(String primarySite) {
        this.primarySite = primarySite;
        return this;
    }

    @JsonProperty("Initial Diagnosis")
    public String getInitialDiagnosis() {
        return initialDiagnosis;
    }

    @JsonProperty("Initial Diagnosis")
    public PdxDto setInitialDiagnosis(String initialDiagnosis) {
        this.initialDiagnosis = initialDiagnosis;
        return this;
    }

    @JsonProperty("Clinical Diagnosis")
    public String getClinicalDiagnosis() {
        return clinicalDiagnosis;
    }

    @JsonProperty("Clinical Diagnosis")
    public PdxDto setClinicalDiagnosis(String clinicalDiagnosis) {
        this.clinicalDiagnosis = clinicalDiagnosis;
        return this;
    }

    @JsonProperty("Tumor Type")
    public String getTumorType() {
        return tumorType;
    }

    @JsonProperty("Tumor Type")
    public PdxDto setTumorType(String tumorType) {
        this.tumorType = tumorType;
        return this;
    }

    @JsonProperty("Stage Classification")
    public String getStageClassification() {
        return stageClassification;
    }

    @JsonProperty("Stage Classification")
    public PdxDto setStageClassification(String stageClassification) {
        this.stageClassification = stageClassification;
        return this;
    }

    @JsonProperty("Stage Value")
    public String getStageValue() {
        return stageValue;
    }


    @JsonProperty("Stage Value")
    public PdxDto setStageValue(String stageValue) {
        this.stageValue = stageValue;
        return this;
    }

    @JsonProperty("Grade Classification")
    public String getGradeClassification() {
        return gradeClassification;
    }

    @JsonProperty("Grade Classification")
    public PdxDto setGradeClassification(String gradeClassification) {
        this.gradeClassification = gradeClassification;
        return this;
    }

    @JsonProperty("Grade Value")
    public String getGradeValue() {
        return gradeValue;
    }

    @JsonProperty("Grade Value")
    public PdxDto setGradeValue(String gradeValue) {
        this.gradeValue = gradeValue;
        return this;
    }

    @JsonProperty("Sample Type")
    public String getSampleType() {
        return sampleType;
    }

    @JsonProperty("Sample Type")
    public PdxDto setSampleType(String sampleType) {
        this.sampleType = sampleType;
        return this;
    }

    @JsonProperty("Strain")
    public String getStrain() {
        return strain;
    }

    @JsonProperty("Strain")
    public PdxDto setStrain(String strain) {
        this.strain = strain;
        return this;
    }

    @JsonProperty("Mouse Sex")
    public String getMouseSex() {
        return mouseSex;
    }

    @JsonProperty("Mouse Sex")
    public PdxDto setMouseSex(String mouseSex) {
        this.mouseSex = mouseSex;
        return this;
    }

    @JsonProperty("Treatments")
    public PdxDto setTreatmentDtos(List<TreatmentDto> treatmentDtos) {
        this.treatmentDtos = treatmentDtos;
        return this;
    }

    @JsonProperty("Treatments")
    public List<TreatmentDto> getTreatmentDtos() {
        return treatmentDtos;
    }

    @JsonProperty("Treatment Naive")
    public String getTreatmentNaive() {
        return treatmentNaive;
    }

    @JsonProperty("Treatment Naive")
    public PdxDto setTreatmentNaive(String treatmentNaive) {
        this.treatmentNaive = treatmentNaive;
        return this;
    }

    @JsonProperty("Engraftment Site")
    public String getEngraftmentSite() {
        return engraftmentSite;
    }

    @JsonProperty("Engraftment Site")
    public PdxDto setEngraftmentSite(String engraftmentSite) {
        this.engraftmentSite = engraftmentSite;
        return this;
    }

    @JsonProperty("Engraftment Type")
    public String getEngraftmentType() {
        return engraftmentType;
    }

    @JsonProperty("Engraftment Type")
    public PdxDto setEngraftmentType(String engraftmentType) {
        this.engraftmentType = engraftmentType;
        return this;
    }

    @JsonProperty("Source url")
    public String getSourceUrl() {
        return sourceUrl;
    }

    @JsonProperty("Source url")
    public PdxDto setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
        return this;
    }

    @JsonProperty("Extraction Method")
    public String getExtractionMethod() {
        return extractionMethod;
    }

    @JsonProperty("Extraction Method")
    public PdxDto setExtractionMethod(String extractionMethod) {
        this.extractionMethod = extractionMethod;
        return this;
    }

    @JsonProperty("Date At Collection")
    public String getDateAtCollection() {
        return dateAtCollection;
    }

    @JsonProperty("Date At Collection")
    public PdxDto setDateAtCollection(String dateAtCollection) {
        this.dateAtCollection = dateAtCollection;
        return this;
    }

    @JsonProperty("Accessibility")
    public String getAccessibility() {
        return accessibility;
    }

    @JsonProperty("Accessibility")
    public PdxDto setAccessibility(String accessibility) {
        this.accessibility = accessibility;
        return this;
    }

    @JsonProperty("Validations")
    public List<ValidationDto> getValidationDtos() {
        return validationDtos;
    }

    @JsonProperty("Samples")
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



