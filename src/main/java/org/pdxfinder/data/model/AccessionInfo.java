package org.pdxfinder.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
                "run_accession",
                "sample_accession",
                "sample_alias"
        })
public class AccessionInfo {

    @JsonProperty("run_accession")
    private String runAccession;

    @JsonProperty("sample_accession")
    private String sampleAccession;

    @JsonProperty("sample_alias")
    private String sampleAlias;

    public AccessionInfo() {
        this.runAccession = "";
        this.sampleAccession = "";
        this.sampleAlias = "";
    }

    public String getRunAccession() {
        return runAccession;
    }

    public void setRunAccession(String runAccession) {
        this.runAccession = runAccession;
    }

    public String getSampleAccession() {
        return sampleAccession;
    }

    public void setSampleAccession(String sampleAccession) {
        this.sampleAccession = sampleAccession;
    }

    public String getSampleAlias() {
        return sampleAlias;
    }

    public void setSampleAlias(String sampleAlias) {
        this.sampleAlias = sampleAlias;
    }
}
