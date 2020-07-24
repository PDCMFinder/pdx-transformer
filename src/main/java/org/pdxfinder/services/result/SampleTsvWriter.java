package org.pdxfinder.services.result;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.pdxfinder.constant.FileNames;
import org.pdxfinder.constant.TemplateLocations;
import org.pdxfinder.services.result.dto.MetadataSampleTsv;
import org.pdxfinder.services.dto.MetadataDto;
import org.pdxfinder.services.FileUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class SampleTsvWriter {

    private SampleTsvWriter() {
        // Never Called
    }


    public static void write2FileSystem(List<MetadataDto> metadataDtoList, String outputDirectory) throws IOException {

        InputStream contents = FileUtil.class.getResourceAsStream(TemplateLocations.META_DATA_SAMPLE);
        CsvSchema.Builder builder = CsvSchema.builder();
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = builder.build().withHeader().withColumnSeparator('\t');
        MappingIterator<MetadataSampleTsv> iterator = mapper.readerFor(MetadataSampleTsv.class).with(schema).readValues(contents);

        List<MetadataSampleTsv> metadataSampleTsvs = iterator.readAll();
        metadataDtoList.forEach(pdxDto -> metadataSampleTsvs.add(pdxDto.getMetadataSampleTsv()));

        String modelMetaData = FileUtil.serializePojoToTsv(metadataSampleTsvs);
        String output = String.format("%s%s", outputDirectory, FileNames.METADATA_SAMPLE_TSV);
        FileUtil.write(modelMetaData, output);
    }

}
