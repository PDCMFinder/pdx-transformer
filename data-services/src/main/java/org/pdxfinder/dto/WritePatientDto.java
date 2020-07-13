package org.pdxfinder.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "Field",
        "patient_id",
        "sex",
        "history",
        "ethnicity",
        "ethnicity_assessment_method",
        "initial_diagnosis",
        "age_at_initial_diagnosis",
})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WritePatientDto {

    @JsonProperty("Field")
    private String field;

    @JsonProperty("patient_id")
    private String patientId;

    @JsonProperty("sex")
    private String sex;

    @JsonProperty("history")
    private String history;

    @JsonProperty("ethnicity")
    private String ethnicity;

    @JsonProperty("ethnicity_assessment_method")
    private String ethnicityAssessmentMethod;

    @JsonProperty("initial_diagnosis")
    private String initialDiagnosis;

    @JsonProperty("age_at_initial_diagnosis")
    private String ageAtInitialDiagnosis;

    public WritePatientDto setField(String field) {
        this.field = field;
        return this;
    }

    public WritePatientDto setPatientId(String patientId) {
        this.patientId = patientId;
        return this;
    }

    public WritePatientDto setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public WritePatientDto setHistory(String history) {
        this.history = history;
        return this;
    }

    public WritePatientDto setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
        return this;
    }

    public WritePatientDto setEthnicityAssessmentMethod(String ethnicityAssessmentMethod) {
        this.ethnicityAssessmentMethod = ethnicityAssessmentMethod;
        return this;
    }

    public WritePatientDto setInitialDiagnosis(String initialDiagnosis) {
        this.initialDiagnosis = initialDiagnosis;
        return this;
    }

    public WritePatientDto setAgeAtInitialDiagnosis(String ageAtInitialDiagnosis) {
        this.ageAtInitialDiagnosis = ageAtInitialDiagnosis;
        return this;
    }

    public String getField() {
        return field;
    }

    public WritePatientDto createMetadataPatient() {
        return this;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getSex() {
        return sex;
    }

    public String getHistory() {
        return history;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public String getEthnicityAssessmentMethod() {
        return ethnicityAssessmentMethod;
    }

    public String getInitialDiagnosis() {
        return initialDiagnosis;
    }

    public String getAgeAtInitialDiagnosis() {
        return ageAtInitialDiagnosis;
    }
}

