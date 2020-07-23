package org.pdxfinder.dto.template;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "Field",
        "sample_id",
        "sample_origin",
        "passage",
        "engrafted_tumor_collection_site",
        "model_id",
        "host_strain_name",
        "host_strain_nomenclature",
        "molecular_characterisation_type",
        "platform",
        "platform_type",
        "platform_notes",
        "analysis_protocol",
        "processed_data_file",
        "raw_data_sharable",
        "raw_data_file",
        "internal_protocol_url"
})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SamplePlatformTsv {

    @JsonProperty("Field")
    private String field;

    @JsonProperty("sample_id")
    private String sampleId;

    @JsonProperty("sample_origin")
    private String sampleOrigin;

    @JsonProperty("passage")
    private String passage;

    @JsonProperty("engrafted_tumor_collection_site")
    private String engraftedTumorCollectionSite;

    @JsonProperty("model_id")
    private String modelId;

    @JsonProperty("host_strain_name")
    private String hostStrainName;

    @JsonProperty("host_strain_nomenclature")
    private String hostStrainNomenclature;

    @JsonProperty("molecular_characterisation_type")
    private String molecularCharacterisationType;

    @JsonProperty("platform")
    private String platform;

    @JsonProperty("platform_type")
    private String platformType;

    @JsonProperty("platform_notes")
    private String platformNotes;

    @JsonProperty("analysis_protocol")
    private String analysisProtocol;

    @JsonProperty("processed_data_file")
    private String processedDataFile;

    @JsonProperty("raw_data_sharable")
    private String rawDataSharable;

    @JsonProperty("raw_data_file")
    private String rawDataFile;

    @JsonProperty("internal_protocol_url")
    private String internalProtocolUrl;

    public SamplePlatformTsv() {
        this.field = "";
        this.sampleId = "";
        this.sampleOrigin = "";
        this.passage = "";
        this.engraftedTumorCollectionSite = "";
        this.modelId = "";
        this.hostStrainName = "";
        this.hostStrainNomenclature = "";
        this.molecularCharacterisationType = "";
        this.platform = "";
        this.platformType = "";
        this.platformNotes = "";
        this.analysisProtocol = "";
        this.processedDataFile = "";
        this.rawDataSharable = "";
        this.rawDataFile = "";
        this.internalProtocolUrl = "";
    }

    public SamplePlatformTsv setField(String field) {
        this.field = field;
        return this;
    }

    public SamplePlatformTsv setSampleId(String sampleId) {
        this.sampleId = sampleId;
        return this;
    }

    public SamplePlatformTsv setSampleOrigin(String sampleOrigin) {
        this.sampleOrigin = sampleOrigin;
        return this;
    }

    public SamplePlatformTsv setPassage(String passage) {
        this.passage = passage;
        return this;
    }

    public SamplePlatformTsv setEngraftedTumorCollectionSite(String engraftedTumorCollectionSite) {
        this.engraftedTumorCollectionSite = engraftedTumorCollectionSite;
        return this;
    }

    public SamplePlatformTsv setModelId(String modelId) {
        this.modelId = modelId;
        return this;
    }

    public SamplePlatformTsv setHostStrainName(String hostStrainName) {
        this.hostStrainName = hostStrainName;
        return this;
    }

    public SamplePlatformTsv setHostStrainNomenclature(String hostStrainNomenclature) {
        this.hostStrainNomenclature = hostStrainNomenclature;
        return this;
    }

    public SamplePlatformTsv setMolecularCharacterisationType(String molecularCharacterisationType) {
        this.molecularCharacterisationType = molecularCharacterisationType;
        return this;
    }

    public SamplePlatformTsv setPlatform(String platform) {
        this.platform = platform;
        return this;
    }

    public SamplePlatformTsv setPlatformType(String platformType) {
        this.platformType = platformType;
        return this;
    }

    public SamplePlatformTsv setPlatformNotes(String platformNotes) {
        this.platformNotes = platformNotes;
        return this;
    }

    public SamplePlatformTsv setAnalysisProtocol(String analysisProtocol) {
        this.analysisProtocol = analysisProtocol;
        return this;
    }

    public SamplePlatformTsv setProcessedDataFile(String processedDataFile) {
        this.processedDataFile = processedDataFile;
        return this;
    }

    public SamplePlatformTsv setRawDataSharable(String rawDataSharable) {
        this.rawDataSharable = rawDataSharable;
        return this;
    }

    public SamplePlatformTsv setRawDataFile(String rawDataFile) {
        this.rawDataFile = rawDataFile;
        return this;
    }

    public SamplePlatformTsv setInternalProtocolUrl(String internalProtocolUrl) {
        this.internalProtocolUrl = internalProtocolUrl;
        return this;
    }

    public SamplePlatformTsv build() {
        return this;
    }

    public String getField() {
        return field;
    }

    public String getSampleId() {
        return sampleId;
    }

    public String getSampleOrigin() {
        return sampleOrigin;
    }

    public String getPassage() {
        return passage;
    }

    public String getEngraftedTumorCollectionSite() {
        return engraftedTumorCollectionSite;
    }

    public String getModelId() {
        return modelId;
    }

    public String getHostStrainName() {
        return hostStrainName;
    }

    public String getHostStrainNomenclature() {
        return hostStrainNomenclature;
    }

    public String getMolecularCharacterisationType() {
        return molecularCharacterisationType;
    }

    public String getPlatform() {
        return platform;
    }

    public String getPlatformType() {
        return platformType;
    }

    public String getPlatformNotes() {
        return platformNotes;
    }

    public String getAnalysisProtocol() {
        return analysisProtocol;
    }

    public String getProcessedDataFile() {
        return processedDataFile;
    }

    public String getRawDataSharable() {
        return rawDataSharable;
    }

    public String getRawDataFile() {
        return rawDataFile;
    }

    public String getInternalProtocolUrl() {
        return internalProtocolUrl;
    }
}
