package org.pdxfinder.util.template;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.pdxfinder.constant.DataConstants;
import org.pdxfinder.constant.OutputFileNames;
import org.pdxfinder.constant.TemplateLocations;
import org.pdxfinder.dto.PdxDto;
import org.pdxfinder.dto.TreatmentDto;
import org.pdxfinder.dto.template.PatientTreatmentTsv;
import org.pdxfinder.util.FileUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

public class WritePatientTreatmentTsvUtil {


    private WritePatientTreatmentTsvUtil() {
        // Never Called
    }

    public static void writeTsv(List<PdxDto> pdxDtoList, String outputDirectory) throws IOException {

        InputStream contents = FileUtil.class.getResourceAsStream(TemplateLocations.PATIENT_TREATMENT);
        CsvSchema.Builder builder = CsvSchema.builder();
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = builder.build().withHeader().withColumnSeparator('\t');

        MappingIterator<PatientTreatmentTsv> iterator =
                mapper.readerFor(PatientTreatmentTsv.class).with(schema).readValues(contents);
        List<PatientTreatmentTsv> patientTreatmentTsvList = iterator.readAll();

        pdxDtoList.forEach(pdxDto -> {
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
        String output = String.format("%s%s", outputDirectory, OutputFileNames.PATIENT_TREATMENT_TSV);
        FileUtil.write(modelMetaData, output);
    }

}
