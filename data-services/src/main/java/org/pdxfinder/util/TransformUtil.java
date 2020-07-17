package org.pdxfinder.util;

import org.pdxfinder.constant.*;
import org.pdxfinder.domain.*;
import org.pdxfinder.dto.ExtractDto;
import org.pdxfinder.dto.SampleDto;
import org.pdxfinder.dto.ValidationDto;
import org.pdxfinder.projection.HistologyProjection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class TransformUtil {

    private Logger log = LoggerFactory.getLogger(TransformUtil.class);
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
        if ((pdmTypeDesc.equals(CancerModelTypes.PDX_MODEL) || pdmTypeDesc.equals(CancerModelTypes.PATIENT_SPECIMEN))
                && (tissueTypeDesc.equals(TissueTypeConstants.RESECTION) || tissueTypeDesc.equals(TissueTypeConstants.TUMOR_BIOPSY))) {
            modelID = String.format("%s-%s", specimenSearch.getPatientid(), specimenSearch.getSpecimenid());
        }
        return modelID;
    }

    public String getClinicalDiagnosis(){
        StringBuilder clinicalDiagnosis = new StringBuilder(specimenSearch.getMeddradescription());
        for (PatientInfo patient : extracted.getPatientList()) {
            if (specimenSearch.getPatientseqnbr().equals(patient.getPatientseqnbr())) {
                if (patient.getDiagnosissubtype() != null) {
                    clinicalDiagnosis.append(DataConstants.PIPE_CHARACTER).append(patient.getDiagnosissubtype());
                }
                if (patient.getAdditionalmedicalhistory() != null) {
                    clinicalDiagnosis.append(DataConstants.PIPE_CHARACTER).append(patient.getAdditionalmedicalhistory());
                }
                if (patient.getNotes() != null) {
                    clinicalDiagnosis.append(DataConstants.PIPE_CHARACTER).append(patient.getNotes());
                }
            }
        }
        clinicalDiagnosis = new StringBuilder(clinicalDiagnosis.toString().replaceAll("[^a-zA-Z,0-9 +_-]", DataConstants.EMPTY).trim());
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

                if (FileUtil.isNumeric(samplePassage)) {
                    if (!sampleId.contains(CancerModelTypes.CANCER_ASSOCIATED_FIBROBLASTS)) {
                        sampleTumorType = TumorTypeConstants.ENGRAFTED_TUMOR;
                        sampleDtoList.add(new SampleDto(sampleId, sampleTumorType, samplePassage, wholeExomeSeqYn, wholeExomeSeqYn, wholeExomeSeqYn, rnaSeqYn, rnaSeqYn));
                    }else {
                        log.warn("This is Strange, CAF Culture that has passage number");
                    }
                } else {
                    if (sampleId.equals(DataConstants.PDMR_PATIENT_SAMPLE_ID)) {
                        sampleTumorType = TumorTypeConstants.PATIENT_TUMOR;
                        samplePassage = "";
                        sampleDtoList.add(new SampleDto(sampleId, sampleTumorType, samplePassage, wholeExomeSeqYn, wholeExomeSeqYn, wholeExomeSeqYn, rnaSeqYn, rnaSeqYn));
                    }else {
                        log.info("{} is neither PDX nor Patient Sample ", sampleId);
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
                                gradeValue = gradeValue.equals("---") ? DataConstants.NOT_SPECIFIED : gradeValue;
                            }
                        }
                    }
                }
            }
        }
        return gradeValue;
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
                    stageClassification = DataConstants.NOT_SPECIFIED ;
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
                    gradeClassification = DataConstants.NOT_SPECIFIED ;
                } else {
                    //2,3,4,5,6,7,12,13
                    gradeClassification = dTumorGradeStageType.getTumorgradestageshortname();
                    gradeClassification = gradeClassification.equals(DataConstants.NA) ? DataConstants.NOT_SPECIFIED  : gradeClassification;
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
        validationDtos.add(new ValidationDto(ValidationConstants.FINGER_PRINTING, ValidationConstants.FINGER_PRINTING_DESC, DataConstants.PASSAGE_ALL));
        validationDtos.add(new ValidationDto(ValidationConstants.HUMAN_MOUSE_DNA, ValidationConstants.FINGER_PRINTING_DESC, DataConstants.PASSAGE_ALL));
        validationDtos.add(new ValidationDto(ValidationConstants.HISTOLOGY, ValidationConstants.HISTOLOGY_DESC, DataConstants.PASSAGE_ALL));

        return validationDtos;
    }
}
