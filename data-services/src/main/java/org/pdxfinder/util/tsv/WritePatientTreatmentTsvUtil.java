package org.pdxfinder.util.tsv;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.pdxfinder.dto.PdxDto;
import org.pdxfinder.dto.TreatmentDto;
import org.pdxfinder.dto.tsv.PatientTreatmentTsv;
import org.pdxfinder.util.FileUtil;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

public class WritePatientTreatmentTsvUtil {


    private WritePatientTreatmentTsvUtil() {
        // Never Called
    }

    public static void writeTsv(List<PdxDto> pdxDtoList, String outputDirectory) throws IOException {

        InputStream contents = FileUtil.class.getResourceAsStream("/templates/head_patient-treatment.tsv");
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
                                                    .setField("")
                                                    .setPatientId(pdxDto.getPatientID())
                                                    .setTreatmentName(treatmentName)
                                                    .setTreatmentDose(treatmentDto.getDose())
                                                    .setTreatmentStartingDate(treatmentDto.getStartingDate())
                                                    .setTreatmentDuration(treatmentDto.getDuration())
                                                    .setTreatmentEvent("")
                                                    .setElapsedTime("")
                                                    .setTreatmentResponse(treatmentDto.getResponse())
                                                    .setResponseClassification("")
                                                    .setModelId(pdxDto.getModelID()) );

            });

        });

        String modelMetaData = FileUtil.serializePojoToTsv(patientTreatmentTsvList);
        String output = String.format("%s/patient-treatment.tsv", outputDirectory);
        FileUtil.write(modelMetaData, output, false);
    }

}
