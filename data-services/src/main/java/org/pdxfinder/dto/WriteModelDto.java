package org.pdxfinder.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "Field",
        "model_id",
        "host_strain",
        "host_strain_full",
        "engraftment_site",
        "engraftment_type",
        "sample_type",
        "sample_state",
        "passage_number",
        "publications",
})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WriteModelDto {

    @JsonProperty("Field")
    private String field;

    @JsonProperty("model_id")
    private String modelId;

    @JsonProperty("host_strain")
    private String hostStrain;

    @JsonProperty("host_strain_full")
    private String hostStrainFull;

    @JsonProperty("engraftment_site")
    private String engraftmentSite;

    @JsonProperty("engraftment_type")
    private String engraftmentType;

    @JsonProperty("sample_type")
    private String sampleType;

    @JsonProperty("sample_state")
    private String sampleState;

    @JsonProperty("passage_number")
    private String passageNumber;

    @JsonProperty("publications")
    private String publications;

    public WriteModelDto setField(String field) {
        this.field = field;
        return this;
    }

    public WriteModelDto setModelId(String modelId) {
        this.modelId = modelId;
        return this;
    }

    public WriteModelDto setHostStrain(String hostStrain) {
        this.hostStrain = hostStrain;
        return this;
    }

    public WriteModelDto setHostStrainFull(String hostStrainFull) {
        this.hostStrainFull = hostStrainFull;
        return this;
    }

    public WriteModelDto setEngraftmentSite(String engraftmentSite) {
        this.engraftmentSite = engraftmentSite;
        return this;
    }

    public WriteModelDto setEngraftmentType(String engraftmentType) {
        this.engraftmentType = engraftmentType;
        return this;
    }

    public WriteModelDto setSampleType(String sampleType) {
        this.sampleType = sampleType;
        return this;
    }

    public WriteModelDto setSampleState(String sampleState) {
        this.sampleState = sampleState;
        return this;
    }

    public WriteModelDto setPassageNumber(String passageNumber) {
        this.passageNumber = passageNumber;
        return this;
    }

    public WriteModelDto setPublications(String publications) {
        this.publications = publications;
        return this;
    }

    public String getField() {
        return field;
    }

    public WriteModelDto createMetadataModel() {
        return this;
    }

    public String getModelId() {
        return modelId;
    }

    public String getHostStrain() {
        return hostStrain;
    }

    public String getHostStrainFull() {
        return hostStrainFull;
    }

    public String getEngraftmentSite() {
        return engraftmentSite;
    }

    public String getEngraftmentType() {
        return engraftmentType;
    }

    public String getSampleType() {
        return sampleType;
    }

    public String getSampleState() {
        return sampleState;
    }

    public String getPassageNumber() {
        return passageNumber;
    }

    public String getPublications() {
        return publications;
    }

}
