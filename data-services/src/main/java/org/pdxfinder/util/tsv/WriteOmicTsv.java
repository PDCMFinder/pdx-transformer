package org.pdxfinder.util.tsv;

import org.pdxfinder.dto.tsv.OmicTsv;
import org.pdxfinder.util.FileUtil;

import java.io.IOException;
import java.util.List;

public class WriteOmicTsv {


    private WriteOmicTsv(){
        // Never Called
    }

    public static void writeTsv(List<OmicTsv> omicTsvs, String outputDirectory) throws IOException {

        String patientMetaData = FileUtil.serializePojoToTsv(omicTsvs);
        String output = String.format("%s/mut.tsv", outputDirectory);
        FileUtil.write(patientMetaData, output, false);
    }
}
