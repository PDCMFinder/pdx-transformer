package org.pdxfinder.util;

import org.pdxfinder.PatientInfo;
import org.pdxfinder.SpecimenSearch;

import java.util.List;

public class TransformUtil {

    private TransformUtil(){
    }

    public static String getModelId(SpecimenSearch specimenSearch){
        String pdmTypeDesc = specimenSearch.getPdmtypedescription();
        String tissueTypeDesc = specimenSearch.getTissuetypedescription();
        String modelID = "";
        if ((pdmTypeDesc.equals("PDX") || pdmTypeDesc.equals("Patient/Originator Specimen"))
                && (tissueTypeDesc.equals("Resection") || tissueTypeDesc.equals("Tumor Biopsy"))) {
            modelID = String.format("%s-%s", specimenSearch.getPatientid(), specimenSearch.getSpecimenid());
        }
        return modelID;
    }

    public static String getClinicalDiagnosis(SpecimenSearch specimenSearch, List<PatientInfo> patientInfos){
        StringBuilder clinicalDiagnosis = new StringBuilder(specimenSearch.getMeddradescription());
        for (PatientInfo patient : patientInfos) {

            if (specimenSearch.getPatientseqnbr().equals(patient.getPatientseqnbr())) {
                if (patient.getDiagnosissubtype() != null) {
                    clinicalDiagnosis.append(" | ").append(patient.getDiagnosissubtype());
                }
                if (patient.getAdditionalmedicalhistory() != null) {
                    clinicalDiagnosis.append(" | ").append(patient.getAdditionalmedicalhistory());
                }
                if (patient.getNotes() != null) {
                    clinicalDiagnosis.append(" | ").append(patient.getNotes());
                }
            }
        }
        clinicalDiagnosis = new StringBuilder(clinicalDiagnosis.toString().replaceAll("[^a-zA-Z,0-9 +_-]", "").trim());
        clinicalDiagnosis = new StringBuilder(clinicalDiagnosis.toString().replaceAll("\\s\\s", " "));
        return clinicalDiagnosis.toString();
    }

}
