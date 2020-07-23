package org.pdxfinder.util.template;

import org.pdxfinder.util.FileUtil;

import java.io.IOException;
import java.util.List;

public class WriteOmicTsv {


    private WriteOmicTsv(){
        // Never Called
    }

    public static void writeTsv(List<?> mutationTsvs, String outputDirectory) throws IOException {

        String data = FileUtil.serializePojoToTsv(mutationTsvs);
        FileUtil.write(data, outputDirectory);
    }
}
