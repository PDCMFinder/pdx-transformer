package org.pdxfinder.services.result.dto;

import com.fasterxml.jackson.annotation.*;

@JsonPropertyOrder({
        "Field",
        "model_id",
        "model_name",
        "model_name_aliases",
        "type",
        "parent_id",
        "origin_patient_sample_id",
        "growth_properties",
        "media_id",
        "growth_media",
        "plate_coating",
        "other_plate_coating",
        "passage_number",
        "contaminated",
        "contamination_details",
        "supplements",
        "drug",
        "drug_concentration",
        "publications",
        "supplier",
        "supplier_type",
        "catalog_number",
        "vendor_link",
        "rrid",
        "external_ids",
        "comments"
})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MetadataCellModelTsv {

    @JsonProperty("Field")
    private String field;

    @JsonProperty("model_id")
    private String modelId;

    @JsonProperty("model_name")
    private String model_name;

    @JsonProperty("model_name_aliases")
    private String model_name_aliases;

    @JsonProperty("type")
    private String type;

    @JsonProperty("parent_id")
    private String parent_id;

    @JsonProperty("origin_patient_sample_id")
    private String origin_patient_sample_id;

    @JsonProperty("growth_properties")
    private String growth_properties;

    @JsonProperty("media_id")
    private String media_id;

    @JsonProperty("growth_media")
    private String growth_media;

    @JsonProperty("plate_coating")
    private String plate_coating;

    @JsonProperty("other_plate_coating")
    private String other_plate_coating;

    @JsonProperty("passage_number")
    private String passage_number;

    @JsonProperty("contaminated")
    private String contaminated;

    @JsonProperty("contamination_details")
    private String contamination_details;

    @JsonProperty("supplements")
    private String supplements;

    @JsonProperty("drug")
    private String drug;

    @JsonProperty("drug_concentration")
    private String drug_concentration;


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

    @JsonProperty("rrid")
    private String rrid;

    @JsonProperty("external_ids")
    private String external_ids;

    @JsonProperty("comments")
    private String comments;



    public MetadataCellModelTsv() {
        this.field = "";
        this.modelId = "";
        this.model_name = "";
        this.model_name_aliases = "";
        this.type = "";
        this.parent_id = "";
        this.origin_patient_sample_id = "";
        this.growth_properties = "";
        this.media_id = "";
        this.growth_media = "";
        this.plate_coating = "";
        this.other_plate_coating = "";
        this.passage_number = "";
        this.contaminated = "";
        this.contamination_details = "";
        this.supplements = "";
        this.drug = "";
        this.drug_concentration = "";
        this.publications = "";
        this.supplier = "";
        this.supplier_type = "";
        this.catalog_number = "";
        this.vendor_link = "";
        this.rrid = "";
        this.external_ids = "";
        this.comments = "";

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


    public MetadataCellModelTsv setType(String model_type) {
        this.type = model_type;
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

    public String getType() {
        return type;
    }

    public String getModel_name_aliases() {
        return model_name_aliases;
    }

    public MetadataCellModelTsv setModel_name_aliases(String model_name_aliases) {
        this.model_name_aliases = model_name_aliases;
        return this;
    }

    public String getMedia_id() {
        return media_id;
    }

    public MetadataCellModelTsv setMedia_id(String media_id) {
        this.media_id = media_id;
        return this;
    }

    public String getGrowth_media() {
        return growth_media;
    }

    public MetadataCellModelTsv setGrowth_media(String growth_media) {
        this.growth_media = growth_media;
        return this;
    }

    public String getPlate_coating() {
        return plate_coating;
    }

    public MetadataCellModelTsv setPlate_coating(String plate_coating) {
        this.plate_coating = plate_coating;
        return this;
    }

    public String getOther_plate_coating() {
        return other_plate_coating;
    }

    public MetadataCellModelTsv setOther_plate_coating(String other_plate_coating) {
        this.other_plate_coating = other_plate_coating;
        return this;
    }

    public String getPassage_number() {
        return passage_number;
    }

    public MetadataCellModelTsv setPassage_number(String passage_number) {
        this.passage_number = passage_number;
        return this;
    }

    public String getContaminated() {
        return contaminated;
    }

    public MetadataCellModelTsv setContaminated(String contaminated) {
        this.contaminated = contaminated;
        return this;
    }

    public String getContamination_details() {
        return contamination_details;
    }

    public MetadataCellModelTsv setContamination_details(String contamination_details) {
        this.contamination_details = contamination_details;
        return this;
    }

    public String getSupplements() {
        return supplements;
    }

    public MetadataCellModelTsv setSupplements(String supplements) {
        this.supplements = supplements;
        return this;
    }

    public String getDrug() {
        return drug;
    }

    public MetadataCellModelTsv setDrug(String drug) {
        this.drug = drug;
        return this;
    }

    public String getDrug_concentration() {
        return drug_concentration;
    }

    public MetadataCellModelTsv setDrug_concentration(String drug_concentration) {
        this.drug_concentration = drug_concentration;
        return this;
    }

    public String getSupplier_type() {
        return supplier_type;
    }

    public MetadataCellModelTsv setSupplier_type(String supplier_type) {
        this.supplier_type = supplier_type;
        return this;
    }

    public String getCatalog_number() {
        return catalog_number;
    }

    public MetadataCellModelTsv setCatalog_number(String catalog_number) {
        this.catalog_number = catalog_number;
        return this;
    }

    public String getVendor_link() {
        return vendor_link;
    }

    public MetadataCellModelTsv setVendor_link(String vendor_link) {
        this.vendor_link = vendor_link;
        return this;
    }

    public String getRrid() {
        return rrid;
    }

    public MetadataCellModelTsv setRrid(String rrid) {
        this.rrid = rrid;
        return this;
    }

}
