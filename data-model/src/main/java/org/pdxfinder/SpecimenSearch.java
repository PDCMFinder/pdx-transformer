package org.pdxfinder;


import javax.persistence.*;

@Entity
@Table(name = "Specimensearch")
public class SpecimenSearch {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_Sequence")
  @SequenceGenerator(name = "patient_Sequence", sequenceName = "PATIENT_SEQ")
  private String patientseqnbr;

  private String patientid;
  private String gender;
  private String diagnosisshortname;
  private String diagnosisdescription;
  private String meddracode;
  private String meddradescription;
  private String diseaselocationseqnbr;
  private String diseaselocationdescription;
  private String delinkedyn;
  private String hasmetastaticdiseaseseqnbr;
  private String hasmetastaticdiseasedesc;
  private String germlinewesftpyn;
  private String currentregimen;
  private String currentstandardizedregimensn;
  private String currentstandardizedregimen;
  private String currentbestresponseseqnbr;
  private String currentbestresponse;
  private String priorregimen;
  private String priorstandardizedregimenseqnbr;
  private String priorstandardizedregimen;
  private String priorbestresponseseqnbr;
  private String priorbestresponse;
  private String standardizedregimensn;
  private String standardizedregimen;
  private String specimenseqnbr;
  private String specimenid;
  private String tissuetypeshortname;
  private String tissuetypedescription;
  private String archiveyn;
  private String msistatusseqnbr;
  private String metastaticinnsgyn;
  private String pdmtypeseqnbr;
  private String pdmtypedescription;
  private String wholeexomesequenceftpyn;
  private String rnasequenceftpyn;
  private String affymetrixftpyn;
  private String sampleimagesavailyn;
  private String mpactdataavailableyn;
  private String geneseqnbr;
  private String gene;
  private String mpacttrialamoiyn;
  private String genefunctionaleffect;
  private String growthcurveavailableyn;
  private String smoked100Seqnbr;
  private String smoked100Description;
  private String ethnicityseqnbr;
  private String ethnicitydescription;
  private String raceseqnbr;
  private String racedescription;
  private String multiracialyn;
  private String tumorgradestageseqnbr;
  private String tumorgradestagedescription;
  private String hugogenesymbolseqnbr;
  private String oncokbgenepanelavailyn;


  public String getPatientseqnbr() {
    return patientseqnbr;
  }

  public void setPatientseqnbr(String patientseqnbr) {
    this.patientseqnbr = patientseqnbr;
  }


  public String getPatientid() {
    return patientid;
  }

