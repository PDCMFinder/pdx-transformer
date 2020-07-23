package org.pdxfinder.util.template;

import org.pdxfinder.constant.OutputFileNames;
import org.pdxfinder.dto.template.MutationTsv;
import org.pdxfinder.util.FileUtil;

import java.io.IOException;
import java.util.List;

public class WriteOmicTsv {


    private WriteOmicTsv(){
        // Never Called
    }

    public static void writeTsv(List<MutationTsv> mutationTsvs, String outputDirectory) throws IOException {

        String patientMetaData = FileUtil.serializePojoToTsv(mutationTsvs);
        String output = String.format("%s%s", outputDirectory, OutputFileNames.MUTATION_DATA_TSV);
        FileUtil.write(patientMetaData, output);
    }
}
