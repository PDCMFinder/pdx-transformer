package org.pdxfinder.util;

import org.pdxfinder.domain.*;
import org.pdxfinder.dto.PdxDto;
import org.pdxfinder.dto.ExtractDto;

public class SpecimenDataUtil {

    private SpecimenDataUtil(){
        // Never Called
    }

    public static PdxDto get(SpecimenSearch specimenSearch, ExtractDto extracted){
        return getBasicData(specimenSearch, extracted)
                .setHostStrainFull(getHostStrainFull(specimenSearch, extracted))
                .setTumorType(getTumorType(specimenSearch, extracted))
                .setEngraftmentSite(getEngraftmentSite(specimenSearch, extracted))
                .setEngraftmentType(getEngraftmentType(specimenSearch, extracted));
    }

    public static PdxDto getBasicData(SpecimenSearch specimenSearch, ExtractDto extracted){
        String age = "";
        String specimenSite = "";
        String dateAtCollection = "";
        String accessibility = "";

        String gender = specimenSearch.getGender().equals("M") ? "Male" : "Female";
        String race = specimenSearch.getRacedescription().equals("Not Provided") ? "Not Specified" : specimenSearch.getRacedescription();
        String ethnicity = specimenSearch.getEthnicitydescription().equals("Not Provided") ? "Not Specified" : specimenSearch.getEthnicitydescription();
        String sourceUrl = "https://pdmdb.cancer.gov/pls/apex/f?p=101:4:0::NO:4:P4_SPECIMENSEQNBR:" + specimenSearch.getSpecimenseqnbr();

        for (Specimen specimen : extracted.getSpecimenList()) {
            if (specimenSearch.getSpecimenid().equals(specimen.getSpecimenid())) {
                age = specimen.getAgeatsampling();
                specimenSite = specimen.getBiopsysite();
                dateAtCollection = specimen.getCollectiondate().toString().substring(0, 10);
                accessibility = specimen.getPublicaccessyn();
                if (accessibility.equals("Y")) {
                    accessibility = "Public";
                }
            }
        }
        return new PdxDto().setAge(age)
                .setSpecimenSite(specimenSite)
                .setDateAtCollection(dateAtCollection)
                .setAccessibility(accessibility)
                .setGender(gender)
                .setRace(race)
                .setEthnicity(ethnicity)
                .setSourceUrl(sourceUrl)
                .build();
    }

    public static String getHostStrainFull(SpecimenSearch specimenSearch, ExtractDto extracted){
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

    public static String getTumorType(SpecimenSearch specimenSearch, ExtractDto extracted){
        String tumorType = "";
        for (Specimen specimen : extracted.getSpecimenList()) {
            if (specimenSearch.getSpecimenid().equals(specimen.getSpecimenid())) {
                for (ProvidedTissueOrigins tissueOrigin : extracted.getTissueOrigins()) {
                    if (specimen.getProvidedtissueoriginseqnbr().equals(tissueOrigin.getProvidedtissueoriginseqnbr())) {
                        tumorType = tissueOrigin.getProvidedtissueorigindescript();
                        tumorType = tumorType.equals("Metastatic Site") ? "Metastatic" : tumorType;
                    }
                }
            }
        }
        return tumorType;
    }

    public static String getEngraftmentSite(SpecimenSearch specimenSearch, ExtractDto extracted){
        String engraftmentSite = "";
        for (Specimen specimen : extracted.getSpecimenList()) {
            if (specimenSearch.getSpecimenid().equals(specimen.getSpecimenid())) {
                for (ImplantationSites impantationSite : extracted.getImplantationSites()) {
                    if (specimen.getImplantationsiteseqnbr().equals(impantationSite.getImplantationsiteseqnbr())) {
                        engraftmentSite = impantationSite.getImplantationsitedescription();
                    }
                }

                if (specimen.getImplantationsiteseqnbr().equals("99")) {
                    engraftmentSite = "Not Specified";
                }
            }
        }
        return engraftmentSite;
    }

    public static String getEngraftmentType(SpecimenSearch specimenSearch, ExtractDto extracted){
        String engraftmentType = "";
        for (Specimen specimen : extracted.getSpecimenList()) {
            if (specimenSearch.getSpecimenid().equals(specimen.getSpecimenid())) {

                if (specimen.getImplantationsiteseqnbr().equals("0")) {
                    engraftmentType = "Heterotopic";
                } else if (specimen.getImplantationsiteseqnbr().equals("99")) {
                    engraftmentType = "Not Specified";
                } else {
                    engraftmentType = "Orthotopic";
                }
            }
        }
        return engraftmentType;
    }

}
