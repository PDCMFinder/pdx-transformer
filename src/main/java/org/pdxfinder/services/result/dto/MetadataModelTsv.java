package org.pdxfinder.services.result.dto;

import com.fasterxml.jackson.annotation.*;
import org.pdxfinder.constant.DataConstants;

import java.util.Objects;

@JsonPropertyOrder({
        "Field",
        "model_id",
        "host_strain_name",
        "host_strain_nomenclature",
        "engraftment_site",
        "engraftment_type",
        "sample_type",
        "sample_state",
        "passage_number",
        "parent_id",
        "origin_patient_sample_id",
        "publications",
        "supplier",
        "supplier_type",
        "catalog_number",
        "vendor_link",
        "external_ids",
})
public class MetadataModelTsv {

    @JsonProperty("Field")
    private String field;

    @JsonProperty("model_id")
    private String modelId;

    @JsonProperty("host_strain_name")
    private String hostStrain;

    @JsonProperty("host_strain_nomenclature")
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

    @JsonProperty("parent_id")
    private String parent_id;

    @JsonProperty("origin_patient_sample_id")
    private String origin_patient_sample_id;

    @JsonProperty("publications")
    private String publications;

    @JsonProperty("supplier")
    private String supplier;

    @JsonProperty("supplier_type")
    private String supplier_type;

    @JsonProperty("catalog_number")
    private String catalog_number;

    @JsonProperty("vendor_link")
    private String vendor_link;

    @JsonProperty("external_ids")
    private String external_ids;


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
        this.parent_id = "";
        this.origin_patient_sample_id = "";
        this.publications = "";
        this.supplier = "";
        this.supplier_type = "";
        this.catalog_number = "";
        this.vendor_link = "";
        this.external_ids = "";

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

    public MetadataModelTsv setParent_id(String parent_id) {
        this.parent_id = parent_id;
        return this;
    }

    public MetadataModelTsv setOrigin_patient_sample_id(String origin_patient_sample_id) {
        this.origin_patient_sample_id = origin_patient_sample_id;
        return this;
    }

    public MetadataModelTsv setSupplier(String supplier) {
        this.supplier = supplier;
        return this;
    }

    public MetadataModelTsv setSupplier_type(String supplier_type) {
        this.supplier_type = supplier_type;
        return this;
    }

    public MetadataModelTsv setCatalog_number(String catalog_number) {
        this.catalog_number = catalog_number;
        return this;
    }

    public MetadataModelTsv setVendor_link(String vendor_link) {
        this.vendor_link = vendor_link;
        return this;
    }

    public MetadataModelTsv setExternal_ids(String external_ids) {
        this.external_ids = external_ids;
        return this;
    }

}
