package org.pdxfinder.dto.template;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "Field",
        "model_id",
        "provider_type",
        "accessibility",
        "europdx_access_modality",
        "email",
        "name",
        "form_url",
        "database_url",
        "provider_name",
        "provider_abbreviation",
        "project"
})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MetadataSharingTsv {

    @JsonProperty("Field")
    private String field;

    @JsonProperty("model_id")
    private String modelId;

    @JsonProperty("provider_type")
    private String providerType;

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

    @JsonProperty("provider_name")
    private String providerName;

    @JsonProperty("provider_abbreviation")
    private String providerAbbreviation;

    @JsonProperty("project")
    private String project;

    public MetadataSharingTsv() {
        this.field = "";
        this.modelId = "";
        this.providerType = "";
        this.accessibility = "";
        this.europdxAccessModality = "";
        this.email = "";
        this.name = "";
        this.formUrl = "";
        this.databaseUrl = "";
        this.providerName = "";
        this.providerAbbreviation = "";
        this.project = "";
    }

    public MetadataSharingTsv setField(String field) {
        this.field = field;
        return this;
    }

    public MetadataSharingTsv setModelId(String modelId) {
        this.modelId = modelId;
        return this;
    }

    public MetadataSharingTsv setProviderType(String providerType) {
        this.providerType = providerType;
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

    public MetadataSharingTsv setProviderName(String providerName) {
        this.providerName = providerName;
        return this;
    }

    public MetadataSharingTsv setProviderAbbreviation(String providerAbbreviation) {
        this.providerAbbreviation = providerAbbreviation;
        return this;
    }

    public MetadataSharingTsv setProject(String project) {
        this.project = project;
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

    public String getProviderType() {
        return providerType;
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

    public String getProviderName() {
        return providerName;
    }

    public String getProviderAbbreviation() {
        return providerAbbreviation;
    }

    public String getProject() {
        return project;
    }
}
