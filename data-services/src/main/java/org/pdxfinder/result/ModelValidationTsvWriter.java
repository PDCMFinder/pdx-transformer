package org.pdxfinder.result;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.pdxfinder.constant.DataConstants;
import org.pdxfinder.constant.FileNames;
import org.pdxfinder.constant.TemplateLocations;
import org.pdxfinder.dto.PdxDto;
import org.pdxfinder.dto.ValidationDto;
import org.pdxfinder.result.dto.MetadataModelValidationTsv;
import org.pdxfinder.FileUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ModelValidationTsvWriter {


    private ModelValidationTsvWriter() {
        // Never Called
    }

    public static void writeTsv(List<PdxDto> pdxDtoList, String outputDirectory) throws IOException {

        InputStream contents = FileUtil.class.getResourceAsStream(TemplateLocations.METADATA_MODEL_VALIDATION);
        CsvSchema.Builder builder = CsvSchema.builder();
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = builder.build().withHeader().withColumnSeparator('\t');

        MappingIterator<MetadataModelValidationTsv> iterator =
                mapper.readerFor(MetadataModelValidationTsv.class).with(schema).readValues(contents);
        List<MetadataModelValidationTsv> modelValidationTsvs = iterator.readAll();

        pdxDtoList.forEach(pdxDto -> {
            List<ValidationDto> validations = pdxDto.getValidationDtos();
            validations.forEach(validation -> modelValidationTsvs.add(new MetadataModelValidationTsv()
                                                                              .setField(DataConstants.EMPTY)
                                                                              .setModelId(pdxDto.getModelID())
                                                                              .setValidationTechnique(validation.getTechnique())
                                                                              .setDescription(validation.getDescription())
                                                                              .setPassagesTested(validation.getPassage())
                                                                              .setValidationHostStrainFull(DataConstants.EMPTY)));
        });

        String modelMetaData = FileUtil.serializePojoToTsv(modelValidationTsvs);
        String output = String.format("%s%s", outputDirectory, FileNames.METADATA_MODEL_VALIDATION_TSV);
        FileUtil.write(modelMetaData, output);
    }
}
