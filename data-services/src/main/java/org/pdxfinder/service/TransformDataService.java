package org.pdxfinder.service;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.pdxfinder.*;
import org.pdxfinder.dto.*;
import org.pdxfinder.projection.HistologyProjection;
import org.pdxfinder.util.WriteModelTsvUtil;
import org.pdxfinder.util.WritePatientTsvUtil;
import org.pdxfinder.util.TransformUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransformDataService {

    @Value("${output.directory}")
    private String outputDirectory;

    private final Logger log = LoggerFactory.getLogger(TransformDataService.class);

    private final ExtractService extractService;

    public TransformDataService(ExtractService extractService) {
        this.extractService = extractService;
    }

    public List<TransformPdx> transformerData() throws IOException {

        ExtractDto extracted = extractService.execute();

        List<String> modelIDList = new ArrayList<>();
        List<TransformPdx> transformPdxList = new ArrayList<>();

        for (SpecimenSearch specimenSearch : extracted.getSpecimenSearchList()) {

            String age;
            String specimenSite;
            String unKnown = "Not Specified";
            String sampleType;
            String treatmentNaive;
            String engraftmentSite;
            String engraftmentType = "";
            String sourceUrl;
            String extractionMethod;
            String dateAtCollection;
            String accessibility;

            String drug = "";
            String startingDate;
            String priorDate;
            String response = "";
            String duration = unKnown;

            String sampleId;
            String sampleTumorType;
            String samplePassage;
            String wholeExomeSeqYn;
            String rnaSeqYn;

            String modelID = TransformUtil.getModelId(specimenSearch);
            if (modelID.isEmpty() || modelIDList.contains(modelID)) {
                continue;
            }

            modelIDList.add(modelID);
            String patientID = specimenSearch.getPatientid();
            String gender = specimenSearch.getGender().equals("M") ? "Male" : "Female";
            String race = specimenSearch.getRacedescription().equals("Not Provided") ? unKnown : specimenSearch.getRacedescription();
            String ethnicity = specimenSearch.getEthnicitydescription().equals("Not Provided") ? unKnown : specimenSearch.getEthnicitydescription();
            String primarySite = specimenSearch.getDiseaselocationdescription();

            String initialDiagnosis = "";
            String tumorType = "";
            String stageClassification = "";
            String stageValue = unKnown;
            String gradeClassification = "";
            String gradeValue = "";
            sampleType = specimenSearch.getTissuetypedescription();
            String strain = "";
            String mouseSex = "";
            engraftmentSite = "";
            String DATASOURCE_URL_PREFIX = "https://pdmdb.cancer.gov/pls/apex/f?p=101:4:0::NO:4:P4_SPECIMENSEQNBR:";
            sourceUrl = DATASOURCE_URL_PREFIX + specimenSearch.getSpecimenseqnbr();
            extractionMethod = "";
            dateAtCollection = "";
            accessibility = "";
            treatmentNaive = null;
            age = "";
            specimenSite = "";


            String clinicalDiagnosis = TransformUtil.getClinicalDiagnosis(specimenSearch, extracted.getPatientList());

            List<TransformSample> sampleList = new ArrayList<>();
            for (Sample dSample : extracted.getSamples()) {
                if (specimenSearch.getSpecimenseqnbr().equals(dSample.getSpecimenseqnbr())) {
                    sampleId = dSample.getSampleid();
                    wholeExomeSeqYn = dSample.getWholeexomesequenceftpyn();
                    rnaSeqYn = dSample.getRnasequenceftpyn();
                    samplePassage = String.valueOf(dSample.getPassageofthissample());

                    if (isNumeric(samplePassage)) {
                        if (!sampleId.contains("CAF")) {
                            sampleTumorType = "engrafted Tumor";
                            sampleList.add(new TransformSample(sampleId, sampleTumorType, samplePassage, wholeExomeSeqYn, wholeExomeSeqYn, wholeExomeSeqYn, rnaSeqYn, rnaSeqYn));
                        } else {
                            log.warn("This is Strange, CAF Culture that has passage number");
                        }
                    } else {
                        if (sampleId.equals("ORIGINATOR")) {
                            sampleTumorType = "patient Tumor";
                            samplePassage = null;
                            sampleList.add(new TransformSample(sampleId, sampleTumorType, samplePassage, wholeExomeSeqYn, wholeExomeSeqYn, wholeExomeSeqYn, rnaSeqYn, rnaSeqYn));
                        } else {
                            log.warn("This is neither PDX nor Patient Sample ");
                        }
                    }

                    // Retrieve Grade Value
                    for (HistologyProjection histology : extracted.getHistologies()) {
                        if (dSample.getSampleseqnbr().equals(histology.getSampleSeqnbr())) {
                            for (TumorGrades tumorGrade : extracted.getTumorGradesList()) {
                                if (histology.getTumorGradeSeqNbr().equals(tumorGrade.getTumorgradeseqnbr())) {
                                    gradeValue = tumorGrade.getTumorgradeshortname();
                                    gradeValue = gradeValue.equals("---") ? unKnown : gradeValue;
                                }
                            }
                        }
                    }
                }
            }


            // Get Treatment Data
            List<TransformTreatment> transformTreatments = new ArrayList<>();
            for (CurrentTherapy currentTherapy : extracted.getCurrentTherapies()) {

                if (specimenSearch.getPatientseqnbr().equals(currentTherapy.getPatientseqnbr())) {
                    startingDate = String.valueOf(currentTherapy.getDateregimenstarted());
                    try {
                        startingDate = startingDate.equals("null") ? unKnown : startingDate.substring(0, 10);
                    } catch (Exception e) {
                        log.error(e.getMessage());
                    }

                    for (StandardizedRegimens standardRegimen : extracted.getStandardRegimens()) {
                        if (currentTherapy.getStandardizedregimenseqnbr().equals(standardRegimen.getRegimenseqnbr())) {
                            drug = standardRegimen.getDisplayedregimen().replace(",", " +");
                        }
                    }

                    for (ClinicalResponses dClinicalResponse : extracted.getClinicalResponses()) {
                        if (currentTherapy.getBestresponseseqnbr().equals(dClinicalResponse.getClinicalresponseseqnbr())) {
                            response = dClinicalResponse.getClinicalresponsedescription();
                            response = response.equals("<Unknown>") ? unKnown : response;
                        }
                    }

                    transformTreatments.add(new TransformTreatment(cleanDrugs(drug), null, null, null, duration, null,
                                                                   null, response, null, startingDate, null));

                    drug = "";
                    duration = unKnown;
                    response = "";
                }
            }

            for (PriorTherapies priorTherapy : extracted.getPriorTherapiesList()) {
                if (specimenSearch.getPatientseqnbr().equals(priorTherapy.getPatientseqnbr())) {
                    priorDate = String.valueOf(priorTherapy.getDateregimenstarted());
                    try {
                        priorDate = priorDate.equals("null") ? unKnown : priorDate.substring(0, 10);
                    } catch (Exception e) {
                        log.error(e.getMessage());
                    }

                    duration = priorTherapy.getDurationmonths() + " Months";

                    for (StandardizedRegimens standardRegimen : extracted.getStandardRegimens()) {
                        if (priorTherapy.getStandardizedregimenseqnbr().equals(standardRegimen.getRegimenseqnbr())) {
                            drug = standardRegimen.getDisplayedregimen().replace(",", " +");
                        }
                    }


                    for (ClinicalResponses clinicalResponse : extracted.getClinicalResponses()) {
                        if (clinicalResponse.getClinicalresponseseqnbr().equals(priorTherapy.getBestresponseseqnbr())) {
                            response = clinicalResponse.getClinicalresponsedescription();
                            response = response.equals("<Unknown>") ? unKnown : response;
                        }
                    }

                    transformTreatments.add(new TransformTreatment(null, cleanDrugs(drug), null, null, duration, null,
                                                                   null, response, null, null, priorDate));

                    drug = "";
                    duration = unKnown;
                    response = "";
                }
            }


            for (TumorGradeStageTypes dTumorGradeStageType : extracted.getTumorGradeStageTypes()) {
                if (specimenSearch.getTumorgradestageseqnbr().equals(dTumorGradeStageType.getTumorgradestageseqnbr())) {

                    String x = specimenSearch.getTumorgradestageseqnbr();
                    if (x.equals("1") || x.equals("8") || x.equals("9") || x.equals("10") || x.equals("11")) {
                        //1,8,9,10,11
                        stageClassification = dTumorGradeStageType.getTumorgradestageshortname();
                        gradeClassification = unKnown;
                    } else {
                        //2,3,4,5,6,7,12,13
                        gradeClassification = dTumorGradeStageType.getTumorgradestageshortname();
                        gradeClassification = gradeClassification.equals("NA") ? "Not Specified" : gradeClassification;
                        stageClassification = unKnown;
                    }
                }
            }


            for (TissueTypes tissueType : extracted.getTissueTypes()) {
                if (specimenSearch.getTissuetypeshortname().equals(tissueType.getTissuetypeshortname())) {
                    extractionMethod = tissueType.getTissuetypedescription();
                }
            }


            for (Specimen specimen : extracted.getSpecimenList()) {
                if (specimenSearch.getSpecimenid().equals(specimen.getSpecimenid())) {
                    age = specimen.getAgeatsampling();
                    specimenSite = specimen.getBiopsysite();
                    dateAtCollection = specimen.getCollectiondate().toString().substring(0, 10);
                    accessibility = specimen.getPublicaccessyn();
                    if (accessibility.equals("Y")) {
                        accessibility = "Public";
                    }

                    for (MouseStrains mouseStrain : extracted.getMouseStrains()) {
                        if (specimen.getMousestrainseqnbr().equals(mouseStrain.getMousestrainseqnbr())) {
                            strain = mouseStrain.getMousestraindescript();
                        }
                    }

                    for (ImplantationSites impantationSite : extracted.getImplantationSites()) {
                        if (specimen.getImplantationsiteseqnbr().equals(impantationSite.getImplantationsiteseqnbr())) {
                            engraftmentSite = impantationSite.getImplantationsitedescription();
                        }
                    }

                    if (specimen.getImplantationsiteseqnbr().equals("0")) {
                        engraftmentType = "Heterotopic";
                    } else if (specimen.getImplantationsiteseqnbr().equals("99")) {
                        engraftmentSite = unKnown;
                        engraftmentType = unKnown;
                    } else {
                        engraftmentType = "Orthotopic";
                    }

                    for (ProvidedTissueOrigins tissueOrigin : extracted.getTissueOrigins()) {
                        if (specimen.getProvidedtissueoriginseqnbr().equals(tissueOrigin.getProvidedtissueoriginseqnbr())) {
                            tumorType = tissueOrigin.getProvidedtissueorigindescript();
                            tumorType = tumorType.equals("Metastatic Site") ? "Metastatic" : tumorType;
                        }
                    }
                }
            }

            // Hardcode the validation techniques.
            List<TransformValidation> transformValidations = new ArrayList<>();
            transformValidations.add(new TransformValidation("Fingerprinting", "Model validated against  patient tumour or P0 xenograft", "All"));
            transformValidations.add(new TransformValidation("Human mouse/DNA", "Model validated against  patient tumour or P0 xenograft", "All"));
            transformValidations.add(new TransformValidation("Histology", "Model validated against histological features of same diagnosis", "All"));

            TransformPdx transformPdx = new TransformPdx(modelID, patientID, gender, age, race, ethnicity, specimenSite, primarySite, initialDiagnosis,
                                                         clinicalDiagnosis, tumorType, stageClassification, stageValue, gradeClassification, gradeValue, sampleType, strain, mouseSex,
                                                         treatmentNaive, engraftmentSite, engraftmentType, sourceUrl, extractionMethod, dateAtCollection, accessibility, transformTreatments, transformValidations, sampleList);

            transformPdxList.add(transformPdx);
        }

        WritePatientTsvUtil.writeTsv(transformPdxList, outputDirectory);
        WriteModelTsvUtil.writeTsv(transformPdxList, outputDirectory);

        return transformPdxList;
    }


    public List<WriteModelDto> readFile() throws IOException {

        File csvFile = new File(System.getProperty("user.dir")+"/init.tsv");

        CsvSchema.Builder builder = CsvSchema.builder();
        CsvSchema  schema = builder.build().withHeader().withColumnSeparator('\t');

        CsvMapper mapper = new CsvMapper();
        MappingIterator<WriteModelDto> iterator = mapper
                .readerFor(WriteModelDto.class)
                .with(schema).readValues(csvFile);


        List<WriteModelDto> writeModelDtos = iterator.readAll();
        writeModelDtos.forEach(writeModelDto -> {
            log.info(writeModelDto.toString());
        });

        return iterator.readAll();
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


    private String cleanDrugs(String drug) {
        String drugString = drug.contains("FOLFOX") ? drug.replace("FOLFOX", "Fluorouracil + Leucovorin Calcium + Oxaliplatin") : drug;
        // Always replace FOLFIRINOX before FOLFIRI
        drugString = drugString.contains("FOLFIRINOX") ? drugString.replace("FOLFIRINOX", "Fluorouracil + irinotecan + Leucovorin calcium + Oxaliplatin") : drugString;
        drugString = drugString.contains("FOLFIRI") ? drugString.replace("FOLFIRI", "Folinic acid + Fluorouracil + Irinotecan") : drugString;
        drugString = drugString.contains("MVAC") ? drugString.replace("MVAC", "Cisplatin + Doxorubicin + Methotrexate + Vinblastine") : drugString;
        drugString = drugString.contains("XELOX") ? drugString.replace("XELOX", "Capecitabine + Oxaliplatin") : drugString;
        return drugString;
    }

}
