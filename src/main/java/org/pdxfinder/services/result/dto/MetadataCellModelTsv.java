package org.pdxfinder.services.result.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({
        "Field",
        "model_id",
        "model_name",
        "growth_properties",
        "parent_id",
        "origin_patient_sample_id",
        "comments",
        "supplier",
        "external_ids",
        "publications"
})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MetadataCellModelTsv {

    @JsonProperty("Field")
    private String field;

    @JsonProperty("model_id")
    private String modelId;

    @JsonProperty("model_name")
    private String model_name;

    @JsonProperty("growth_properties")
    private String growth_properties;

    @JsonProperty("parent_id")
    private String parent_id;

    @JsonProperty("origin_patient_sample_id")
    private String origin_patient_sample_id;

    @JsonProperty("comments")
    private String comments;

    @JsonProperty("supplier")
    private String supplier;

    @JsonProperty("external_ids")
    private String external_ids;

    @JsonProperty("publications")
    private String publications;

    public MetadataCellModelTsv() {
        this.field = "";
        this.modelId = "";
        this.model_name = "";
        this.growth_properties = "";
        this.parent_id = "";
        this.origin_patient_sample_id = "";
        this.comments = "";
        this.supplier = "";
        this.external_ids = "";
        this.publications = "";
    }

    public MetadataCellModelTsv build() {
        return this;
    }

    public MetadataCellModelTsv setField(String field) {
        this.field = field;
        return this;
    }

    public String getField() {
        return field;
    }


    public MetadataCellModelTsv setModelId(String modelId) {
        this.modelId = modelId;
        return this;
    }

    public String getModelId() {
        return modelId;
    }


    public MetadataCellModelTsv setModelname(String model_name) {
        this.model_name = model_name;
        return this;
    }

    public String getModel_name() {
        return model_name;
    }

    public MetadataCellModelTsv setModel_name(String model_name) {
        this.model_name = model_name;
        return this;
    }

    public String getGrowth_properties() {
        return growth_properties;
    }

    public MetadataCellModelTsv setGrowth_properties(String growth_properties) {
        this.growth_properties = growth_properties;
        return this;
    }

    public String getParent_id() {
        return parent_id;
    }

    public MetadataCellModelTsv setParent_id(String parent_id) {
        this.parent_id = parent_id;
        return this;
    }

    public String getOrigin_patient_sample_id() {
        return origin_patient_sample_id;
    }

    public MetadataCellModelTsv setOrigin_patient_sample_id(String origin_patient_sample_id) {
        this.origin_patient_sample_id = origin_patient_sample_id;
        return this;
    }

    public String getComments() {
        return comments;
    }

    public MetadataCellModelTsv setComments(String comments) {
        this.comments = comments;
        return this;
    }

    public String getSupplier() {
        return supplier;
    }

    public MetadataCellModelTsv setSupplier(String supplier) {
        this.supplier = supplier;
        return this;
    }

    public String getExternal_ids() {
        return external_ids;
    }

    public MetadataCellModelTsv setExternal_ids(String external_ids) {
        this.external_ids = external_ids;
        return this;
    }

    public String getPublications() {
        return publications;
    }

    public MetadataCellModelTsv setPublications(String publications) {
        this.publications = publications;
        return this;
    }



}
