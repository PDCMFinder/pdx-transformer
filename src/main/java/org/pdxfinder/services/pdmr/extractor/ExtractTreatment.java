package org.pdxfinder.services.pdmr.extractor;

import org.pdxfinder.constant.DataConstants;
import org.pdxfinder.constant.DrugConstants;
import org.pdxfinder.data.model.*;
import org.pdxfinder.services.pdmr.dto.OracleDataDto;
import org.pdxfinder.services.common.dto.TreatmentDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ExtractTreatment {

    private static final Logger log = LoggerFactory.getLogger(ExtractTreatment.class);

    private ExtractTreatment() {
    }

    public static List<TreatmentDto> getCurrentTherapies(SpecimenSearch specimenSearch, OracleDataDto extracted){
        List<TreatmentDto> currentTherapies = new ArrayList<>();
        for (CurrentTherapy currentTherapy : extracted.getCurrentTherapies()) {
            String drug = "";
            String response = "";

            if (specimenSearch.getPatientseqnbr().equals(currentTherapy.getPatientseqnbr()) &&
                    (!currentTherapy.getRegimen().toLowerCase().contains("naive") && !currentTherapy.getRegimen().toLowerCase().contains("no current") &&  !currentTherapy.getRegimen().toLowerCase().contains("no prior") && !currentTherapy.getRegimen().toLowerCase().contains("undefined") && !currentTherapy.getRegimen().toLowerCase().contains("none"))
            ) {
                String duration = currentTherapy.getNumberofcycles() == null ? DataConstants.NOT_PROVIDED : currentTherapy.getNumberofcycles();
                String startingDate = currentTherapy.getDateregimenstarted() == null ? DataConstants.NOT_PROVIDED : String.valueOf(currentTherapy.getDateregimenstarted());
                try {
                    startingDate = startingDate.equals(DataConstants.NOT_PROVIDED) ? DataConstants.NOT_PROVIDED : startingDate.substring(0, 10);
                } catch (Exception e) {
                    log.warn(e.getMessage());
                }

                for (StandardizedRegimens standardRegimen : extracted.getStandardRegimens()) {
                    if (currentTherapy.getStandardizedregimenseqnbr().equals(standardRegimen.getRegimenseqnbr())) {
                        drug = standardRegimen.getDisplayedregimen().replace(",", " +");
                    }
                }
                for (ClinicalResponses dClinicalResponse : extracted.getClinicalResponses()) {
                    if (currentTherapy.getBestresponseseqnbr().equals(dClinicalResponse.getClinicalresponseseqnbr())) {
                        response = dClinicalResponse.getClinicalresponsedescription();
                        response = response.equals(DataConstants.UNKNOWN) ? DataConstants.NOT_PROVIDED : response;
                        response = response.equals("Not Applicable") ? DataConstants.NOT_PROVIDED : response;
                        response = response.equals("Non-evaluable") ? DataConstants.NOT_PROVIDED : response;
                        response = response.equals("Other") ? DataConstants.NOT_PROVIDED : response;
                    }
                }

                currentTherapies.add(new TreatmentDto().setCurrentDrug(cleanDrugs(drug))
                                             .setPriorDrug(null)
                                             .setManufacturer(DataConstants.EMPTY)
                                             .setDose(DataConstants.EMPTY)
                                             .setDuration(duration)
                                             .setFrequency(DataConstants.EMPTY)
                                             .setArmSize(DataConstants.EMPTY)
                                             .setResponse(response)
                                             .setPassageRange(DataConstants.EMPTY)
                                             .setStartingDate(startingDate)
                                             .setPriorDate(DataConstants.EMPTY).build());
            }
        }

        List<TreatmentDto> treatmentDtos = new ArrayList<>();
        treatmentDtos.addAll(currentTherapies);
        treatmentDtos.addAll(getPriorTherapies(specimenSearch, extracted));

        return treatmentDtos;
    }


    public static List<TreatmentDto> getPriorTherapies(SpecimenSearch specimenSearch, OracleDataDto extracted){
        List<TreatmentDto> treatmentDtos = new ArrayList<>();
        for (PriorTherapies priorTherapy : extracted.getPriorTherapiesList()) {
            String drug = "";
            String response = "";
            String priorDate;

            if (specimenSearch.getPatientseqnbr().equals(priorTherapy.getPatientseqnbr())) {
                priorDate = String.valueOf(priorTherapy.getDateregimenstarted());
                try {
                    priorDate = priorDate.equals(DataConstants.NULL_STRING) ?DataConstants.NOT_SPECIFIED : priorDate.substring(0, 10);
                } catch (Exception e) {
                    log.warn(e.getMessage());
                }

                String duration = priorTherapy.getDurationmonths() + " Months";
                for (StandardizedRegimens standardRegimen : extracted.getStandardRegimens()) {
                    if (priorTherapy.getStandardizedregimenseqnbr().equals(standardRegimen.getRegimenseqnbr())) {
                        drug = standardRegimen.getDisplayedregimen().replace(",", " +");
                    }
                }
                for (ClinicalResponses clinicalResponse : extracted.getClinicalResponses()) {
                    if (clinicalResponse.getClinicalresponseseqnbr().equals(priorTherapy.getBestresponseseqnbr())) {
                        response = clinicalResponse.getClinicalresponsedescription();
                        response = response.equals(DataConstants.UNKNOWN) ? DataConstants.NOT_SPECIFIED : response;
                    }
                }

                treatmentDtos.add(new TreatmentDto().setCurrentDrug(null)
                                          .setPriorDrug(cleanDrugs(drug))
                                          .setManufacturer(DataConstants.EMPTY)
                                          .setDose(DataConstants.EMPTY)
                                          .setDuration(duration)
                                          .setFrequency(DataConstants.EMPTY)
                                          .setArmSize(DataConstants.EMPTY)
                                          .setResponse(response)
                                          .setPassageRange(DataConstants.EMPTY)
                                          .setStartingDate(DataConstants.EMPTY)
                                          .setPriorDate(priorDate).build());
            }
        }
        return treatmentDtos;
    }



    private static String cleanDrugs(String drug) {
        String drugString = drug.contains(DrugConstants.FOLFOX) ? drug.replace(DrugConstants.FOLFOX, DrugConstants.FOLFOX_COMBO) : drug;
        // Always replace FOLFIRINOX before FOLFIRI
        drugString = drugString.contains(DrugConstants.FOLFIRINOX) ? drugString.replace(DrugConstants.FOLFIRINOX, DrugConstants.FOLFIRINOX_COMBO) : drugString;
        drugString = drugString.contains(DrugConstants.FOLFIRI) ? drugString.replace(DrugConstants.FOLFIRI, DrugConstants.FOLFIRI_COMBO) : drugString;
        drugString = drugString.contains(DrugConstants.MVAC) ? drugString.replace(DrugConstants.MVAC, DrugConstants.MVAC_COMBO) : drugString;
        drugString = drugString.contains(DrugConstants.XELOX) ? drugString.replace(DrugConstants.XELOX, DrugConstants.XELOX_COMBO) : drugString;
        return drugString;
    }
}
