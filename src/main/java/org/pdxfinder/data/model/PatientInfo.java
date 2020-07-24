package org.pdxfinder.data.model;

import javax.persistence.*;

@Entity
@Table(name = "Patientinfo")
public class PatientInfo {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_Sequence")
  @SequenceGenerator(name = "patient_Sequence", sequenceName = "PATIENT_SEQ")
  private String patientseqnbr;

  private String patientid;
  private String gender;
  private String ageatdiagnosis;
  private String initialdiagnosisconfirmedyn;
  private String knowngeneticmutations;
  private String diagnosissubtype;
  private String additionalmedicalhistory;
  private String delinkedyn;
  private String pdxsourceseqnbr;
  private String enrolledmpactclinprotyn;
  private String diagnosisshortname;
  private String meddracode;
  private java.sql.Date dateofdiagnosis;
  private String notes;
  private String genemedloadedyn;
  private String socialhistoryloadedyn;
  private String hasmetastaticdiseaseseqnbr;
  @Lob
  private byte[]  strprofiledocument;

  private String strprofilemimetype;
  private String strprofilefilename;
  private String contributorpdxid;
  private String contributorseqnbr;
  private String germlinewesftpttuseqnbr;
  private String germlinewesftpyn;
  private String germlinewesftpversion;
  private String germlinewes2Ftpttuseqnbr;
  private String germlinewes2Ftpyn;
  private String germlinewes2Ftpversion;
  private String germlinewesoncftpttuseqnbr;
  private String germlinewesoncftpyn;
  private String germlinewesoncftpversion;


  public String getPatientseqnbr() {
    return patientseqnbr;
  }

  public String getPatientid() {
    return patientid;
  }

  public String getGender() {
    return gender;
  }

  public String getAgeatdiagnosis() {
    return ageatdiagnosis;
  }

  public String getInitialdiagnosisconfirmedyn() {
    return initialdiagnosisconfirmedyn;
  }

  public String getKnowngeneticmutations() {
    return knowngeneticmutations;
  }

  public String getDiagnosissubtype() {
    return diagnosissubtype;
  }

  public String getAdditionalmedicalhistory() {
    return additionalmedicalhistory;
  }

  public String getDelinkedyn() {
    return delinkedyn;
  }

  public String getPdxsourceseqnbr() {
    return pdxsourceseqnbr;
  }

  public String getEnrolledmpactclinprotyn() {
    return enrolledmpactclinprotyn;
  }

  public String getDiagnosisshortname() {
    return diagnosisshortname;
  }

  public String getMeddracode() {
    return meddracode;
  }

  public java.sql.Date getDateofdiagnosis() {
    return dateofdiagnosis;
  }

  public String getNotes() {
    return notes;
  }

  public String getGenemedloadedyn() {
    return genemedloadedyn;
  }

  public String getSocialhistoryloadedyn() {
    return socialhistoryloadedyn;
  }

  public String getHasmetastaticdiseaseseqnbr() {
    return hasmetastaticdiseaseseqnbr;
  }

  public byte[]  getStrprofiledocument() {
    return strprofiledocument;
  }

  public String getStrprofilemimetype() {
    return strprofilemimetype;
  }

  public String getStrprofilefilename() {
    return strprofilefilename;
  }

  public String getContributorpdxid() {
    return contributorpdxid;
  }

  public String getContributorseqnbr() {
    return contributorseqnbr;
  }

  public String getGermlinewesftpttuseqnbr() {
    return germlinewesftpttuseqnbr;
  }

  public String getGermlinewesftpyn() {
    return germlinewesftpyn;
  }

  public String getGermlinewesftpversion() {
    return germlinewesftpversion;
  }

  public String getGermlinewes2Ftpttuseqnbr() {
    return germlinewes2Ftpttuseqnbr;
  }

  public String getGermlinewes2Ftpyn() {
    return germlinewes2Ftpyn;
  }

  public String getGermlinewes2Ftpversion() {
    return germlinewes2Ftpversion;
  }

  public String getGermlinewesoncftpttuseqnbr() {
    return germlinewesoncftpttuseqnbr;
  }

  public String getGermlinewesoncftpyn() {
    return germlinewesoncftpyn;
  }

  public String getGermlinewesoncftpversion() {
    return germlinewesoncftpversion;
  }

}
