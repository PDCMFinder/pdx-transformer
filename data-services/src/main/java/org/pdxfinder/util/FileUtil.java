package org.pdxfinder.util;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class FileUtil {

    private FileUtil() {
        // Never Called
    }

    public static void write(String data, String destination, Boolean shouldAppend) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(destination, shouldAppend))) {
            writer.append(data);
        }
    }

    public static String serializePojoToTsv(List<?> pojoList) throws IOException {
        CsvMapper csvMapper = new CsvMapper();
        List<Map<String, Object>> dataList = csvMapper.convertValue(pojoList, new TypeReference<List<Map<String, Object>>>() {
        });
        List<List<String>> csvData = new ArrayList<>();
        List<String> csvHead = new ArrayList<>();

        AtomicInteger counter = new AtomicInteger();
        dataList.forEach(row -> {
            List<String> rowData = new ArrayList<>();
            row.forEach((key, value) -> {
                rowData.add(String.valueOf(value));
                if (counter.get() == 0) {
                    csvHead.add(key);
                }
            });
            csvData.add(rowData);
            counter.getAndIncrement();
        });

        CsvSchema.Builder builder = CsvSchema.builder();
        csvHead.forEach(builder::addColumn);
        CsvSchema schema = builder.build().withHeader().withLineSeparator("\n").withColumnSeparator('\t');
        return csvMapper.writer(schema).writeValueAsString(csvData);
    }

    public static boolean isNumeric(String val) {
        boolean report = false;
        try {
            Double.parseDouble(val);
            report = true;
        } catch (Exception e) {
        }
        return report;
    }

}
