package org.pdxfinder.util;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.pdxfinder.dto.PdxDto;
import org.pdxfinder.dto.SampleDto;
import org.pdxfinder.dto.MetadataModelTsv;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WriteModelTsvUtil {

    private WriteModelTsvUtil(){
        // Never Called
    }

    public static void writeTsv(List<PdxDto> pdxDtoList, String outputDirectory) throws IOException {

        InputStream contents = FileUtil.loadFixedTsvDescriptionRows();
        CsvSchema.Builder builder = CsvSchema.builder();
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = builder.build().withHeader().withColumnSeparator('\t');

        MappingIterator<MetadataModelTsv> iterator = mapper.readerFor(MetadataModelTsv.class).with(schema).readValues(contents);
        List<MetadataModelTsv> metadataModelTsvs = iterator.readAll();

        pdxDtoList.forEach(pdxDto -> {
            Set<String> passages = pdxDto.getSampleDtos().stream()
                    .filter(sampleDto -> sampleDto.getPassage() != null)
                    .map(SampleDto::getPassage)
                    .collect(Collectors.toSet());

            metadataModelTsvs.add(new MetadataModelTsv()
                               .setField("")
                               .setModelId(pdxDto.getModelID())
                               .setHostStrain("NOD scid gamma")
                               .setHostStrainFull(pdxDto.getStrain())
                               .setEngraftmentSite(pdxDto.getEngraftmentSite())
                               .setEngraftmentType(pdxDto.getEngraftmentType())
                               .setSampleType(pdxDto.getSampleType())
                               .setSampleState("Not Specified")
                               .setPublications("")
                               .setPassageNumber(String.join(",", passages)));
        });

        String modelMetaData = FileUtil.serializePojoToTsv(metadataModelTsvs);
        String output = String.format("%s/metadata-model.tsv", outputDirectory);
        FileUtil.write(modelMetaData, output, false);
    }
}
