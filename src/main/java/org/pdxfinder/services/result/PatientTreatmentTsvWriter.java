package org.pdxfinder.services.result;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.pdxfinder.constant.DataConstants;
import org.pdxfinder.constant.FileNames;
import org.pdxfinder.constant.TemplateLocations;
import org.pdxfinder.services.common.dto.MetadataDto;
import org.pdxfinder.services.common.dto.TreatmentDto;
import org.pdxfinder.services.result.dto.PatientTreatmentTsv;
import org.pdxfinder.services.common.FileUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

public class PatientTreatmentTsvWriter {


    private PatientTreatmentTsvWriter() {
        // Never Called
    }

    public static void write2FileSystem(List<MetadataDto> metadataDtoList, String outputDirectory) throws IOException {

        InputStream contents = FileUtil.class.getResourceAsStream(TemplateLocations.PATIENT_TREATMENT);
        CsvSchema.Builder builder = CsvSchema.builder();
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = builder.build().withHeader().withColumnSeparator('\t');

        MappingIterator<PatientTreatmentTsv> iterator =
                mapper.readerFor(PatientTreatmentTsv.class).with(schema).readValues(contents);
        List<PatientTreatmentTsv> patientTreatmentTsvList = iterator.readAll();

        metadataDtoList.forEach(pdxDto -> {
            List<TreatmentDto> treatmentDtos = pdxDto.getTreatmentDtos();
            treatmentDtos.forEach(treatmentDto -> {

                String treatmentName = Optional.ofNullable(treatmentDto.getCurrentDrug()).orElse(treatmentDto.getPriorDrug());
                patientTreatmentTsvList.add(new PatientTreatmentTsv()
                                                    .setField(DataConstants.EMPTY)
                                                    .setPatientId(pdxDto.getPatientID())
                                                    .setTreatmentName(treatmentName)
                                                    .setTreatmentDose(treatmentDto.getDose())
                                                    .setTreatmentStartingDate(treatmentDto.getStartingDate())
                                                    .setTreatmentDuration(treatmentDto.getDuration())
                                                    .setTreatmentEvent(DataConstants.EMPTY)
                                                    .setElapsedTime(DataConstants.EMPTY)
                                                    .setTreatmentResponse(treatmentDto.getResponse())
                                                    .setResponseClassification(DataConstants.EMPTY)
                                                    .setModelId(pdxDto.getModelID()) );
            });

        });

        String modelMetaData = FileUtil.serializePojoToTsv(patientTreatmentTsvList);
        String output = String.format("%s%s", outputDirectory, FileNames.PATIENT_TREATMENT_TSV);
        FileUtil.write(modelMetaData, output);
    }

}
