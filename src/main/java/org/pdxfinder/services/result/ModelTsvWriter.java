package org.pdxfinder.services.result;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.pdxfinder.constant.CancerModelTypes;
import org.pdxfinder.constant.FileNames;
import org.pdxfinder.constant.TemplateLocations;
import org.pdxfinder.services.common.dto.MetadataDto;
import org.pdxfinder.services.common.dto.SampleDto;
import org.pdxfinder.services.result.dto.MetadataCellModelTsv;
import org.pdxfinder.services.result.dto.MetadataModelTsv;
import org.pdxfinder.services.common.FileUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ModelTsvWriter {

    private ModelTsvWriter(){
        // Never Called
    }

    public static void write2FileSystem(List<MetadataDto> metadataDtoList, String outputDirectory) throws IOException {
        metadataDtoList = metadataDtoList.stream().filter(x -> (x.getModel_type().equals(CancerModelTypes.PDX_MODEL)|| x.getModel_type().equals(CancerModelTypes.PATIENT_SPECIMEN)))
                .collect(Collectors.toList());
        InputStream contents = FileUtil.class.getResourceAsStream(TemplateLocations.METADATA_MODEL_TEMPLATE);
        CsvSchema.Builder builder = CsvSchema.builder();
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = builder.build().withHeader().withColumnSeparator('\t');

        MappingIterator<MetadataModelTsv> iterator = mapper.readerFor(MetadataModelTsv.class).with(schema).readValues(contents);
        List<MetadataModelTsv> metadataModelTsvs = iterator.readAll();

        metadataDtoList.forEach(pdxDto -> {
            Set<String> passages = pdxDto.getSampleDtos().stream()
                    .filter(sampleDto -> !sampleDto.getPassage().isEmpty())
                    .map(SampleDto::getPassage)
                    .collect(Collectors.toSet());

            metadataModelTsvs.add(new MetadataModelTsv()
                    .setField("")
                    .setModelId(pdxDto.getModelID())
                    .setHostStrain(pdxDto.getHostStrain())
                    .setHostStrainFull(pdxDto.getHostStrainFull())
                    .setEngraftmentSite(pdxDto.getEngraftmentSite())
                    .setEngraftmentType(pdxDto.getEngraftmentType())
                    .setSampleType(pdxDto.getSampleType())
                    .setSampleState(pdxDto.getSampleState())
                    .setPublications(pdxDto.getPublications())
                    .setPassageNumber(String.join(",", passages))
                    .setParent_id("")
                    .setOrigin_patient_sample_id("")
                    .setSupplier(pdxDto.getSupplier())
                    .setSupplier_type("Academic")
                    .setCatalog_number(pdxDto.catalog_number())
                    .setVendor_link(pdxDto.vendor_link())
                    .setExternal_ids(pdxDto.getExternal_ids())
            );
        });

        String modelMetaData = FileUtil.serializePojoToTsv(metadataModelTsvs);
        String output = String.format("%s%s", outputDirectory, FileNames.METADATA_MODEL_TSV);
        FileUtil.write(modelMetaData, output);
    }
    public static void writecellmodel2FileSystem(List<MetadataDto> metadataDtoList, String outputDirectory) throws IOException {
        metadataDtoList = metadataDtoList.stream().filter(x -> (x.getModel_type().equals(CancerModelTypes.ORGANOID_MODEL)|| x.getModel_type().equals(CancerModelTypes.CELL_MODEL)))
                .collect(Collectors.toList());
        InputStream contents = FileUtil.class.getResourceAsStream(TemplateLocations.METADATA_CELL_MODEL_TEMPLATE);
        CsvSchema.Builder builder = CsvSchema.builder();
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = builder.build().withHeader().withColumnSeparator('\t');

        MappingIterator<MetadataCellModelTsv> iterator = mapper.readerFor(MetadataCellModelTsv.class).with(schema).readValues(contents);
        List<MetadataCellModelTsv> metadataCellModelTsvs = iterator.readAll();



        metadataDtoList.forEach(pdxDto -> {
            Set<String> passages = pdxDto.getSampleDtos().stream()
                    .filter(sampleDto -> !sampleDto.getPassage().isEmpty())
                    .map(SampleDto::getPassage)
                    .collect(Collectors.toSet());

            metadataCellModelTsvs.add(new MetadataCellModelTsv()
                .setField("")
                .setModelId(pdxDto.getModelID())
                .setModel_name(pdxDto.getModel_name())
                .setModel_name_aliases(pdxDto.model_name_aliases())
                .setType(pdxDto.getModel_type())
                .setParent_id(pdxDto.getParent_id())
                .setOrigin_patient_sample_id(pdxDto.getOrigin_patient_sample_id())
                .setGrowth_properties(pdxDto.getGrowth_properties())
                .setMedia_id(pdxDto.media_id())
                .setGrowth_media(pdxDto.growth_media())
                .setPlate_coating(pdxDto.plate_coating())
                .setOther_plate_coating(pdxDto.other_plate_coating())
                .setPassage_number("")
                .setContaminated(pdxDto.contaminated())
                .setContamination_details(pdxDto.contamination_details())
                .setSupplements(pdxDto.supplements())
                .setDrug(pdxDto.drug())
                .setDrug_concentration(pdxDto.drug_concentration())
                .setPublications(pdxDto.getPublications())
                .setSupplier(pdxDto.getSupplier())
                .setSupplier_type(pdxDto.supplier_type())
                .setCatalog_number(pdxDto.catalog_number())
                .setVendor_link(pdxDto.vendor_link())
                .setRrid(pdxDto.rrid())
                .setExternal_ids(pdxDto.getExternal_ids())
                .setComments(pdxDto.getComments())
                );
        });

        String modelMetaData = FileUtil.serializePojoToTsv(metadataCellModelTsvs);
        String output = String.format("%s%s", outputDirectory, FileNames.METADATA_CELL_MODEL_TSV);
        FileUtil.write(modelMetaData, output);
    }
}
