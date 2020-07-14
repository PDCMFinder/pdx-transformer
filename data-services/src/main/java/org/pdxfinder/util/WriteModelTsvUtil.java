package org.pdxfinder.util;

import org.pdxfinder.dto.PdxDto;
import org.pdxfinder.dto.SampleDto;
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

    public static void writeTsv(List<PdxDto> pdxDtoList, String outputDirectory) throws IOException {
        List<WriteModelDto> models = new ArrayList<>();
        pdxDtoList.forEach(pdxDto -> {
            Set<String> passages = pdxDto.getSampleDtos().stream()
                    .filter(sampleDto -> sampleDto.getPassage() != null)
                    .map(SampleDto::getPassage)
                    .collect(Collectors.toSet());
            models.add(new WriteModelDto()
                               .setField("")
                               .setModelId(pdxDto.getModelID())
                               .setHostStrain("NOD scid gamma")
                               .setHostStrainFull(pdxDto.getStrain())
                               .setEngraftmentSite(pdxDto.getEngraftmentSite())
                               .setEngraftmentType(pdxDto.getEngraftmentType())
                               .setSampleType(pdxDto.getSampleType())
                               .setSampleState("Not Specified")
                               .setPublications("")
                               .setPassageNumber(String.join(",", passages)));
        });

        String modelMetaData = FileUtil.serializePojoToTsv(models);
        String output = String.format("%s/metadata-model.tsv", outputDirectory);
        FileUtil.write(modelMetaData, output, false);
    }
}
