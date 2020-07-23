package org.pdxfinder.result.dto;

import com.fasterxml.jackson.annotation.*;
import org.pdxfinder.constant.DataConstants;

import java.util.Objects;

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
        "publications"
})
public class MetadataModelTsv {

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

    public MetadataModelTsv() {
        this.field = "";
        this.modelId = "";
        this.hostStrain = "";
        this.hostStrainFull = "";
        this.engraftmentSite = "";
        this.engraftmentType = "";
        this.sampleType = "";
        this.sampleState = "";
        this.passageNumber = "";
        this.publications = "";
    }

    public MetadataModelTsv setField(String field) {
        this.field = field;
        return this;
    }

    public MetadataModelTsv setModelId(String modelId) {
        this.modelId = modelId;
        return this;
    }

    public MetadataModelTsv setHostStrain(String hostStrain) {
        this.hostStrain = hostStrain;
        return this;
    }

    public MetadataModelTsv setHostStrainFull(String hostStrainFull) {
        this.hostStrainFull = hostStrainFull;
        return this;
    }

    public MetadataModelTsv setEngraftmentSite(String engraftmentSite) {
        this.engraftmentSite = engraftmentSite;
        return this;
    }

    public MetadataModelTsv setEngraftmentType(String engraftmentType) {
        this.engraftmentType = engraftmentType;
        return this;
    }

    public MetadataModelTsv setSampleType(String sampleType) {
        this.sampleType = sampleType;
        return this;
    }

    public MetadataModelTsv setSampleState(String sampleState) {
        this.sampleState = sampleState;
        return this;
    }

    public MetadataModelTsv setPassageNumber(String passageNumber) {
        this.passageNumber = passageNumber;
        return this;
    }

    public MetadataModelTsv setPublications(String publications) {
        this.publications = publications;
        return this;
    }

    public String getField() {
        return field;
    }

    public MetadataModelTsv createMetadataModel() {
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
        return Objects.toString(engraftmentType, DataConstants.EMPTY);
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
