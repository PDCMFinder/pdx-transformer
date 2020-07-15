package org.pdxfinder.util;

import org.pdxfinder.domain.*;
import org.pdxfinder.dto.ExtractDto;
import org.pdxfinder.dto.SampleDto;
import org.pdxfinder.dto.ValidationDto;
import org.pdxfinder.domain.projection.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.*;

public class TransformUtil {

    private SpecimenSearch specimenSearch;
    private ExtractDto extracted;

    public TransformUtil(SpecimenSearch specimenSearch, ExtractDto extracted) {
        this.specimenSearch = specimenSearch;
        this.extracted = extracted;
    }



    public String getModelId(){
        String pdmTypeDesc = specimenSearch.getPdmtypedescription();
        String tissueTypeDesc = specimenSearch.getTissuetypedescription();
        String modelID = "";
        if ((pdmTypeDesc.equals("PDX") || pdmTypeDesc.equals("Patient/Originator Specimen"))
                && (tissueTypeDesc.equals("Resection") || tissueTypeDesc.equals("Tumor Biopsy"))) {
            modelID = String.format("%s-%s", specimenSearch.getPatientid(), specimenSearch.getSpecimenid());
        }
        return modelID;
    }

    public String getClinicalDiagnosis(){
        StringBuilder clinicalDiagnosis = new StringBuilder(specimenSearch.getMeddradescription());
        for (PatientInfo patient : extracted.getPatientList()) {
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



    public List<SampleDto> getSamples(){
        List<SampleDto> sampleDtoList = new ArrayList<>();
        for (Sample dSample : extracted.getSamples()) {
            if (specimenSearch.getSpecimenseqnbr().equals(dSample.getSpecimenseqnbr())) {
                String sampleId = dSample.getSampleid();
                String wholeExomeSeqYn = dSample.getWholeexomesequenceftpyn();
                String rnaSeqYn = dSample.getRnasequenceftpyn();
                String samplePassage = String.valueOf(dSample.getPassageofthissample());
                String sampleTumorType = "";

                if (isNumeric(samplePassage)) {
                    if (!sampleId.contains("CAF")) {
                        sampleTumorType = "engrafted Tumor";
                        sampleDtoList.add(new SampleDto(sampleId, sampleTumorType, samplePassage, wholeExomeSeqYn, wholeExomeSeqYn, wholeExomeSeqYn, rnaSeqYn, rnaSeqYn));
                    }else {
                        out.println("This is Strange, CAF Culture that has passage number");
                    }
                } else {
                    if (sampleId.equals("ORIGINATOR")) {
                        sampleTumorType = "patient Tumor";
                        samplePassage = null;
                        sampleDtoList.add(new SampleDto(sampleId, sampleTumorType, samplePassage, wholeExomeSeqYn, wholeExomeSeqYn, wholeExomeSeqYn, rnaSeqYn, rnaSeqYn));
                    }else {
                        out.println("This is neither PDX nor Patient Sample ");
                    }
                }
            }
        }
        return sampleDtoList;
    }

    public String getGradeValue(){
        String gradeValue = "";
        for (Sample dSample : extracted.getSamples()) {
            if (specimenSearch.getSpecimenseqnbr().equals(dSample.getSpecimenseqnbr())) {
                for (HistologyProjection histology : extracted.getHistologies()) {
                    if (dSample.getSampleseqnbr().equals(histology.getSampleSeqnbr())) {
                        for (TumorGrades tumorGrade : extracted.getTumorGradesList()) {
                            if (histology.getTumorGradeSeqNbr().equals(tumorGrade.getTumorgradeseqnbr())) {
                                gradeValue = tumorGrade.getTumorgradeshortname();
                                gradeValue = gradeValue.equals("---") ? "Not Specified" : gradeValue;
                            }
                        }
                    }
                }
            }
        }
        return gradeValue;
    }



    public boolean isNumeric(String val) {
        boolean report = false;
        try {
            Double.parseDouble(val);
            report = true;
        } catch (Exception e) {
        }
        return report;
    }


    public String getStageClassification() {
        String stageClassification = "";
        for (TumorGradeStageTypes dTumorGradeStageType : extracted.getTumorGradeStageTypes()) {
            if (specimenSearch.getTumorgradestageseqnbr().equals(dTumorGradeStageType.getTumorgradestageseqnbr())) {
                String x = specimenSearch.getTumorgradestageseqnbr();
                if (x.equals("1") || x.equals("8") || x.equals("9") || x.equals("10") || x.equals("11")) {
                    //1,8,9,10,11
                    stageClassification = dTumorGradeStageType.getTumorgradestageshortname();
                } else {
                    //2,3,4,5,6,7,12,13
                    stageClassification = "Not Specified";
                }
            }
        }
        return stageClassification;
    }

    public String getGradeClassification() {
        String gradeClassification = "";
        for (TumorGradeStageTypes dTumorGradeStageType : extracted.getTumorGradeStageTypes()) {
            if (specimenSearch.getTumorgradestageseqnbr().equals(dTumorGradeStageType.getTumorgradestageseqnbr())) {

                String x = specimenSearch.getTumorgradestageseqnbr();
                if (x.equals("1") || x.equals("8") || x.equals("9") || x.equals("10") || x.equals("11")) {
                    //1,8,9,10,11
                    gradeClassification = "Not Specified";
                } else {
                    //2,3,4,5,6,7,12,13
                    gradeClassification = dTumorGradeStageType.getTumorgradestageshortname();
                    gradeClassification = gradeClassification.equals("NA") ? "Not Specified" : gradeClassification;
                }
            }
        }
        return gradeClassification;
    }

    public String getExtractionMethod() {
        String extractionMethod = "";
        for (TissueTypes tissueType : extracted.getTissueTypes()) {
            if (specimenSearch.getTissuetypeshortname().equals(tissueType.getTissuetypeshortname())) {
                extractionMethod = tissueType.getTissuetypedescription();
            }
        }
        return extractionMethod;
    }

    public List<ValidationDto> getValidations(){
        // Hardcode the validation techniques.
        List<ValidationDto> validationDtos = new ArrayList<>();
        validationDtos.add(new ValidationDto("Fingerprinting", "Model validated against  patient tumour or P0 xenograft", "All"));
        validationDtos.add(new ValidationDto("Human mouse/DNA", "Model validated against  patient tumour or P0 xenograft", "All"));
        validationDtos.add(new ValidationDto("Histology", "Model validated against histological features of same diagnosis", "All"));

        return validationDtos;
    }
}
