package org.pdxfinder.util;

import org.pdxfinder.dto.TransformPdx;
import org.pdxfinder.dto.TransformSample;
import org.pdxfinder.dto.WriteModelDto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WriteModelTsvUtil {

    private WriteModelTsvUtil(){
        // Never Called
    }

    public static void writeTsv(List<TransformPdx> pdxList, String outputDirectory) throws IOException {
        List<WriteModelDto> models = new ArrayList<>();
        pdxList.forEach(pdx -> {
            Set<String> passages = pdx.getSamples().stream()
                    .filter(sample -> sample.getPassage() != null)
                    .map(TransformSample::getPassage)
                    .collect(Collectors.toSet());
            models.add(new WriteModelDto()
                               .setField("")
                               .setModelId(pdx.getModelID())
                               .setHostStrain("NOD scid gamma")
                               .setHostStrainFull(pdx.getStrain())
                               .setEngraftmentSite(pdx.getEngraftmentSite())
                               .setEngraftmentType(pdx.getEngraftmentType())
                               .setSampleType(pdx.getSampleType())
                               .setSampleState("Not Specified")
                               .setPublications("")
                               .setPassageNumber(String.join(",", passages)));
        });

        String modelMetaData = FileUtil.serializePojoToTsv(models);
        String output = String.format("%s/metadata-model.tsv", outputDirectory);
        FileUtil.write(modelMetaData, output, false);
    }
}
