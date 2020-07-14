package org.pdxfinder.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Current Drug",
        "Prior Drug",
        "Manufacturer",
        "Dose",
        "Duration",
        "Frequency",
        "Arm Size",
        "Response",
        "Passage Range",
        "Starting Date",
        "Prior Date"
})
public class TreatmentDto {

    private Integer id;

    private String currentDrug;
    private String priorDrug;
    private String manufacturer;
    private String dose;
    private String duration;
    private String frequency;
    private String armSize;
    private String response;
    private String passageRange;
    private String startingDate;
    private String priorDate;


    public TreatmentDto(String currentDrug, String priorDrug, String manufacturer,
                        String dose, String duration,
                        String frequency, String armSize,
                        String response, String passageRange, String startingDate, String priorDate) {
        this.priorDrug = priorDrug;
        this.currentDrug = currentDrug;
        this.manufacturer = manufacturer;
        this.dose = dose;
        this.duration = duration;
        this.frequency = frequency;
        this.armSize = armSize;
        this.response = response;
        this.passageRange = passageRange;
        this.startingDate = startingDate;
        this.priorDate = priorDate;
    }

    public TreatmentDto() {
    }

    @JsonProperty("Current Drug")
    public String getCurrentDrug() {
        return currentDrug;
    }

    @JsonProperty("Prior Drug")
    public String getPriorDrug() {
        return priorDrug;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getDose() {
        return dose;
    }

    @JsonProperty("Duration")
    public String getDuration() {
        return duration;
    }

    public String getFrequency() {
        return frequency;
    }

    @JsonProperty("Frequency")
    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getArmSize() {
        return armSize;
    }

    @JsonProperty("Response")
    public String getResponse() {
        return response;
    }

    public String getPassageRange() {
        return passageRange;
    }

    @JsonProperty("Starting Date")
    public String getStartingDate() {
        return startingDate;
    }

    @JsonProperty("Prior Date")
    public String getPriorDate() {
        return priorDate;
    }

}
