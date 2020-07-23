package org.pdxfinder.result;

import org.pdxfinder.FileUtil;

import java.io.IOException;
import java.util.List;

public class GenomicTsvWriter {


    private GenomicTsvWriter(){
        // Never Called
    }

    public static void writeTsv(List<?> mutationTsvs, String outputDirectory) throws IOException {

        String data = FileUtil.serializePojoToTsv(mutationTsvs);
        FileUtil.write(data, outputDirectory);
    }
}
