package org.pdxfinder.dto.tsv;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "Field",
        "patient_id",
        "treatment_name",
        "treatment_dose",
        "treatment_starting_date",
        "treatment_duration",
        "treatment_event",
        "elapsed_time",
        "treatment_response",
        "response_classification",
        "Model ID"
})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PatientTreatmentTsv {

    @JsonProperty("Field")
    private String field;

    @JsonProperty("patient_id")
    private String patientId;

    @JsonProperty("treatment_name")
    private String treatmentName;

    @JsonProperty("treatment_dose")
    private String treatmentDose;

    @JsonProperty("treatment_starting_date")
    private String treatmentStartingDate;

    @JsonProperty("treatment_duration")
    private String treatmentDuration;

    @JsonProperty("treatment_event")
    private String treatmentEvent;

    @JsonProperty("elapsed_time")
    private String elapsedTime;

    @JsonProperty("treatment_response")
    private String treatmentResponse;

    @JsonProperty("response_classification")
    private String responseClassification;

    @JsonProperty("Model ID")
    private String modelId;

    public String getField() {
        return field;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getTreatmentName() {
        return treatmentName;
    }

    public String getTreatmentDose() {
        return treatmentDose;
    }

    public String getTreatmentStartingDate() {
        return treatmentStartingDate;
    }

    public String getTreatmentDuration() {
        return treatmentDuration;
    }

    public String getTreatmentEvent() {
        return treatmentEvent;
    }

    public String getElapsedTime() {
        return elapsedTime;
    }

    public String getTreatmentResponse() {
        return treatmentResponse;
    }

    public String getResponseClassification() {
        return responseClassification;
    }

    public String getModelId() {
        return modelId;
    }

    public PatientTreatmentTsv setField(String field) {
        this.field = field;
        return this;
    }

    public PatientTreatmentTsv setPatientId(String patientId) {
        this.patientId = patientId;
        return this;
    }

    public PatientTreatmentTsv setTreatmentName(String treatmentName) {
        this.treatmentName = treatmentName;
        return this;
    }

    public PatientTreatmentTsv setTreatmentDose(String treatmentDose) {
        this.treatmentDose = treatmentDose;
        return this;
    }

    public PatientTreatmentTsv setTreatmentStartingDate(String treatmentStartingDate) {
        this.treatmentStartingDate = treatmentStartingDate;
        return this;
    }

    public PatientTreatmentTsv setTreatmentDuration(String treatmentDuration) {
        this.treatmentDuration = treatmentDuration;
        return this;
    }

    public PatientTreatmentTsv setTreatmentEvent(String treatmentEvent) {
        this.treatmentEvent = treatmentEvent;
        return this;
    }

    public PatientTreatmentTsv setElapsedTime(String elapsedTime) {
        this.elapsedTime = elapsedTime;
        return this;
    }

    public PatientTreatmentTsv setTreatmentResponse(String treatmentResponse) {
        this.treatmentResponse = treatmentResponse;
        return this;
    }

    public PatientTreatmentTsv setResponseClassification(String responseClassification) {
        this.responseClassification = responseClassification;
        return this;
    }

    public PatientTreatmentTsv setModelId(String modelId) {
        this.modelId = modelId;
        return this;
    }

    public PatientTreatmentTsv build() {
        return this;
    }
}
