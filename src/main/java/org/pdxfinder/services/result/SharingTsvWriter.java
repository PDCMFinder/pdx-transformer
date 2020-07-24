package org.pdxfinder.services.result;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.pdxfinder.constant.FileNames;
import org.pdxfinder.constant.TemplateLocations;
import org.pdxfinder.services.dto.MetadataDto;
import org.pdxfinder.services.result.dto.MetadataSharingTsv;
import org.pdxfinder.services.FileUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class SharingTsvWriter {

    private SharingTsvWriter() {
        // Never Called
    }

    public static void write2FileSystem(List<MetadataDto> metadataDtoList, String outputDirectory) throws IOException {

        InputStream contents = FileUtil.class.getResourceAsStream(TemplateLocations.META_DATA_SHARING);
        CsvSchema.Builder builder = CsvSchema.builder();
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = builder.build().withHeader().withColumnSeparator('\t');

        MappingIterator<MetadataSharingTsv> iterator =
                mapper.readerFor(MetadataSharingTsv.class).with(schema).readValues(contents);

        List<MetadataSharingTsv> metadataSharingTsvs = iterator.readAll();
        metadataDtoList.forEach(pdxDto -> metadataSharingTsvs.add(pdxDto.getMetadataSharingTsv()));

        String modelMetaData = FileUtil.serializePojoToTsv(metadataSharingTsvs);
        String output = String.format("%s%s", outputDirectory, FileNames.METADATA_SHARING_TSV);
        FileUtil.write(modelMetaData, output);
    }

}


