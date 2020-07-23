package org.pdxfinder.dto.template;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "model_id",
        "sample_id",
        "sample_origin",
        "host_strain_nomenclature",
        "passage",
        "chromosome",
        "strand",
        "seq_start_position",
        "seq_end_position",
        "symbol",
        "ucsc_gene_id",
        "ncbi_gene_id",
        "ensembl_gene_id",
        "ensembl_transcript_id",
        "rnaseq_coverage",
        "rnaseq_fpkm",
        "rnaseq_tpm",
        "rnaseq_count",
        "affy_hgea_probe_id",
        "affy_hgea_expression_value",
        "illumina_hgea_probe_id",
        "illumina_hgea_expression_value",
        "z_score",
        "genome_assembly",
        "platform"
})
public class ExpressionTsv {

    @JsonProperty("model_id")
    @JsonAlias("model")
    private String modelId;

    @JsonProperty("sample_id")
    @JsonAlias("sample")
    private String sampleId;

    @JsonProperty("sample_origin")
    private String sampleOrigin;

    @JsonProperty("host_strain_nomenclature")
    private String hostStrainNomenclature;

    @JsonProperty("passage")
    private String passage;

    @JsonProperty("chromosome")
    private String chromosome;

    @JsonProperty("strand")
    private String strand;

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

    @JsonProperty("ensembl_transcript_id")
    private String ensemblTranscriptId;

    @JsonProperty("rnaseq_coverage")
    private String rnaseqCoverage;

    @JsonProperty("rnaseq_fpkm")
    private String rnaseqFpkm;

    @JsonProperty("rnaseq_tpm")
    @JsonAlias("TPM")
    private String rnaseqTpm;

    @JsonProperty("rnaseq_count")
    private String rnaseqCount;

    @JsonProperty("affy_hgea_probe_id")
    private String affyHgeaProbId;

    @JsonProperty("affy_hgea_expression_value")
    private String affyHgeaExpressionValue;

    @JsonProperty("illumina_hgea_probe_id")
    private String illuminaHgeaProbeId;

    @JsonProperty("illumina_hgea_expression_value")
    private String illuminaHgeaExpressionValue;

    @JsonProperty("z_score")
    @JsonAlias("z_score_percentile_rank")
    private String zScore;

    @JsonProperty("genome_assembly")
    private String genomeAssembly;

    @JsonProperty("platform")
    private String platform;

    public ExpressionTsv() {
        this.modelId = "";
        this.sampleId = "";
        this.sampleOrigin = "";
        this.hostStrainNomenclature = "";
        this.passage = "";
        this.chromosome = "";
        this.strand = "";
        this.seqStartPosition = "";
        this.seqEndPosition = "";
        this.symbol = "";
        this.ucscGeneId = "";
        this.ncbiGeneId = "";
        this.ensemblGeneId = "";
        this.ensemblTranscriptId = "";
        this.rnaseqCoverage = "";
        this.rnaseqFpkm = "";
        this.rnaseqTpm = "";
        this.rnaseqCount = "";
        this.affyHgeaProbId = "";
        this.affyHgeaExpressionValue = "";
        this.illuminaHgeaProbeId = "";
        this.illuminaHgeaExpressionValue = "";
        this.zScore = "";
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

    public String getHostStrainNomenclature() {
        return hostStrainNomenclature;
    }

    public String getPassage() {
        return passage;
    }

    public String getChromosome() {
        return chromosome;
    }

    public String getStrand() {
        return strand;
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

    public String getEnsemblTranscriptId() {
        return ensemblTranscriptId;
    }

    public String getRnaseqCoverage() {
        return rnaseqCoverage;
    }

    public String getRnaseqFpkm() {
        return rnaseqFpkm;
    }

    public String getRnaseqTpm() {
        return rnaseqTpm;
    }

    public String getRnaseqCount() {
        return rnaseqCount;
    }

    public String getAffyHgeaProbId() {
        return affyHgeaProbId;
    }

    public String getAffyHgeaExpressionValue() {
        return affyHgeaExpressionValue;
    }

    public String getIlluminaHgeaProbeId() {
        return illuminaHgeaProbeId;
    }

    public String getIlluminaHgeaExpressionValue() {
        return illuminaHgeaExpressionValue;
    }

    public String getzScore() {
        return zScore;
    }

    public String getGenomeAssembly() {
        return genomeAssembly;
    }

    public String getPlatform() {
        return platform;
    }


    public ExpressionTsv setPassage(String passage) {
        this.passage = passage;
        return this;
    }

    public ExpressionTsv setSampleOrigin(String sampleOrigin) {
        this.sampleOrigin = sampleOrigin;
        return this;
    }

    public ExpressionTsv setHostStrainNomenclature(String hostStrainNomenclature) {
        this.hostStrainNomenclature = hostStrainNomenclature;
        return this;
    }

    public ExpressionTsv build(){
        return this;
    }
}
