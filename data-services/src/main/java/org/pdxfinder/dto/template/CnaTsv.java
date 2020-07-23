package org.pdxfinder.dto.template;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "model_id",
        "sample_id",
        "sample_origin",
        "passage",
        "host_strain_nomenclature",
        "chromosome",
        "seq_start_position",
        "seq_end_position",
        "symbol",
        "ucsc_gene_id",
        "ncbi_gene_id",
        "ensembl_gene_id",
        "log10r_cna",
        "log2r_cna",
        "copy_number_status",
        "gistic_value",
        "picnic_value",
        "genome_assembly",
        "platform"
})
public class CnaTsv {

    @JsonProperty("model_id")
    @JsonAlias("model")
    private String modelId;

    @JsonProperty("sample_id")
    @JsonAlias("sample")
    private String sampleId;

    @JsonProperty("sample_origin")
    private String sampleOrigin;

    @JsonProperty("passage")
    private String passage;

    @JsonProperty("host_strain_nomenclature")
    private String hostStrainNomenclature;

    @JsonProperty("chromosome")
    private String chromosome;

    @JsonProperty("seq_start_position")
    private String seqStartPosition;

    @JsonProperty("seq_end_position")
    private String seqEndPosition;

    @JsonProperty("symbol")
    @JsonAlias("gene")
    private String symbol;

    @JsonProperty("ucsc_gene_id")
    private String ucscGeneId;

    @JsonProperty("ncbi_gene_id")
    private String ncbiGeneId;

    @JsonProperty("ensembl_gene_id")
    private String ensemblGeneId;

    @JsonProperty("log10r_cna")
    private String log10rCna;

    @JsonProperty("log2r_cna")
    @JsonAlias("logratio_ploidy")
    private String log2rCna;

    @JsonProperty("copy_number_status")
    private String copyNumberStatus;

    @JsonProperty("gistic_value")
    private String gisticValue;

    @JsonProperty("picnic_value")
    private String picnicValue;

    @JsonProperty("genome_assembly")
    private String genomeAssembly;

    @JsonProperty("platform")
    private String platform;

    public CnaTsv() {
        this.modelId = "";
        this.sampleId =  "";
        this.sampleOrigin = "";
        this.passage = "";
        this.hostStrainNomenclature = "";
        this.chromosome = "";
        this.seqStartPosition = "";
        this.seqEndPosition = "";
        this.symbol = "";
        this.ucscGeneId = "";
        this.ncbiGeneId = "";
        this.ensemblGeneId = "";
        this.log10rCna = "";
        this.log2rCna = "";
        this.copyNumberStatus = "";
        this.gisticValue = "";
        this.picnicValue = "";
        this.genomeAssembly = "";
        this.platform = "";
    }

    public String getModelId() {
        return modelId;
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

    public String getHostStrainNomenclature() {
        return hostStrainNomenclature;
    }

    public String getChromosome() {
        return chromosome;
    }

    public String getSeqStartPosition() {
        return seqStartPosition;
    }

    public String getSeqEndPosition() {
        return seqEndPosition;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getUcscGeneId() {
        return ucscGeneId;
    }

    public String getNcbiGeneId() {
        return ncbiGeneId;
    }

    public String getEnsemblGeneId() {
        return ensemblGeneId;
    }

    public String getLog10rCna() {
        return log10rCna;
    }

    public String getLog2rCna() {
        return log2rCna;
    }

    public String getCopyNumberStatus() {
        return copyNumberStatus;
    }

    public String getGisticValue() {
        return gisticValue;
    }

    public String getPicnicValue() {
        return picnicValue;
    }

    public String getGenomeAssembly() {
        return genomeAssembly;
    }

    public String getPlatform() {
        return platform;
    }

    public CnaTsv setPassage(String passage) {
        this.passage = passage;
        return this;
    }

    public CnaTsv setSampleOrigin(String sampleOrigin) {
        this.sampleOrigin = sampleOrigin;
        return this;
    }

    public CnaTsv setHostStrainNomenclature(String hostStrainNomenclature) {
        this.hostStrainNomenclature = hostStrainNomenclature;
        return this;
    }

    public CnaTsv build(){
        return this;
    }
}
