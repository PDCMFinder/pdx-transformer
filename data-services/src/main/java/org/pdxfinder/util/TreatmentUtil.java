package org.pdxfinder.util;

import org.pdxfinder.constant.DataConstants;
import org.pdxfinder.constant.DrugConstants;
import org.pdxfinder.domain.*;
import org.pdxfinder.dto.ExtractDto;
import org.pdxfinder.dto.TreatmentDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class TreatmentUtil {

    private static final Logger log = LoggerFactory.getLogger(TreatmentUtil.class);

    private TreatmentUtil() {
    }

    public static List<TreatmentDto> getCurrentTherapies(SpecimenSearch specimenSearch, ExtractDto extracted){
        List<TreatmentDto> currentTherapies = new ArrayList<>();
        for (CurrentTherapy currentTherapy : extracted.getCurrentTherapies()) {
            String drug = "";
            String duration = DataConstants.NOT_SPECIFIED;
            String response = "";

            if (specimenSearch.getPatientseqnbr().equals(currentTherapy.getPatientseqnbr())) {
                String startingDate = String.valueOf(currentTherapy.getDateregimenstarted());
                try {
                    startingDate = startingDate.equals(DataConstants.NULL_STRING) ? DataConstants.NOT_SPECIFIED : startingDate.substring(0, 10);
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
                        response = response.equals(DataConstants.UNKNOWN) ? "Not Specified" : response;
                    }
                }

                currentTherapies.add(new TreatmentDto(cleanDrugs(drug), null, DataConstants.EMPTY, DataConstants.EMPTY, duration, DataConstants.EMPTY,
                                                      DataConstants.EMPTY, response, DataConstants.EMPTY, startingDate, DataConstants.EMPTY));
            }
        }

        List<TreatmentDto> treatmentDtos = new ArrayList<>();
        treatmentDtos.addAll(currentTherapies);
        treatmentDtos.addAll(getPriorTherapies(specimenSearch, extracted));

        return treatmentDtos;
    }


    public static List<TreatmentDto> getPriorTherapies(SpecimenSearch specimenSearch, ExtractDto extracted){
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

                treatmentDtos.add(new TreatmentDto(null, cleanDrugs(drug), DataConstants.EMPTY, DataConstants.EMPTY, duration, DataConstants.EMPTY,
                                                   DataConstants.EMPTY, response, DataConstants.EMPTY, DataConstants.EMPTY, priorDate));
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
