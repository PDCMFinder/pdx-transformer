package org.pdxfinder.services.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.pdxfinder.constant.DataConstants;

import java.util.Objects;


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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TreatmentDto {


    @JsonProperty("Current Drug")
    @JsonAlias("Drug")
    private String currentDrug;

    @JsonProperty("Prior Drug")
    private String priorDrug;

    @JsonProperty("Manufacturer")
    private String manufacturer;

    @JsonProperty("Dose")
    private String dose;
    
    @JsonProperty("Duration")
    private String duration;

    @JsonProperty("Frequency")
    private String frequency;
    
    private String armSize;

    @JsonProperty("Response")
    private String response;

    @JsonProperty("Passage Range")
    private String passageRange;

    @JsonProperty("Starting Date")
    private String startingDate;

    @JsonProperty("Prior Date")
    private String priorDate;

    public String getCurrentDrug() {
        return currentDrug;
    }

    public String getPriorDrug() {
        return priorDrug;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getDose() {
        return Objects.toString(dose, DataConstants.EMPTY);
    }

    public String getDuration() {
        return Objects.toString(duration, DataConstants.EMPTY);
    }

    public String getFrequency() {
        return frequency;
    }

    public String getArmSize() {
        return armSize;
    }

    public String getResponse() {
        return response;
    }

    public String getPassageRange() {
        return passageRange;
    }

    public String getStartingDate() {
        return  Objects.toString(startingDate, DataConstants.EMPTY);
    }

    public String getPriorDate() {
        return priorDate;
    }

    public TreatmentDto setCurrentDrug(String currentDrug) {
        this.currentDrug = currentDrug;
        return this;
    }

    public TreatmentDto setPriorDrug(String priorDrug) {
        this.priorDrug = priorDrug;
        return this;
    }

    public TreatmentDto setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public TreatmentDto setDose(String dose) {
        this.dose = dose;
        return this;
    }

    public TreatmentDto setDuration(String duration) {
        this.duration = duration;
        return this;
    }

    public TreatmentDto setFrequency(String frequency) {
        this.frequency = frequency;
        return this;
    }

    public TreatmentDto setArmSize(String armSize) {
        this.armSize = armSize;
        return this;
    }

    public TreatmentDto setResponse(String response) {
        this.response = response;
        return this;
    }

    public TreatmentDto setPassageRange(String passageRange) {
        this.passageRange = passageRange;
        return this;
    }

    public TreatmentDto setStartingDate(String startingDate) {
        this.startingDate = startingDate;
        return this;
    }

    public TreatmentDto setPriorDate(String priorDate) {
        this.priorDate = priorDate;
        return this;
    }

    public TreatmentDto build() {
        return this;
    }
}
