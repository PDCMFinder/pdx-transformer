package org.pdxfinder.result.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "Field",
        "patient_id",
        "sample_id",
        "collection_date",
        "collection_event",
        "months_since_collection_1",
        "age_in_years_at_collection",
        "diagnosis",
        "tumour_type",
        "primary_site",
        "collection_site",
        "stage",
        "staging_system",
        "grade",
        "grading_system",
        "virology_status",
        "sharable",
        "treatment_naive_at_collection",
        "treated",
        "prior_treatment",
        "model_id",
})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MetadataSampleTsv {


    @JsonProperty("Field")
    private String field;

    @JsonProperty("patient_id")
    private String patientId;

    @JsonProperty("sample_id")
    private String sampleId;

    @JsonProperty("collection_date")
    private String collectionDate;

    @JsonProperty("collection_event")
    private String collectionEvent;

    @JsonProperty("months_since_collection_1")
    private String monthsSinceCollectionOne;

    @JsonProperty("age_in_years_at_collection")
    private String ageInYearsAtCollection;

    @JsonProperty("diagnosis")
    private String diagnosis;

    @JsonProperty("tumour_type")
    private String tumourType;

    @JsonProperty("primary_site")
    private String primarySite;

    @JsonProperty("collection_site")
    private String collectionSite;

    @JsonProperty("stage")
    private String stage;

    @JsonProperty("staging_system")
    private String stagingSystem;

    @JsonProperty("grade")
    private String grade;

    @JsonProperty("grading_system")
    private String gradingSystem;

    @JsonProperty("virology_status")
    private String virologyStatus;

    @JsonProperty("sharable")
    private String sharable;

    @JsonProperty("treatment_naive_at_collection")
    private String treatmenNaiveAtCollection;

    @JsonProperty("treated")
    private String treated;

    @JsonProperty("prior_treatment")
    private String priorTreatment;

    @JsonProperty("model_id")
    private String modelId;

    public MetadataSampleTsv() {
        this.field = "";
        this.patientId = "";
        this.sampleId = "";
        this.collectionDate = "";
        this.collectionEvent = "";
        this.monthsSinceCollectionOne = "";
        this.ageInYearsAtCollection = "";
        this.diagnosis = "";
        this.tumourType = "";
        this.primarySite = "";
        this.collectionSite = "";
        this.stage = "";
        this.stagingSystem = "";
        this.grade = "";
        this.gradingSystem = "";
        this.virologyStatus = "";
        this.sharable = "";
        this.treatmenNaiveAtCollection = "";
        this.treated = "";
        this.priorTreatment = "";
        this.modelId = "";
    }

    public MetadataSampleTsv setField(String field) {
        this.field = field;
        return this;
    }

    public MetadataSampleTsv setPatientId(String patientId) {
        this.patientId = patientId;
        return this;
    }

    public MetadataSampleTsv setSampleId(String sampleId) {
        this.sampleId = sampleId;
        return this;
    }

    public MetadataSampleTsv setCollectionDate(String collectionDate) {
        this.collectionDate = collectionDate;
        return this;
    }

    public MetadataSampleTsv setCollectionEvent(String collectionEvent) {
        this.collectionEvent = collectionEvent;
        return this;
    }

    public MetadataSampleTsv setMonthsSinceCollectionOne(String monthsSinceCollectionOne) {
        this.monthsSinceCollectionOne = monthsSinceCollectionOne;
        return this;
    }

    public MetadataSampleTsv setAgeInYearsAtCollection(String ageInYearsAtCollection) {
        this.ageInYearsAtCollection = ageInYearsAtCollection;
        return this;
    }

    public MetadataSampleTsv setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
        return this;
    }

    public MetadataSampleTsv setTumourType(String tumourType) {
        this.tumourType = tumourType;
        return this;
    }

    public MetadataSampleTsv setPrimarySite(String primarySite) {
        this.primarySite = primarySite;
        return this;
    }

    public MetadataSampleTsv setCollectionSite(String collectionSite) {
        this.collectionSite = collectionSite;
        return this;
    }

    public MetadataSampleTsv setStage(String stage) {
        this.stage = stage;
        return this;
    }

    public MetadataSampleTsv setStagingSystem(String stagingSystem) {
        this.stagingSystem = stagingSystem;
        return this;
    }

    public MetadataSampleTsv setGrade(String grade) {
        this.grade = grade;
        return this;
    }

    public MetadataSampleTsv setGradingSystem(String gradingSystem) {
        this.gradingSystem = gradingSystem;
        return this;
    }

    public MetadataSampleTsv setVirologyStatus(String virologyStatus) {
        this.virologyStatus = virologyStatus;
        return this;
    }

    public MetadataSampleTsv setSharable(String sharable) {
        this.sharable = sharable;
        return this;
    }

    public MetadataSampleTsv setTreatmenNaiveAtCollection(String treatmenNaiveAtCollection) {
        this.treatmenNaiveAtCollection = treatmenNaiveAtCollection;
        return this;
    }

    public MetadataSampleTsv setTreated(String treated) {
        this.treated = treated;
        return this;
    }

    public MetadataSampleTsv setPriorTreatment(String priorTreatment) {
        this.priorTreatment = priorTreatment;
        return this;
    }

    public MetadataSampleTsv setModelId(String modelId) {
        this.modelId = modelId;
        return this;
    }

    public MetadataSampleTsv createMetadataSampleTsv() {
        return this;
    }


    public String getField() {
        return field;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getSampleId() {
        return sampleId;
    }

    public String getCollectionDate() {
        return collectionDate;
    }

    public String getCollectionEvent() {
        return collectionEvent;
    }

    public String getMonthsSinceCollectionOne() {
        return monthsSinceCollectionOne;
    }

    public String getAgeInYearsAtCollection() {
        return ageInYearsAtCollection;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getTumourType() {
        return tumourType;
    }

    public String getPrimarySite() {
        return primarySite;
    }

    public String getCollectionSite() {
        return collectionSite;
    }

    public String getStage() {
        return stage;
    }

    public String getStagingSystem() {
        return stagingSystem;
    }

    public String getGrade() {
        return grade;
    }

    public String getGradingSystem() {
        return gradingSystem;
    }

    public String getVirologyStatus() {
        return virologyStatus;
    }

    public String getSharable() {
        return sharable;
    }

    public String getTreatmenNaiveAtCollection() {
        return treatmenNaiveAtCollection;
    }

    public String getTreated() {
        return treated;
    }

    public String getPriorTreatment() {
        return priorTreatment;
    }

    public String getModelId() {
        return modelId;
    }
}
