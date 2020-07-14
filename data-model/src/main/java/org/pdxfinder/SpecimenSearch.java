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

  public String getPatientid() {
    return patientid;
  }

  public String getGender() {
    return gender;
  }

  public String getDiagnosisshortname() {
    return diagnosisshortname;
  }

  public String getDiagnosisdescription() {
    return diagnosisdescription;
  }

  public String getMeddracode() {
    return meddracode;
  }

  public String getMeddradescription() {
    return meddradescription;
  }

  public String getDiseaselocationseqnbr() {
    return diseaselocationseqnbr;
  }

  public String getDiseaselocationdescription() {
    return diseaselocationdescription;
  }

  public String getDelinkedyn() {
    return delinkedyn;
  }

  public String getHasmetastaticdiseaseseqnbr() {
    return hasmetastaticdiseaseseqnbr;
  }

  public String getHasmetastaticdiseasedesc() {
    return hasmetastaticdiseasedesc;
  }

  public String getGermlinewesftpyn() {
    return germlinewesftpyn;
  }

  public String getCurrentregimen() {
    return currentregimen;
  }

  public String getCurrentstandardizedregimensn() {
    return currentstandardizedregimensn;
  }

  public String getCurrentstandardizedregimen() {
    return currentstandardizedregimen;
  }

  public String getCurrentbestresponseseqnbr() {
    return currentbestresponseseqnbr;
  }

  public String getCurrentbestresponse() {
    return currentbestresponse;
  }

  public String getPriorregimen() {
    return priorregimen;
  }

  public String getPriorstandardizedregimenseqnbr() {
    return priorstandardizedregimenseqnbr;
  }

  public String getPriorstandardizedregimen() {
    return priorstandardizedregimen;
  }

  public String getPriorbestresponseseqnbr() {
    return priorbestresponseseqnbr;
  }

  public String getPriorbestresponse() {
    return priorbestresponse;
  }

  public String getStandardizedregimensn() {
    return standardizedregimensn;
  }

  public String getStandardizedregimen() {
    return standardizedregimen;
  }

  public String getSpecimenseqnbr() {
    return specimenseqnbr;
  }

  public String getSpecimenid() {
    return specimenid;
  }

  public String getTissuetypeshortname() {
    return tissuetypeshortname;
  }

  public String getTissuetypedescription() {
    return tissuetypedescription;
  }

  public String getArchiveyn() {
    return archiveyn;
  }

  public String getMsistatusseqnbr() {
    return msistatusseqnbr;
  }

  public String getMetastaticinnsgyn() {
    return metastaticinnsgyn;
  }

  public String getPdmtypeseqnbr() {
    return pdmtypeseqnbr;
  }

  public String getPdmtypedescription() {
    return pdmtypedescription;
  }

  public String getWholeexomesequenceftpyn() {
    return wholeexomesequenceftpyn;
  }

  public String getRnasequenceftpyn() {
    return rnasequenceftpyn;
  }

  public String getAffymetrixftpyn() {
    return affymetrixftpyn;
  }

  public String getSampleimagesavailyn() {
    return sampleimagesavailyn;
  }

  public String getMpactdataavailableyn() {
    return mpactdataavailableyn;
  }

  public String getGeneseqnbr() {
    return geneseqnbr;
  }

  public String getGene() {
    return gene;
  }

  public String getMpacttrialamoiyn() {
    return mpacttrialamoiyn;
  }

  public String getGenefunctionaleffect() {
    return genefunctionaleffect;
  }

  public String getGrowthcurveavailableyn() {
    return growthcurveavailableyn;
  }

  public String getSmoked100Seqnbr() {
    return smoked100Seqnbr;
  }

  public String getSmoked100Description() {
    return smoked100Description;
  }

  public String getEthnicityseqnbr() {
    return ethnicityseqnbr;
  }

  public String getEthnicitydescription() {
    return ethnicitydescription;
  }

  public String getRaceseqnbr() {
    return raceseqnbr;
  }

  public String getRacedescription() {
    return racedescription;
  }

  public String getMultiracialyn() {
    return multiracialyn;
  }

  public String getTumorgradestageseqnbr() {
    return tumorgradestageseqnbr;
  }

  public String getTumorgradestagedescription() {
    return tumorgradestagedescription;
  }

  public String getHugogenesymbolseqnbr() {
    return hugogenesymbolseqnbr;
  }

  public String getOncokbgenepanelavailyn() {
    return oncokbgenepanelavailyn;
  }
}
