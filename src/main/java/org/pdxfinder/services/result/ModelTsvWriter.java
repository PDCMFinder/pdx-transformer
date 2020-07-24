package org.pdxfinder.services.result;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.pdxfinder.constant.FileNames;
import org.pdxfinder.constant.TemplateLocations;
import org.pdxfinder.services.common.dto.MetadataDto;
import org.pdxfinder.services.common.dto.SampleDto;
import org.pdxfinder.services.result.dto.MetadataModelTsv;
import org.pdxfinder.services.common.FileUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ModelTsvWriter {

    private ModelTsvWriter(){
        // Never Called
    }

    public static void write2FileSystem(List<MetadataDto> metadataDtoList, String outputDirectory) throws IOException {

        InputStream contents = FileUtil.class.getResourceAsStream(TemplateLocations.METADATA_MODEL_TEMPLATE);
        CsvSchema.Builder builder = CsvSchema.builder();
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = builder.build().withHeader().withColumnSeparator('\t');

        MappingIterator<MetadataModelTsv> iterator = mapper.readerFor(MetadataModelTsv.class).with(schema).readValues(contents);
        List<MetadataModelTsv> metadataModelTsvs = iterator.readAll();

        metadataDtoList.forEach(pdxDto -> {
            Set<String> passages = pdxDto.getSampleDtos().stream()
                    .filter(sampleDto -> !sampleDto.getPassage().isEmpty())
                    .map(SampleDto::getPassage)
                    .collect(Collectors.toSet());

            metadataModelTsvs.add(new MetadataModelTsv()
                               .setField("")
                               .setModelId(pdxDto.getModelID())
                               .setHostStrain(pdxDto.getHostStrain())
                               .setHostStrainFull(pdxDto.getHostStrainFull())
                               .setEngraftmentSite(pdxDto.getEngraftmentSite())
                               .setEngraftmentType(pdxDto.getEngraftmentType())
                               .setSampleType(pdxDto.getSampleType())
                               .setSampleState(pdxDto.getSampleState())
                               .setPublications(pdxDto.getPublications())
                               .setPassageNumber(String.join(",", passages)));
        });

        String modelMetaData = FileUtil.serializePojoToTsv(metadataModelTsvs);
        String output = String.format("%s%s", outputDirectory, FileNames.METADATA_MODEL_TSV);
        FileUtil.write(modelMetaData, output);
    }
}
