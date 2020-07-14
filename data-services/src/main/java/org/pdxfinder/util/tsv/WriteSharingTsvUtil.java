package org.pdxfinder.util.tsv;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.pdxfinder.dto.PdxDto;
import org.pdxfinder.dto.tsv.MetadataSampleTsv;
import org.pdxfinder.dto.tsv.MetadataSharingTsv;
import org.pdxfinder.util.FileUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class WriteSharingTsvUtil {

    private WriteSharingTsvUtil() {
        // Never Called
    }

    public static void writeTsv(List<PdxDto> pdxDtoList, String outputDirectory) throws IOException {

        InputStream contents = FileUtil.class.getResourceAsStream("/templates/head_metadata-sharing.tsv");
        CsvSchema.Builder builder = CsvSchema.builder();
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = builder.build().withHeader().withColumnSeparator('\t');

        MappingIterator<MetadataSharingTsv> iterator = mapper.readerFor(MetadataSharingTsv.class).with(schema).readValues(contents);

        List<MetadataSharingTsv> metadataSharingTsvs = iterator.readAll();

        pdxDtoList.forEach(pdxDto -> metadataSharingTsvs.add(new MetadataSharingTsv()
                                                                     .setField("")
                                                                     .setModelId(pdxDto.getModelID())
                                                                     .setProviderType("")
                                                                     .setAccessibility("")
                                                                     .setEuropdxAccessModality("")
                                                                     .setEmail("")
                                                                     .setFormUrl("")
                                                                     .setDatabaseUrl(pdxDto.getSourceUrl())
                                                                     .setProviderName("")
                                                                     .setProviderAbbreviation("")
                                                                     .setProject("")));

        String modelMetaData = FileUtil.serializePojoToTsv(metadataSharingTsvs);
        String output = String.format("%s/metadata-sharing.tsv", outputDirectory);
        FileUtil.write(modelMetaData, output, false);
    }

}


