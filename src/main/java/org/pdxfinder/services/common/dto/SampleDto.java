package org.pdxfinder.services.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Sample ID",
        "Tumor Type",
        "Passage",
        "Platform",
        "WES-VCF-File",
        "WES-Fasta-File",
        "NCI-Gene-Panel",
        "RNASeq-Fasta-File",
        "RNASeq-RSEM-File"
})
public class SampleDto {

    private Integer id;

    @JsonProperty("Sample ID")
    private String sampleID;

    @JsonProperty("Tumor Type")
    private String tumorType;

    @JsonProperty("Passage")
    private String passage;

    @JsonProperty("Platform")
    private String platform;

    @JsonProperty("Platform URL")
    private String platformUrl;

    @JsonProperty("WES-VCF-File")
    private String wESVCFFile;

    @JsonProperty("WES-Fastq-File")
    private String wESFastaFile;

    @JsonProperty("NCI-Gene-Panel")
    private String nCIGenePanel;

    @JsonProperty("RNASeq-Fastq-File")
    private String rNASeqFastaFile;

    @JsonProperty("RNASeq-RSEM-File")
    private String rNASeqRSEMFile;

    public Integer getId() {
        return id;
    }

    public String getSampleID() {
        return sampleID;
    }

    public String getTumorType() {
        return tumorType;
    }

    public String getPassage() {
        return passage;
    }

    public String getPlatform() {
        return platform;
    }

    public String getwESVCFFile() {
        return wESVCFFile;
    }

    public String getwESFastaFile() {
        return wESFastaFile;
    }

    public String getnCIGenePanel() {
        return nCIGenePanel;
    }

    public String getrNASeqFastaFile() {
        return rNASeqFastaFile;
    }

    public String getrNASeqRSEMFile() {
        return rNASeqRSEMFile;
    }

    public String getPlatformUrl() {
        return platformUrl;
    }

    public SampleDto setSampleID(String sampleID) {
        this.sampleID = sampleID;
        return this;
    }

    public SampleDto setTumorType(String tumorType) {
        this.tumorType = tumorType;
        return this;
    }

    public SampleDto setPassage(String passage) {
        this.passage = passage;
        return this;
    }

    public SampleDto setPlatform(String platform) {
        this.platform = platform;
        return this;
    }

    public SampleDto setwESVCFFile(String wESVCFFile) {
        this.wESVCFFile = wESVCFFile;
        return this;
    }

    public SampleDto setwESFastaFile(String wESFastaFile) {
        this.wESFastaFile = wESFastaFile;
        return this;
    }

    public SampleDto setnCIGenePanel(String nCIGenePanel) {
        this.nCIGenePanel = nCIGenePanel;
        return this;
    }

    public SampleDto setrNASeqFastaFile(String rNASeqFastaFile) {
        this.rNASeqFastaFile = rNASeqFastaFile;
        return this;
    }

    public SampleDto setrNASeqRSEMFile(String rNASeqRSEMFile) {
        this.rNASeqRSEMFile = rNASeqRSEMFile;
        return this;
    }

    public SampleDto setPlatformUrl(String platformUrl) {
        this.platformUrl = platformUrl;
        return this;
    }

    public SampleDto build() {
        return this;
    }
}
