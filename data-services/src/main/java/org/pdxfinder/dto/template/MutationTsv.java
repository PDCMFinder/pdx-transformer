package org.pdxfinder.dto.template;

import com.fasterxml.jackson.annotation.*;

@JsonPropertyOrder({
        "model_id",
        "sample_id",
        "sample_origin",
        "host_strain_nomenclature",
        "passage",
        "symbol",
        "biotype",
        "coding_sequence_change",
        "variant_class",
        "codon_change",
        "amino_acid_change",
        "consequence",
        "functional_prediction",
        "read_depth",
        "allele_frequency",
        "chromosome",
        "seq_start_position",
        "ref_allele",
        "alt_allele",
        "ucsc_gene_id",
        "ncbi_gene_id",
        "ncbi_transcript_id",
        "ensembl_gene_id",
        "ensembl_transcript_id",
        "variation_id",
        "genome_assembly",
        "platform"
})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MutationTsv {

    @JsonProperty("model_id")
    @JsonAlias("model id")
    private String modelId;

    @JsonProperty("sample_id")
    @JsonAlias("sample")
    private String sampleId;

    @JsonProperty("sample_origin")
    private String sampleOrigin;

    @JsonProperty("host_strain_nomenclature")
    private String hostStrainName;

    @JsonProperty("passage")
    @JsonAlias("passage num")
    private String passage;

    @JsonProperty("symbol")
    @JsonAlias("gene symbol")
    private String hgncSymbol;

    @JsonProperty("biotype")
    private String bioType;

    @JsonProperty("coding_sequence_change")
    private String codingSequenceChange;

    @JsonProperty("variant_class")
    private String variantClass;

    @JsonProperty("codon_change")
    private String codonChange;

    @JsonProperty("amino_acid_change")
    @JsonAlias("amino acid change")
    private String aminoAcidChange;

    @JsonProperty("consequence")
    private String consequence;

    @JsonProperty("functional_prediction")
    private String functionalPrediction;

    @JsonProperty("read_depth")
    @JsonAlias("read depth")
    private String readDepth;

    @JsonProperty("allele_frequency")
    @JsonAlias("allele frequency")
    private String alleleFrequency;

    @JsonProperty("chromosome")
    private String chromosome;

    @JsonProperty("seq_start_position")
    @JsonAlias("seq position")
    private String seqStartPosition;

    @JsonProperty("ref_allele")
    @JsonAlias("ref allele")
    private String refAllele;

    @JsonProperty("alt_allele")
    @JsonAlias("alt allele")
    private String altAllele;

    @JsonProperty("ucsc_gene_id")
    @JsonAlias("gene id")
    private String ucscGeneId;

    @JsonProperty("ncbi_gene_id")
    private String ncbiGeneId;

    @JsonProperty("ncbi_transcript_id")
    private String ncbiTranscriptId;

    @JsonProperty("ensembl_gene_id")
    private String ensemblGeneId;

    @JsonProperty("ensembl_transcript_id")
    private String ensemblTranscriptId;

    @JsonProperty("variation_id")
    @JsonAlias("rs variants")
    private String variationId;

    @JsonProperty("genome_assembly")
    @JsonAlias("genome assembly")
    private String genomeAssembly;

    @JsonProperty("platform")
    private String platform;

    @JsonProperty("datasource")
    private String dataSource;

    public MutationTsv() {
        this.modelId = "";
        this.sampleId = "";
        this.sampleOrigin = "";
        this.passage = "";
        this.hostStrainName = "";
        this.hgncSymbol = "";
        this.bioType = "";
        this.aminoAcidChange = "";
        this.functionalPrediction = "";
        this.codingSequenceChange = "";
        this.consequence = "";
        this.readDepth = "";
        this.alleleFrequency = "";
        this.chromosome = "";
        this.seqStartPosition = "";
        this.refAllele = "";
        this.variationId = "";
        this.altAllele = "";
        this.ucscGeneId = "";
        this.ncbiGeneId = "";
        this.ncbiTranscriptId = "";
        this.ensemblGeneId = "";
        this.ensemblTranscriptId = "";
        this.variantClass = "";
        this.codonChange = "";
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

    public String getHostStrainName() {
        return hostStrainName;
    }

    public String getHgncSymbol() {
        return hgncSymbol;
    }

    public String getBioType() {
        return bioType;
    }

    public String getAminoAcidChange() {
        return aminoAcidChange;
    }

    public String getFunctionalPrediction() {
        return functionalPrediction;
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

    public String getNcbiTranscriptId() {
        return ncbiTranscriptId;
    }

    public String getEnsemblGeneId() {
        return ensemblGeneId;
    }

    public String getEnsemblTranscriptId() {
        return ensemblTranscriptId;
    }

    public String getVariantClass() {
        return variantClass;
    }

    public String getCodonChange() {
        return codonChange;
    }

    public String getGenomeAssembly() {
        return genomeAssembly;
    }

    public String getPlatform() {
        return platform;
    }

    public MutationTsv setDataSource(String dataSource) {
        this.dataSource = dataSource;
        return this;
    }

    public MutationTsv setModelId(String modelId) {
        this.modelId = modelId;
        return this;
    }

    public MutationTsv setSampleId(String sampleId) {
        this.sampleId = sampleId;
        return this;
    }

    public MutationTsv setSampleOrigin(String sampleOrigin) {
        this.sampleOrigin = sampleOrigin;
        return this;
    }

    public MutationTsv setPassage(String passage) {
        this.passage = passage;
        return this;
    }

    public MutationTsv setHostStrainName(String hostStrainName) {
        this.hostStrainName = hostStrainName;
        return this;
    }

    public MutationTsv setHgncSymbol(String hgncSymbol) {
        this.hgncSymbol = hgncSymbol;
        return this;
    }

    public MutationTsv setBioType(String bioType) {
        this.bioType = bioType;
        return this;
    }

    public MutationTsv setAminoAcidChange(String aminoAcidChange) {
        this.aminoAcidChange = aminoAcidChange;
        return this;
    }

    public MutationTsv setFunctionalPrediction(String functionalPrediction) {
        this.functionalPrediction = functionalPrediction;
        return this;
    }

    public MutationTsv setCodingSequenceChange(String codingSequenceChange) {
        this.codingSequenceChange = codingSequenceChange;
        return this;
    }

    public MutationTsv setConsequence(String consequence) {
        this.consequence = consequence;
        return this;
    }

    public MutationTsv setReadDepth(String readDepth) {
        this.readDepth = readDepth;
        return this;
    }

    public MutationTsv setAlleleFrequency(String alleleFrequency) {
        this.alleleFrequency = alleleFrequency;
        return this;
    }

    public MutationTsv setChromosome(String chromosome) {
        this.chromosome = chromosome;
        return this;
    }

    public MutationTsv setSeqStartPosition(String seqStartPosition) {
        this.seqStartPosition = seqStartPosition;
        return this;
    }

    public MutationTsv setRefAllele(String refAllele) {
        this.refAllele = refAllele;
        return this;
    }

    public MutationTsv setVariationId(String variationId) {
        this.variationId = variationId;
        return this;
    }

    public MutationTsv setAltAllele(String altAllele) {
        this.altAllele = altAllele;
        return this;
    }

    public MutationTsv setUcscGeneId(String ucscGeneId) {
        this.ucscGeneId = ucscGeneId;
        return this;
    }

    public MutationTsv setNcbiGeneId(String ncbiGeneId) {
        this.ncbiGeneId = ncbiGeneId;
        return this;
    }

    public MutationTsv setNcbiTranscriptId(String ncbiTranscriptId) {
        this.ncbiTranscriptId = ncbiTranscriptId;
        return this;
    }

    public MutationTsv setEnsemblGeneId(String ensemblGeneId) {
        this.ensemblGeneId = ensemblGeneId;
        return this;
    }

    public MutationTsv setEnsemblTranscriptId(String ensemblTranscriptId) {
        this.ensemblTranscriptId = ensemblTranscriptId;
        return this;
    }

    public MutationTsv setVariantClass(String variantClass) {
        this.variantClass = variantClass;
        return this;
    }

    public MutationTsv setCodonChange(String codonChange) {
        this.codonChange = codonChange;
        return this;
    }

    public MutationTsv setGenomeAssembly(String genomeAssembly) {
        this.genomeAssembly = genomeAssembly;
        return this;
    }

    public MutationTsv setPlatform(String platform) {
        this.platform = platform;
        return this;
    }

    public MutationTsv build() {
        return this;
    }
    
}