  public void setPatientid(String patientid) {
    this.patientid = patientid;
  }


  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }


  public String getDiagnosisshortname() {
    return diagnosisshortname;
  }

  public void setDiagnosisshortname(String diagnosisshortname) {
    this.diagnosisshortname = diagnosisshortname;
  }


  public String getDiagnosisdescription() {
    return diagnosisdescription;
  }

  public void setDiagnosisdescription(String diagnosisdescription) {
    this.diagnosisdescription = diagnosisdescription;
  }


  public String getMeddracode() {
    return meddracode;
  }

  public void setMeddracode(String meddracode) {
    this.meddracode = meddracode;
  }


  public String getMeddradescription() {
    return meddradescription;
  }

  public void setMeddradescription(String meddradescription) {
    this.meddradescription = meddradescription;
  }


  public String getDiseaselocationseqnbr() {
    return diseaselocationseqnbr;
  }

  public void setDiseaselocationseqnbr(String diseaselocationseqnbr) {
    this.diseaselocationseqnbr = diseaselocationseqnbr;
  }


  public String getDiseaselocationdescription() {
    return diseaselocationdescription;
  }

  public void setDiseaselocationdescription(String diseaselocationdescription) {
    this.diseaselocationdescription = diseaselocationdescription;
  }


  public String getDelinkedyn() {
    return delinkedyn;
  }

  public void setDelinkedyn(String delinkedyn) {
    this.delinkedyn = delinkedyn;
  }


  public String getHasmetastaticdiseaseseqnbr() {
    return hasmetastaticdiseaseseqnbr;
  }

  public void setHasmetastaticdiseaseseqnbr(String hasmetastaticdiseaseseqnbr) {
    this.hasmetastaticdiseaseseqnbr = hasmetastaticdiseaseseqnbr;
  }


  public String getHasmetastaticdiseasedesc() {
    return hasmetastaticdiseasedesc;
  }

  public void setHasmetastaticdiseasedesc(String hasmetastaticdiseasedesc) {
    this.hasmetastaticdiseasedesc = hasmetastaticdiseasedesc;
  }


  public String getGermlinewesftpyn() {
    return germlinewesftpyn;
  }

  public void setGermlinewesftpyn(String germlinewesftpyn) {
    this.germlinewesftpyn = germlinewesftpyn;
  }


  public String getCurrentregimen() {
    return currentregimen;
  }

  public void setCurrentregimen(String currentregimen) {
    this.currentregimen = currentregimen;
  }


  public String getCurrentstandardizedregimensn() {
    return currentstandardizedregimensn;
  }

  public void setCurrentstandardizedregimensn(String currentstandardizedregimensn) {
    this.currentstandardizedregimensn = currentstandardizedregimensn;
  }


  public String getCurrentstandardizedregimen() {
    return currentstandardizedregimen;
  }

  public void setCurrentstandardizedregimen(String currentstandardizedregimen) {
    this.currentstandardizedregimen = currentstandardizedregimen;
  }


  public String getCurrentbestresponseseqnbr() {
    return currentbestresponseseqnbr;
  }

  public void setCurrentbestresponseseqnbr(String currentbestresponseseqnbr) {
    this.currentbestresponseseqnbr = currentbestresponseseqnbr;
  }


  public String getCurrentbestresponse() {
    return currentbestresponse;
  }

  public void setCurrentbestresponse(String currentbestresponse) {
    this.currentbestresponse = currentbestresponse;
  }


  public String getPriorregimen() {
    return priorregimen;
  }

  public void setPriorregimen(String priorregimen) {
    this.priorregimen = priorregimen;
  }


  public String getPriorstandardizedregimenseqnbr() {
    return priorstandardizedregimenseqnbr;
  }

  public void setPriorstandardizedregimenseqnbr(String priorstandardizedregimenseqnbr) {
    this.priorstandardizedregimenseqnbr = priorstandardizedregimenseqnbr;
  }


  public String getPriorstandardizedregimen() {
    return priorstandardizedregimen;
  }

  public void setPriorstandardizedregimen(String priorstandardizedregimen) {
    this.priorstandardizedregimen = priorstandardizedregimen;
  }


  public String getPriorbestresponseseqnbr() {
    return priorbestresponseseqnbr;
  }

  public void setPriorbestresponseseqnbr(String priorbestresponseseqnbr) {
    this.priorbestresponseseqnbr = priorbestresponseseqnbr;
  }


  public String getPriorbestresponse() {
    return priorbestresponse;
  }

  public void setPriorbestresponse(String priorbestresponse) {
    this.priorbestresponse = priorbestresponse;
  }


  public String getStandardizedregimensn() {
    return standardizedregimensn;
  }

  public void setStandardizedregimensn(String standardizedregimensn) {
    this.standardizedregimensn = standardizedregimensn;
  }


  public String getStandardizedregimen() {
    return standardizedregimen;
  }

  public void setStandardizedregimen(String standardizedregimen) {
    this.standardizedregimen = standardizedregimen;
  }


  public String getSpecimenseqnbr() {
    return specimenseqnbr;
  }

  public void setSpecimenseqnbr(String specimenseqnbr) {
    this.specimenseqnbr = specimenseqnbr;
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


  public String getTissuetypedescription() {
    return tissuetypedescription;
  }

  public void setTissuetypedescription(String tissuetypedescription) {
    this.tissuetypedescription = tissuetypedescription;
  }


  public String getArchiveyn() {
    return archiveyn;
  }

  public void setArchiveyn(String archiveyn) {
    this.archiveyn = archiveyn;
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


  public String getPdmtypeseqnbr() {
    return pdmtypeseqnbr;
  }

  public void setPdmtypeseqnbr(String pdmtypeseqnbr) {
    this.pdmtypeseqnbr = pdmtypeseqnbr;
  }


  public String getPdmtypedescription() {
    return pdmtypedescription;
  }

  public void setPdmtypedescription(String pdmtypedescription) {
    this.pdmtypedescription = pdmtypedescription;
  }


  public String getWholeexomesequenceftpyn() {
    return wholeexomesequenceftpyn;
  }

  public void setWholeexomesequenceftpyn(String wholeexomesequenceftpyn) {
    this.wholeexomesequenceftpyn = wholeexomesequenceftpyn;
  }


  public String getRnasequenceftpyn() {
    return rnasequenceftpyn;
  }

  public void setRnasequenceftpyn(String rnasequenceftpyn) {
    this.rnasequenceftpyn = rnasequenceftpyn;
  }


  public String getAffymetrixftpyn() {
    return affymetrixftpyn;
  }

  public void setAffymetrixftpyn(String affymetrixftpyn) {
    this.affymetrixftpyn = affymetrixftpyn;
  }


  public String getSampleimagesavailyn() {
    return sampleimagesavailyn;
  }

  public void setSampleimagesavailyn(String sampleimagesavailyn) {
    this.sampleimagesavailyn = sampleimagesavailyn;
  }


  public String getMpactdataavailableyn() {
    return mpactdataavailableyn;
  }

  public void setMpactdataavailableyn(String mpactdataavailableyn) {
    this.mpactdataavailableyn = mpactdataavailableyn;
  }


  public String getGeneseqnbr() {
    return geneseqnbr;
  }

  public void setGeneseqnbr(String geneseqnbr) {
    this.geneseqnbr = geneseqnbr;
  }


  public String getGene() {
    return gene;
  }

  public void setGene(String gene) {
    this.gene = gene;
  }


  public String getMpacttrialamoiyn() {
    return mpacttrialamoiyn;
  }

  public void setMpacttrialamoiyn(String mpacttrialamoiyn) {
    this.mpacttrialamoiyn = mpacttrialamoiyn;
  }


  public String getGenefunctionaleffect() {
    return genefunctionaleffect;
  }

  public void setGenefunctionaleffect(String genefunctionaleffect) {
    this.genefunctionaleffect = genefunctionaleffect;
  }


  public String getGrowthcurveavailableyn() {
    return growthcurveavailableyn;
  }

  public void setGrowthcurveavailableyn(String growthcurveavailableyn) {
    this.growthcurveavailableyn = growthcurveavailableyn;
  }


  public String getSmoked100Seqnbr() {
    return smoked100Seqnbr;
  }

  public void setSmoked100Seqnbr(String smoked100Seqnbr) {
    this.smoked100Seqnbr = smoked100Seqnbr;
  }


  public String getSmoked100Description() {
    return smoked100Description;
  }

  public void setSmoked100Description(String smoked100Description) {
    this.smoked100Description = smoked100Description;
  }


  public String getEthnicityseqnbr() {
    return ethnicityseqnbr;
  }

  public void setEthnicityseqnbr(String ethnicityseqnbr) {
    this.ethnicityseqnbr = ethnicityseqnbr;
  }


  public String getEthnicitydescription() {
    return ethnicitydescription;
  }

  public void setEthnicitydescription(String ethnicitydescription) {
    this.ethnicitydescription = ethnicitydescription;
  }


  public String getRaceseqnbr() {
    return raceseqnbr;
  }

  public void setRaceseqnbr(String raceseqnbr) {
    this.raceseqnbr = raceseqnbr;
  }


  public String getRacedescription() {
    return racedescription;
  }

  public void setRacedescription(String racedescription) {
    this.racedescription = racedescription;
  }


  public String getMultiracialyn() {
    return multiracialyn;
  }

  public void setMultiracialyn(String multiracialyn) {
    this.multiracialyn = multiracialyn;
  }


  public String getTumorgradestageseqnbr() {
    return tumorgradestageseqnbr;
  }

  public void setTumorgradestageseqnbr(String tumorgradestageseqnbr) {
    this.tumorgradestageseqnbr = tumorgradestageseqnbr;
  }


  public String getTumorgradestagedescription() {
    return tumorgradestagedescription;
  }

  public void setTumorgradestagedescription(String tumorgradestagedescription) {
    this.tumorgradestagedescription = tumorgradestagedescription;
  }


  public String getHugogenesymbolseqnbr() {
    return hugogenesymbolseqnbr;
  }

  public void setHugogenesymbolseqnbr(String hugogenesymbolseqnbr) {
    this.hugogenesymbolseqnbr = hugogenesymbolseqnbr;
  }


  public String getOncokbgenepanelavailyn() {
    return oncokbgenepanelavailyn;
  }

  public void setOncokbgenepanelavailyn(String oncokbgenepanelavailyn) {
    this.oncokbgenepanelavailyn = oncokbgenepanelavailyn;
  }

}
