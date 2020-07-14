package org.pdxfinder.util;

import org.pdxfinder.*;
import org.pdxfinder.dto.ExtractDto;
import org.pdxfinder.dto.PdxDto;
import org.pdxfinder.dto.TreatmentDto;

import java.util.ArrayList;
import java.util.List;
import static java.lang.System.out;

public class TreatmentUtil {

    private TreatmentUtil() {
    }

    public static List<TreatmentDto> getCurrentTherapies(SpecimenSearch specimenSearch, ExtractDto extracted){
        List<TreatmentDto> currentTherapies = new ArrayList<>();
        for (CurrentTherapy currentTherapy : extracted.getCurrentTherapies()) {
            String drug = "";
            String duration = "Not Specified";
            String response = "";

            if (specimenSearch.getPatientseqnbr().equals(currentTherapy.getPatientseqnbr())) {
                String startingDate = String.valueOf(currentTherapy.getDateregimenstarted());
                try {
                    startingDate = startingDate.equals("null") ? "Not Specified" : startingDate.substring(0, 10);
                } catch (Exception e) {
                    out.println(e.getMessage());
                }
                for (StandardizedRegimens standardRegimen : extracted.getStandardRegimens()) {
                    if (currentTherapy.getStandardizedregimenseqnbr().equals(standardRegimen.getRegimenseqnbr())) {
                        drug = standardRegimen.getDisplayedregimen().replace(",", " +");
                    }
                }
                for (ClinicalResponses dClinicalResponse : extracted.getClinicalResponses()) {
                    if (currentTherapy.getBestresponseseqnbr().equals(dClinicalResponse.getClinicalresponseseqnbr())) {
                        response = dClinicalResponse.getClinicalresponsedescription();
                        response = response.equals("<Unknown>") ? "Not Specified" : response;
                    }
                }

                currentTherapies.add(new TreatmentDto(cleanDrugs(drug), null, null, null, duration, null,
                                                      null, response, null, startingDate, null));
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
                    priorDate = priorDate.equals("null") ? "Not Specified" : priorDate.substring(0, 10);
                } catch (Exception e) {
                    out.println(e.getMessage());
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
                        response = response.equals("<Unknown>") ? "Not Specified" : response;
                    }
                }

                treatmentDtos.add(new TreatmentDto(null, cleanDrugs(drug), null, null, duration, null,
                                                   null, response, null, null, priorDate));
            }
        }
        return treatmentDtos;
    }



    private static String cleanDrugs(String drug) {
        String drugString = drug.contains("FOLFOX") ? drug.replace("FOLFOX", "Fluorouracil + Leucovorin Calcium + Oxaliplatin") : drug;
        // Always replace FOLFIRINOX before FOLFIRI
        drugString = drugString.contains("FOLFIRINOX") ? drugString.replace("FOLFIRINOX", "Fluorouracil + irinotecan + Leucovorin calcium + Oxaliplatin") : drugString;
        drugString = drugString.contains("FOLFIRI") ? drugString.replace("FOLFIRI", "Folinic acid + Fluorouracil + Irinotecan") : drugString;
        drugString = drugString.contains("MVAC") ? drugString.replace("MVAC", "Cisplatin + Doxorubicin + Methotrexate + Vinblastine") : drugString;
        drugString = drugString.contains("XELOX") ? drugString.replace("XELOX", "Capecitabine + Oxaliplatin") : drugString;
        return drugString;
    }
}
