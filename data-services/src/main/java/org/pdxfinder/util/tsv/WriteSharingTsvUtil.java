package org.pdxfinder.util.tsv;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.pdxfinder.constant.DataConstants;
import org.pdxfinder.constant.OutputFileNames;
import org.pdxfinder.constant.TemplateLocations;
import org.pdxfinder.dto.PdxDto;
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

        InputStream contents = FileUtil.class.getResourceAsStream(TemplateLocations.META_DATA_SHARING);
        CsvSchema.Builder builder = CsvSchema.builder();
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = builder.build().withHeader().withColumnSeparator('\t');

        MappingIterator<MetadataSharingTsv> iterator =
                mapper.readerFor(MetadataSharingTsv.class).with(schema).readValues(contents);

        List<MetadataSharingTsv> metadataSharingTsvs = iterator.readAll();
        pdxDtoList.forEach(pdxDto -> metadataSharingTsvs.add(new MetadataSharingTsv()
                                                                     .setField(DataConstants.EMPTY)
                                                                     .setModelId(pdxDto.getModelID())
                                                                     .setProviderType(DataConstants.EMPTY)
                                                                     .setAccessibility(DataConstants.EMPTY)
                                                                     .setEuropdxAccessModality(DataConstants.EMPTY)
                                                                     .setEmail(DataConstants.EMPTY)
                                                                     .setFormUrl(DataConstants.PDMR_CONTACT_URL)
                                                                     .setDatabaseUrl(pdxDto.getSourceUrl())
                                                                     .setProviderName(DataConstants.PDMR_FULL_NAME)
                                                                     .setProviderAbbreviation(DataConstants.PDMR_ABBREV)
                                                                     .setProject(DataConstants.EMPTY)));

        String modelMetaData = FileUtil.serializePojoToTsv(metadataSharingTsvs);
        String output = String.format("%s%s", outputDirectory, OutputFileNames.METADATA_SHARING_TSV);
        FileUtil.write(modelMetaData, output, false);
    }

}


