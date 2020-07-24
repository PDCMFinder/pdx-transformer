package org.pdxfinder.data.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Specimen {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "specimen_Sequence")
    @SequenceGenerator(name = "specimen_Sequence", sequenceName = "SPECIMEN_SEQ")
    private String specimenseqnbr;

    private String patientseqnbr;
    private String specimenid;
    private String tissuetypeshortname;
    private Date collectiondate;
    private String dayofyear;
    private String reasonforcollection;
    private String notes;
    private String archiveyn;
    private String ctcphenotypingresults;
    private String ageatsampling;
    private String biopsysite;
    private String publicaccessyn;
    private String consensuswes1Ftpyn;
    private String consensuswes2Ftpyn;
    private String consensuswes1Ftpversion;
    private String consensuswes2Ftpversion;
    private String providedtissueoriginseqnbr;
    private String mousestrainseqnbr;
    private String implantationsiteseqnbr;
    private String passageintoathymicnudemicesn;
    private String viablepassageimpsiteseqnbr;
    private String msistatusseqnbr;
    private String metastaticinnsgyn;
    private String obsmetastaseslocation;
    private String obsmetastasistimingseqnbr;
    private String penetrance;
    private String tciaimagingdataavailableyn;
    private String linktotcia;


    public String getSpecimenseqnbr() {
        return specimenseqnbr;
    }

    public void setSpecimenseqnbr(String specimenseqnbr) {
        this.specimenseqnbr = specimenseqnbr;
    }


    public String getPatientseqnbr() {
        return patientseqnbr;
    }

    public void setPatientseqnbr(String patientseqnbr) {
        this.patientseqnbr = patientseqnbr;
    }

    public String getSpecimenid() {
        return specimenid;
    }

    public void setSpecimenid(String specimenid) {
        this.specimenid = specimenid;
    }


    public String getTissuetypeshortname() {
        return tissuetypeshortname;
    }

    public void setTissuetypeshortname(String tissuetypeshortname) {
        this.tissuetypeshortname = tissuetypeshortname;
    }


    public Date getCollectiondate() {
        return collectiondate;
    }

    public void setCollectiondate(Date collectiondate) {
        this.collectiondate = collectiondate;
    }


    public String getDayofyear() {
        return dayofyear;
    }

    public void setDayofyear(String dayofyear) {
        this.dayofyear = dayofyear;
    }


    public String getReasonforcollection() {
        return reasonforcollection;
    }

    public void setReasonforcollection(String reasonforcollection) {
        this.reasonforcollection = reasonforcollection;
    }


    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }


    public String getArchiveyn() {
        return archiveyn;
    }

    public void setArchiveyn(String archiveyn) {
        this.archiveyn = archiveyn;
    }


    public String getCtcphenotypingresults() {
        return ctcphenotypingresults;
    }

    public void setCtcphenotypingresults(String ctcphenotypingresults) {
        this.ctcphenotypingresults = ctcphenotypingresults;
    }


    public String getAgeatsampling() {
        return ageatsampling;
    }

    public void setAgeatsampling(String ageatsampling) {
        this.ageatsampling = ageatsampling;
    }


    public String getBiopsysite() {
        return biopsysite;
    }

    public void setBiopsysite(String biopsysite) {
        this.biopsysite = biopsysite;
    }


    public String getPublicaccessyn() {
        return publicaccessyn;
    }

    public void setPublicaccessyn(String publicaccessyn) {
        this.publicaccessyn = publicaccessyn;
    }


    public String getConsensuswes1Ftpyn() {
        return consensuswes1Ftpyn;
    }

    public void setConsensuswes1Ftpyn(String consensuswes1Ftpyn) {
        this.consensuswes1Ftpyn = consensuswes1Ftpyn;
    }


    public String getConsensuswes2Ftpyn() {
        return consensuswes2Ftpyn;
    }

    public void setConsensuswes2Ftpyn(String consensuswes2Ftpyn) {
        this.consensuswes2Ftpyn = consensuswes2Ftpyn;
    }


    public String getConsensuswes1Ftpversion() {
        return consensuswes1Ftpversion;
    }

    public void setConsensuswes1Ftpversion(String consensuswes1Ftpversion) {
        this.consensuswes1Ftpversion = consensuswes1Ftpversion;
    }


    public String getConsensuswes2Ftpversion() {
        return consensuswes2Ftpversion;
    }

    public void setConsensuswes2Ftpversion(String consensuswes2Ftpversion) {
        this.consensuswes2Ftpversion = consensuswes2Ftpversion;
    }


    public String getProvidedtissueoriginseqnbr() {
        return providedtissueoriginseqnbr;
    }

    public void setProvidedtissueoriginseqnbr(String providedtissueoriginseqnbr) {
        this.providedtissueoriginseqnbr = providedtissueoriginseqnbr;
    }


    public String getMousestrainseqnbr() {
        return mousestrainseqnbr;
    }

    public void setMousestrainseqnbr(String mousestrainseqnbr) {
        this.mousestrainseqnbr = mousestrainseqnbr;
    }


    public String getImplantationsiteseqnbr() {
        return implantationsiteseqnbr;
    }

    public void setImplantationsiteseqnbr(String implantationsiteseqnbr) {
        this.implantationsiteseqnbr = implantationsiteseqnbr;
    }


    public String getPassageintoathymicnudemicesn() {
        return passageintoathymicnudemicesn;
    }

    public void setPassageintoathymicnudemicesn(String passageintoathymicnudemicesn) {
        this.passageintoathymicnudemicesn = passageintoathymicnudemicesn;
    }


    public String getViablepassageimpsiteseqnbr() {
        return viablepassageimpsiteseqnbr;
    }

    public void setViablepassageimpsiteseqnbr(String viablepassageimpsiteseqnbr) {
        this.viablepassageimpsiteseqnbr = viablepassageimpsiteseqnbr;
    }


    public String getMsistatusseqnbr() {
        return msistatusseqnbr;
    }

    public void setMsistatusseqnbr(String msistatusseqnbr) {
        this.msistatusseqnbr = msistatusseqnbr;
    }


    public String getMetastaticinnsgyn() {
        return metastaticinnsgyn;
    }

    public void setMetastaticinnsgyn(String metastaticinnsgyn) {
        this.metastaticinnsgyn = metastaticinnsgyn;
    }


    public String getObsmetastaseslocation() {
        return obsmetastaseslocation;
    }

    public void setObsmetastaseslocation(String obsmetastaseslocation) {
        this.obsmetastaseslocation = obsmetastaseslocation;
    }


    public String getObsmetastasistimingseqnbr() {
        return obsmetastasistimingseqnbr;
    }

    public void setObsmetastasistimingseqnbr(String obsmetastasistimingseqnbr) {
        this.obsmetastasistimingseqnbr = obsmetastasistimingseqnbr;
    }


    public String getPenetrance() {
        return penetrance;
    }

    public void setPenetrance(String penetrance) {
        this.penetrance = penetrance;
    }


    public String getTciaimagingdataavailableyn() {
        return tciaimagingdataavailableyn;
    }

    public void setTciaimagingdataavailableyn(String tciaimagingdataavailableyn) {
        this.tciaimagingdataavailableyn = tciaimagingdataavailableyn;
    }


    public String getLinktotcia() {
        return linktotcia;
    }

    public void setLinktotcia(String linktotcia) {
        this.linktotcia = linktotcia;
    }

}
