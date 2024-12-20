package org.pdxfinder.services.pdmr.extractor;

import org.pdxfinder.constant.DataConstants;
import org.pdxfinder.constant.EngraftmentTypeConstants;
import org.pdxfinder.constant.UrlConstants;
import org.pdxfinder.data.model.*;
import org.pdxfinder.services.common.dto.MetadataDto;
import org.pdxfinder.services.pdmr.dto.OracleDataDto;

public class ExtractSpecimenData {

    private ExtractSpecimenData(){
        // Never Called
    }

    public static MetadataDto get(SpecimenSearch specimenSearch, OracleDataDto extracted){
        return getBasicData(specimenSearch, extracted)
                .setHostStrainFull(getHostStrainFull(specimenSearch, extracted))
                .setTumorType(getTumorType(specimenSearch, extracted))
                .setEngraftmentSite(getEngraftmentSite(specimenSearch, extracted))
                .setEngraftmentType(getEngraftmentType(specimenSearch, extracted));

    }

    public static MetadataDto getBasicData(SpecimenSearch specimenSearch, OracleDataDto extracted){
        String age = "";
        String specimenSite = "";
        String dateAtCollection = "";
        String accessibility = "";

        String gender = specimenSearch.getGender().equals("M") ? DataConstants.GENDER_MALE : DataConstants.GENDER_FEMALE;
        String race = specimenSearch.getRacedescription().equals(DataConstants.NOT_PROVIDED) ? DataConstants.NOT_SPECIFIED : specimenSearch.getRacedescription();
        String ethnicity = specimenSearch.getEthnicitydescription().equals(DataConstants.NOT_PROVIDED) ? DataConstants.NOT_SPECIFIED : specimenSearch.getEthnicitydescription();
        String sourceUrl = UrlConstants.PDMR_SOURCE_URL_PREFIX + specimenSearch.getSpecimenseqnbr();

        for (Specimen specimen : extracted.getSpecimenList()) {
            if (specimenSearch.getSpecimenid().equals(specimen.getSpecimenid())) {
                age = specimen.getAgeatsampling();
                specimenSite = specimen.getBiopsysite();
                dateAtCollection = specimen.getCollectiondate().toString().substring(0, 10);
                accessibility = specimen.getPublicaccessyn();
                if (accessibility.equals("Y")) {
                    accessibility = DataConstants.ACCESSIBILITY_PUBLIC;
                }
            }
        }
        return new MetadataDto().setAge(age)
                .setSpecimenSite(specimenSite)
                .setDateAtCollection(dateAtCollection)
                .setAccessibility(accessibility)
                .setGender(gender)
                .setRace(race)
                .setEthnicity(ethnicity)
                .setSourceUrl(sourceUrl)
                .build();
    }

    public static String getHostStrainFull(SpecimenSearch specimenSearch, OracleDataDto extracted){
        String hostStrainFull = "";
        for (Specimen specimen : extracted.getSpecimenList()) {
            if (specimenSearch.getSpecimenid().equals(specimen.getSpecimenid())) {
                for (MouseStrains mouseStrain : extracted.getMouseStrains()) {
                    if (specimen.getMousestrainseqnbr().equals(mouseStrain.getMousestrainseqnbr())) {
                        hostStrainFull = mouseStrain.getMousestraindescript();
                    }
                }
            }
        }
        return hostStrainFull;
    }

    public static String getTumorType(SpecimenSearch specimenSearch, OracleDataDto extracted){
        String tumorType = "";
        for (Specimen specimen : extracted.getSpecimenList()) {
            if (specimenSearch.getSpecimenid().equals(specimen.getSpecimenid())) {
                for (ProvidedTissueOrigins tissueOrigin : extracted.getTissueOrigins()) {
                    if (specimen.getProvidedtissueoriginseqnbr().equals(tissueOrigin.getProvidedtissueoriginseqnbr())) {
                        tumorType = tissueOrigin.getProvidedtissueorigindescript();
                        tumorType = tumorType.equals(DataConstants.TUMORTYPE_METASTATIC_SITE) ? DataConstants.TUMORTYPE_METASTATIC : tumorType;
                    }
                }
            }
        }
        return tumorType;
    }

    public static String getEngraftmentSite(SpecimenSearch specimenSearch, OracleDataDto extracted){
        String engraftmentSite = "";
        for (Specimen specimen : extracted.getSpecimenList()) {
            if (specimenSearch.getSpecimenid().equals(specimen.getSpecimenid())) {
                if (specimen.getViablepassageimpsiteseqnbr().equals("0")) {
                    engraftmentSite = "Subcutaneous (flank)";
                } else if (specimen.getViablepassageimpsiteseqnbr().equals("99")) {
                    engraftmentSite = DataConstants.NOT_PROVIDED;
                } else {
                    engraftmentSite = "Mammary Fat Pad";
                }
            }
        }
        return engraftmentSite;
    }

    public static String getEngraftmentType(SpecimenSearch specimenSearch, OracleDataDto extracted){
        String engraftmentType = "";
        for (Specimen specimen : extracted.getSpecimenList()) {
            if (specimenSearch.getSpecimenid().equals(specimen.getSpecimenid())) {

                if (specimen.getViablepassageimpsiteseqnbr().equals("0")) {
                    engraftmentType = EngraftmentTypeConstants.HETEROTROPIC;
                } else if (specimen.getViablepassageimpsiteseqnbr().equals("99")) {
                    engraftmentType = DataConstants.NOT_PROVIDED;
                } else {
                    engraftmentType = EngraftmentTypeConstants.ORTHOTOPIC;
                }
            }
        }
        return engraftmentType;
    }

}
