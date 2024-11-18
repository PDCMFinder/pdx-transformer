package org.pdxfinder.services.result.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "Field",
        "model_id",
        "accessibility",
        "europdx_access_modality",
        "date_submitted",
        "model_availability",
        "email",
        "name",
        "form_url",
        "database_url",
        "license"
})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MetadataSharingTsv {

    @JsonProperty("Field")
    private String field;

    @JsonProperty("model_id")
    private String modelId;

    @JsonProperty("accessibility")
    private String accessibility;

    @JsonProperty("europdx_access_modality")
    private String europdxAccessModality;

    @JsonProperty("email")
    private String email;

    @JsonProperty("name")
    private String name;

    @JsonProperty("form_url")
    private String formUrl;

    @JsonProperty("database_url")
    private String databaseUrl;

    @JsonProperty("date_submitted")
    private String dateSubmitted;

    @JsonProperty("model_availability")
    private String modelAvailability;

    @JsonProperty("license")
    private String license;

    public MetadataSharingTsv() {
        this.field = "";
        this.modelId = "";
        this.dateSubmitted = "";
        this.accessibility = "";
        this.europdxAccessModality = "";
        this.email = "";
        this.name = "";
        this.formUrl = "";
        this.databaseUrl = "";
        this.modelAvailability = "";
        this.license = "";

    }

    public MetadataSharingTsv setField(String field) {
        this.field = field;
        return this;
    }

    public MetadataSharingTsv setModelId(String modelId) {
        this.modelId = modelId;
        return this;
    }

    public MetadataSharingTsv setlicense(String license) {
        this.license = license;
        return this;
    }

    public MetadataSharingTsv setAccessibility(String accessibility) {
        this.accessibility = accessibility;
        return this;
    }

    public MetadataSharingTsv setEuropdxAccessModality(String europdxAccessModality) {
        this.europdxAccessModality = europdxAccessModality;
        return this;
    }

    public MetadataSharingTsv setEmail(String email) {
        this.email = email;
        return this;
    }

    public MetadataSharingTsv setName(String name) {
        this.name = name;
        return this;
    }

    public MetadataSharingTsv setFormUrl(String formUrl) {
        this.formUrl = formUrl;
        return this;
    }

    public MetadataSharingTsv setDatabaseUrl(String databaseUrl) {
        this.databaseUrl = databaseUrl;
        return this;
    }

    public MetadataSharingTsv setdateSubmitted(String dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
        return this;
    }

    public MetadataSharingTsv setmodelAvailability(String modelAvailability) {
        this.modelAvailability = modelAvailability;
        return this;
    }


    public MetadataSharingTsv build() {
        return this;
    }

    public String getField() {
        return field;
    }

    public String getModelId() {
        return modelId;
    }

    public String getDateSubmitted() {
        return dateSubmitted;
    }

    public String getAccessibility() {
        return accessibility;
    }

    public String getEuropdxAccessModality() {
        return europdxAccessModality;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getFormUrl() {
        return formUrl;
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public String getModelAvailability() {
        return modelAvailability;
    }

    public String getLicense() {
        return license;
    }

}
