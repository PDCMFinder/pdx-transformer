package org.pdxfinder.services.pdmr.services;

import org.pdxfinder.constant.DataConstants;
import org.pdxfinder.data.model.SpecimenSearch;
import org.pdxfinder.services.common.dto.MetadataDto;
import org.pdxfinder.services.common.dto.TreatmentDto;
import org.pdxfinder.services.pdmr.dto.AccessionsDTO;
import org.pdxfinder.services.pdmr.dto.OracleDataDto;
import org.pdxfinder.services.pdmr.extractor.Extract;
import org.pdxfinder.services.pdmr.extractor.ExtractSpecimenData;
import org.pdxfinder.services.pdmr.extractor.ExtractTreatment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransformMetaDataService {

    private final Logger log = LoggerFactory.getLogger(TransformMetaDataService.class);

    public List<MetadataDto> fromOracleDataDto2Metadata(OracleDataDto dataDto, AccessionsDTO accessions) {

        log.info("Start Transforming metadata data-sets");
        List<String> modelIds = new ArrayList<>();
        List<MetadataDto> metadataDtos = new ArrayList<>();

        for (SpecimenSearch specimenSearch : dataDto.getSpecimenSearchList()) {

            Extract extract = new Extract(specimenSearch, dataDto, accessions);

            String modelId = extract.getModelId();
            if (modelId.isEmpty() || modelIds.contains(modelId) || modelId.equals("")) {
                continue;
            }
            modelIds.add(modelId);
            List<TreatmentDto> treatmentDtos = new ArrayList<>();
            try {
                treatmentDtos = ExtractTreatment.getCurrentTherapies(specimenSearch, dataDto);
            }catch (Exception e){
                continue;
            }


            MetadataDto metadataDto = ExtractSpecimenData.get(specimenSearch, dataDto);
            metadataDto.setModelID(modelId)
                    .setPatientID(specimenSearch.getPatientid())
                    .setPrimarySite(specimenSearch.getDiseaselocationdescription())
                    .setSampleType(specimenSearch.getTissuetypedescription())
                    .setInitialDiagnosis("")
                    .setClinicalDiagnosis(extract.getClinicalDiagnosis())
                    .setClinicalDiagnosisnotes(extract.getClinicalDiagnosisNotes())
                    .setStageClassification(extract.getStageClassification())
                    .setGradeClassification(extract.getGradeClassification())
                    .setGradeValue(extract.getGradeValue())
                    .setExtractionMethod(extract.getExtractionMethod()) //collection method
                    .setValidationDtos(extract.getValidations())
                    .setSampleDtos(extract.getSamples(modelId))
                    .setStageValue(extract.getNotes())
                    .setDateAtCollection(extract.getCollectionDate())
                    .setAge_in_years_at_collection(extract.getAgeInYearsAtCollection())
                    .setHostStrain(metadataDto.getHostStrainFull().isEmpty() ? DataConstants.EMPTY : DataConstants.NSG_HOST_STRAIN)
                    .setMouseSex(DataConstants.EMPTY)
                    .setTreatmentNaive(DataConstants.EMPTY)
                    .setTreatmentDtos(treatmentDtos)
                    .setSampleState("Fresh")
                    .setPublications(DataConstants.EMPTY)
                    .setHistory(extract.gethistory())
                    .setsmokingStatus(extract.getSmokingHistory())
                    .setEthnicityAssessmentMethod(DataConstants.EMPTY)
                    .setAgeAtInitialDiagnosis(extract.getAgeAtDiagnosis())
                    .setModel_name(DataConstants.EMPTY)
                    .setModel_name_aliases(DataConstants.EMPTY)
                    .setModel_type(specimenSearch.getPdmtypedescription())
                    .setParent_id(extract.getParentID())
                    .setOrigin_patient_sample_id(extract.getParentID())
                    .setGrowth_properties(extract.getGrowth_properties())
                    .setMedia_id("Invitrogen, Cat#: 12634-010")
                    .setGrowth_media("DMEM/F12 + 10% FBS")
                    .setPlate_coating(DataConstants.EMPTY)
                    .setOther_plate_coating(DataConstants.EMPTY)
                    .setContaminated("No")
                    .setContamination_details("None")
                    .setSupplements(extract.getSupplements())
                    .setDrug(DataConstants.NOT_PROVIDED)
                    .setDrug_concentration(DataConstants.NOT_PROVIDED)
                    .setSupplier(extract.getSupplier())
                    .setSupplier_type("Academic")
                    .setCatalog_number(modelId)
                    .setVendor_link(DataConstants.NOT_PROVIDED)
                    .setRrid(DataConstants.NOT_PROVIDED)
                    .setExternal_ids(extract.getexternalID())
                    .setComments(extract.getcomments())
                    .setgeneMutationStatus(extract.getgeneMutationStatus())
                    .setresponseToTreatment(extract.getresponseToTreatment())
                    .setcollectionMethod(extract.getExtractionMethod())
                    .setcollectionSite(extract.getcollectionSite())
                    .setAccessibility(extract.getAvailability(modelId))
                    .setMetadataSampleTsv(extract.sampleTsv(metadataDto))
                    .setMetadataSharingTsv(extract.sharingTsv(metadataDto))
                    .build();

            metadataDtos.add(metadataDto);
        }
        log.info("Finished Transforming metadata data-sets");

        return metadataDtos;
    }
}
