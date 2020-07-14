package org.pdxfinder.service;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.pdxfinder.*;
import org.pdxfinder.dto.*;
import org.pdxfinder.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
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

    public List<PdxDto> transformerData() throws IOException {

        ExtractDto extracted = extractService.execute();
        List<String> modelIds = new ArrayList<>();
        List<PdxDto> pdxDtos = new ArrayList<>();

        for (SpecimenSearch specimenSearch : extracted.getSpecimenSearchList()) {

            TransformUtil transformUtil = new TransformUtil(specimenSearch, extracted);

            String modelId = transformUtil.getModelId();
            if (modelId.isEmpty() || modelIds.contains(modelId)) {
                continue;
            }
            modelIds.add(modelId);

            PdxDto pdxDto = SpecimenDataUtil.get(specimenSearch, extracted);
            List<TreatmentDto> treatmentDtos = TreatmentUtil.getCurrentTherapies(specimenSearch, extracted);

            pdxDto.setModelID(modelId)
                    .setPatientID(specimenSearch.getPatientid())
                    .setPrimarySite(specimenSearch.getDiseaselocationdescription())
                    .setSampleType(specimenSearch.getTissuetypedescription())
                    .setInitialDiagnosis("")
                    .setClinicalDiagnosis(transformUtil.getClinicalDiagnosis())
                    .setStageClassification(transformUtil.getStageClassification())
                    .setGradeClassification(transformUtil.getGradeClassification())
                    .setGradeValue(transformUtil.getGradeValue())
                    .setExtractionMethod(transformUtil.getExtractionMethod())
                    .setValidationDtos(transformUtil.getValidations())
                    .setSampleDtos(transformUtil.getSamples())
                    .setStageValue("Not Specified")
                    .setMouseSex("")
                    .setTreatmentNaive(null)
                    .setTreatmentDtos(treatmentDtos);

            pdxDtos.add(pdxDto);
        }

        WritePatientTsvUtil.writeTsv(pdxDtos, outputDirectory);
        WriteModelTsvUtil.writeTsv(pdxDtos, outputDirectory);
        WriteSampleTsvUtil.writeTsv(pdxDtos, outputDirectory);

        return pdxDtos;
    }



}
