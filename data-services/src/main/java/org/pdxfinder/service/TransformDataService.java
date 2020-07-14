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

    public List<PdxDto> transformerData() throws IOException {

        ExtractDto extracted = extractService.execute();
        List<String> modelIDList = new ArrayList<>();
        List<PdxDto> pdxDtoList = new ArrayList<>();

        for (SpecimenSearch specimenSearch : extracted.getSpecimenSearchList()) {

            TransformUtil transformUtil = new TransformUtil(specimenSearch, extracted);

            String modelID = transformUtil.getModelId();
            if (modelID.isEmpty() || modelIDList.contains(modelID)) {
                continue;
            }
            modelIDList.add(modelID);

            PdxDto pdxDto = SpecimenDataUtil.get(specimenSearch, extracted);
            List<TreatmentDto> treatmentDtos = TreatmentUtil.getCurrentTherapies(specimenSearch, extracted);

            pdxDto.setModelID(modelID)
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

            pdxDtoList.add(pdxDto);
        }

        WritePatientTsvUtil.writeTsv(pdxDtoList, outputDirectory);
        WriteModelTsvUtil.writeTsv(pdxDtoList, outputDirectory);

        return pdxDtoList;
    }


    public List<WriteModelDto> readFile() throws IOException {

        File csvFile = new File(System.getProperty("user.dir") + "/init.tsv");

        CsvSchema.Builder builder = CsvSchema.builder();
        CsvSchema schema = builder.build().withHeader().withColumnSeparator('\t');

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

}
