package org.pdxfinder.dto.tsv;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "Field",
        "model_id",
        "validation_technique",
        "description",
        "passages_tested",
        "validation_host_strain_full"
})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MetadataModelValidationTsv {

    @JsonProperty("Field")
    private String field;

    @JsonProperty("model_id")
    private String modelId;

    @JsonProperty("validation_technique")
    private String validationTechnique;

    @JsonProperty("description")
    private String description;

    @JsonProperty("passages_tested")
    private String passagesTested;

    @JsonProperty("validation_host_strain_full")
    private String validationHostStrainFull;

    public MetadataModelValidationTsv setField(String field) {
        this.field = field;
        return this;
    }

    public MetadataModelValidationTsv setModelId(String modelId) {
        this.modelId = modelId;
        return this;
    }

    public MetadataModelValidationTsv setValidationTechnique(String validationTechnique) {
        this.validationTechnique = validationTechnique;
        return this;
    }

    public MetadataModelValidationTsv setDescription(String description) {
        this.description = description;
        return this;
    }

    public MetadataModelValidationTsv setPassagesTested(String passagesTested) {
        this.passagesTested = passagesTested;
        return this;
    }

    public MetadataModelValidationTsv setValidationHostStrainFull(String validationHostStrainFull) {
        this.validationHostStrainFull = validationHostStrainFull;
        return this;
    }

    public MetadataModelValidationTsv createMetadataModelValidationTsv() {
        return this;
    }

    public String getField() {
        return field;
    }

    public String getModelId() {
        return modelId;
    }

    public String getValidationTechnique() {
        return validationTechnique;
    }

    public String getDescription() {
        return description;
    }

    public String getPassagesTested() {
        return passagesTested;
    }

    public String getValidationHostStrainFull() {
        return validationHostStrainFull;
    }
}
