package org.pdxfinder.util.template;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.pdxfinder.constant.FileNames;
import org.pdxfinder.constant.TemplateLocations;
import org.pdxfinder.dto.PdxDto;
import org.pdxfinder.dto.template.MetadataSharingTsv;
import org.pdxfinder.util.FileUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class WriteSharingTsvUtil {

    private WriteSharingTsvUtil() {
        // Never Called
    }

    public static void writeTsv(List<PdxDto> pdxDtoList, String outputDirectory) throws IOException {

        InputStream contents = FileUtil.class.getResourceAsStream(TemplateLocations.META_DATA_SHARING);
        CsvSchema.Builder builder = CsvSchema.builder();
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = builder.build().withHeader().withColumnSeparator('\t');

        MappingIterator<MetadataSharingTsv> iterator =
                mapper.readerFor(MetadataSharingTsv.class).with(schema).readValues(contents);

        List<MetadataSharingTsv> metadataSharingTsvs = iterator.readAll();
        pdxDtoList.forEach(pdxDto -> metadataSharingTsvs.add(pdxDto.getMetadataSharingTsv()));

        String modelMetaData = FileUtil.serializePojoToTsv(metadataSharingTsvs);
        String output = String.format("%s%s", outputDirectory, FileNames.METADATA_SHARING_TSV);
        FileUtil.write(modelMetaData, output);
    }

}


