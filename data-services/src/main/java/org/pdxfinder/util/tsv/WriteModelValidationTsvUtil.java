package org.pdxfinder.util.tsv;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.pdxfinder.dto.PdxDto;
import org.pdxfinder.dto.ValidationDto;
import org.pdxfinder.dto.tsv.MetadataModelValidationTsv;
import org.pdxfinder.dto.tsv.MetadataSharingTsv;
import org.pdxfinder.util.FileUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class WriteModelValidationTsvUtil {


    private WriteModelValidationTsvUtil() {
        // Never Called
    }

    public static void writeTsv(List<PdxDto> pdxDtoList, String outputDirectory) throws IOException {

        InputStream contents = FileUtil.class.getResourceAsStream("/templates/head_metadata-model_validation.tsv");
        CsvSchema.Builder builder = CsvSchema.builder();
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = builder.build().withHeader().withColumnSeparator('\t');

        MappingIterator<MetadataModelValidationTsv> iterator =
                mapper.readerFor(MetadataModelValidationTsv.class).with(schema).readValues(contents);
        List<MetadataModelValidationTsv> modelValidationTsvs = iterator.readAll();

        pdxDtoList.forEach(pdxDto -> {
            List<ValidationDto> validations = pdxDto.getValidationDtos();
            validations.forEach(validation -> modelValidationTsvs.add(new MetadataModelValidationTsv()
                                                                              .setField("")
                                                                              .setModelId(pdxDto.getModelID())
                                                                              .setValidationTechnique(validation.getTechnique())
                                                                              .setDescription(validation.getDescription())
                                                                              .setPassagesTested(validation.getPassage())
                                                                              .setValidationHostStrainFull("")));
        });

        String modelMetaData = FileUtil.serializePojoToTsv(modelValidationTsvs);
        String output = String.format("%s/metadata-model_validation.tsv", outputDirectory);
        FileUtil.write(modelMetaData, output, false);
    }
}
