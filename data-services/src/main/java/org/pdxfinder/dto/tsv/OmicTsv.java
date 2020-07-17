package org.pdxfinder.dto.tsv;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "datasource",
        "Model_ID",
        "Sample_ID",
        "sample_origin",
        "Passage",
        "host_strain_name",
        "hgnc_symbol",
        "coding_sequence_change",
        "amino_acid_change",
        "consequence",
        "functional_prediction",
        "read_depth",
        "Allele_frequency",
        "chromosome",
        "seq_start_position",
        "ref_allele",
        "alt_allele",
        "ucsc_gene_id",
        "ncbi_gene_id",
        "ensembl_gene_id",
        "ensembl_transcript_id",
        "variation_id",
        "rs_id_Variant",
        "genome_assembly",
        "Platform"
})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OmicTsv {

    @JsonProperty("datasource")
    private String dataSource;

    @JsonProperty("Model_ID")
    private String modelId;

    @JsonProperty("Sample_ID")
    private String sampleId;

    @JsonProperty("sample_origin")
    private String sampleOrigin;

    @JsonProperty("Passage")
    private String passage;

    @JsonProperty("host_strain_name")
    private String hostStrainName;

    @JsonProperty("hgnc_symbol")
    private String hgncSymbol;

    @JsonProperty("amino_acid_change")
    private String aminoAcidChange;

    @JsonProperty("functional_prediction")
    private String functionalPrediction;

    @JsonProperty("nucleotide_change")
    private String nucleotideChange;

    @JsonProperty("coding_sequence_change")
    private String codingSequenceChange;

    @JsonProperty("consequence")
    private String consequence;

    @JsonProperty("read_depth")
    private String readDepth;

    @JsonProperty("Allele_frequency")
    private String alleleFrequency;

    @JsonProperty("chromosome")
    private String chromosome;

    @JsonProperty("seq_start_position")
    private String seqStartPosition;

    @JsonProperty("ref_allele")
    private String refAllele;

    @JsonProperty("variation_id")
    private String variationId;

    @JsonProperty("alt_allele")
    private String altAllele;

    @JsonProperty("ucsc_gene_id")
    private String ucscGeneId;

    @JsonProperty("ncbi_gene_id")
    private String ncbiGeneId;

    @JsonProperty("ensembl_gene_id")
    private String ensemblGeneId;

    @JsonProperty("ensembl_transcript_id")
    private String ensemblTranscriptId;

    @JsonProperty("rs_id_Variant")
    private String rsIdVariant;

    @JsonProperty("genome_assembly")
    private String genomeAssembly;

    @JsonProperty("Platform")
    private String platform;

    public String getDataSource() {
        return dataSource;
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

    public String getHostStrainName() {
        return hostStrainName;
    }

    public String getHgncSymbol() {
        return hgncSymbol;
    }

    public String getAminoAcidChange() {
        return aminoAcidChange;
    }

    public String getFunctionalPrediction() {
        return functionalPrediction;
    }

    public String getNucleotideChange() {
        return nucleotideChange;
    }

    public String getCodingSequenceChange() {
        return codingSequenceChange;
    }

    public String getConsequence() {
        return consequence;
    }

    public String getReadDepth() {
        return readDepth;
    }

    public String getAlleleFrequency() {
        return alleleFrequency;
    }

    public String getChromosome() {
        return chromosome;
    }

    public String getSeqStartPosition() {
        return seqStartPosition;
    }

    public String getRefAllele() {
        return refAllele;
    }

    public String getVariationId() {
        return variationId;
    }

    public String getAltAllele() {
        return altAllele;
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

    public String getRsIdVariant() {
        return rsIdVariant;
    }

    public String getGenomeAssembly() {
        return genomeAssembly;
    }

    public String getPlatform() {
        return platform;
    }

    public OmicTsv setDataSource(String dataSource) {
        this.dataSource = dataSource;
        return this;
    }

    public OmicTsv setModelId(String modelId) {
        this.modelId = modelId;
        return this;
    }

    public OmicTsv setSampleId(String sampleId) {
        this.sampleId = sampleId;
        return this;
    }

    public OmicTsv setSampleOrigin(String sampleOrigin) {
        this.sampleOrigin = sampleOrigin;
        return this;
    }

    public OmicTsv setPassage(String passage) {
        this.passage = passage;
        return this;
    }

    public OmicTsv setHostStrainName(String hostStrainName) {
        this.hostStrainName = hostStrainName;
        return this;
    }

    public OmicTsv setHgncSymbol(String hgncSymbol) {
        this.hgncSymbol = hgncSymbol;
        return this;
    }

    public OmicTsv setAminoAcidChange(String aminoAcidChange) {
        this.aminoAcidChange = aminoAcidChange;
        return this;
    }

    public OmicTsv setFunctionalPrediction(String functionalPrediction) {
        this.functionalPrediction = functionalPrediction;
        return this;
    }

    public OmicTsv setNucleotideChange(String nucleotideChange) {
        this.nucleotideChange = nucleotideChange;
        return this;
    }

    public OmicTsv setCodingSequenceChange(String codingSequenceChange) {
        this.codingSequenceChange = codingSequenceChange;
        return this;
    }

    public OmicTsv setConsequence(String consequence) {
        this.consequence = consequence;
        return this;
    }

    public OmicTsv setReadDepth(String readDepth) {
        this.readDepth = readDepth;
        return this;
    }

    public OmicTsv setAlleleFrequency(String alleleFrequency) {
        this.alleleFrequency = alleleFrequency;
        return this;
    }

    public OmicTsv setChromosome(String chromosome) {
        this.chromosome = chromosome;
        return this;
    }

    public OmicTsv setSeqStartPosition(String seqStartPosition) {
        this.seqStartPosition = seqStartPosition;
        return this;
    }

    public OmicTsv setRefAllele(String refAllele) {
        this.refAllele = refAllele;
        return this;
    }

    public OmicTsv setVariationId(String variationId) {
        this.variationId = variationId;
        return this;
    }

    public OmicTsv setAltAllele(String altAllele) {
        this.altAllele = altAllele;
        return this;
    }

    public OmicTsv setUcscGeneId(String ucscGeneId) {
        this.ucscGeneId = ucscGeneId;
        return this;
    }

    public OmicTsv setNcbiGeneId(String ncbiGeneId) {
        this.ncbiGeneId = ncbiGeneId;
        return this;
    }

    public OmicTsv setEnsemblGeneId(String ensemblGeneId) {
        this.ensemblGeneId = ensemblGeneId;
        return this;
    }

    public OmicTsv setEnsemblTranscriptId(String ensemblTranscriptId) {
        this.ensemblTranscriptId = ensemblTranscriptId;
        return this;
    }

    public OmicTsv setRsIdVariant(String rsIdVariant) {
        this.rsIdVariant = rsIdVariant;
        return this;
    }

    public OmicTsv setGenomeAssembly(String genomeAssembly) {
        this.genomeAssembly = genomeAssembly;
        return this;
    }

    public OmicTsv setPlatform(String platform) {
        this.platform = platform;
        return this;
    }

    public OmicTsv createOmicTsv() {
        return this;
    }
}
