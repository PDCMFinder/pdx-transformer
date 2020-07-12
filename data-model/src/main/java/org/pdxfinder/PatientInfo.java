package org.pdxfinder;

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


  public String getAgeatdiagnosis() {
    return ageatdiagnosis;
  }

  public void setAgeatdiagnosis(String ageatdiagnosis) {
    this.ageatdiagnosis = ageatdiagnosis;
  }


  public String getInitialdiagnosisconfirmedyn() {
    return initialdiagnosisconfirmedyn;
  }

  public void setInitialdiagnosisconfirmedyn(String initialdiagnosisconfirmedyn) {
    this.initialdiagnosisconfirmedyn = initialdiagnosisconfirmedyn;
  }


  public String getKnowngeneticmutations() {
    return knowngeneticmutations;
  }

  public void setKnowngeneticmutations(String knowngeneticmutations) {
    this.knowngeneticmutations = knowngeneticmutations;
  }


  public String getDiagnosissubtype() {
    return diagnosissubtype;
  }

  public void setDiagnosissubtype(String diagnosissubtype) {
    this.diagnosissubtype = diagnosissubtype;
  }


  public String getAdditionalmedicalhistory() {
    return additionalmedicalhistory;
  }

  public void setAdditionalmedicalhistory(String additionalmedicalhistory) {
    this.additionalmedicalhistory = additionalmedicalhistory;
  }


  public String getDelinkedyn() {
    return delinkedyn;
  }

  public void setDelinkedyn(String delinkedyn) {
    this.delinkedyn = delinkedyn;
  }


  public String getPdxsourceseqnbr() {
    return pdxsourceseqnbr;
  }

  public void setPdxsourceseqnbr(String pdxsourceseqnbr) {
    this.pdxsourceseqnbr = pdxsourceseqnbr;
  }


  public String getEnrolledmpactclinprotyn() {
    return enrolledmpactclinprotyn;
  }

  public void setEnrolledmpactclinprotyn(String enrolledmpactclinprotyn) {
    this.enrolledmpactclinprotyn = enrolledmpactclinprotyn;
  }


  public String getDiagnosisshortname() {
    return diagnosisshortname;
  }

  public void setDiagnosisshortname(String diagnosisshortname) {
    this.diagnosisshortname = diagnosisshortname;
  }


  public String getMeddracode() {
    return meddracode;
  }

  public void setMeddracode(String meddracode) {
    this.meddracode = meddracode;
  }


  public java.sql.Date getDateofdiagnosis() {
    return dateofdiagnosis;
  }

  public void setDateofdiagnosis(java.sql.Date dateofdiagnosis) {
    this.dateofdiagnosis = dateofdiagnosis;
  }


  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }


  public String getGenemedloadedyn() {
    return genemedloadedyn;
  }

  public void setGenemedloadedyn(String genemedloadedyn) {
    this.genemedloadedyn = genemedloadedyn;
  }


  public String getSocialhistoryloadedyn() {
    return socialhistoryloadedyn;
  }

  public void setSocialhistoryloadedyn(String socialhistoryloadedyn) {
    this.socialhistoryloadedyn = socialhistoryloadedyn;
  }


  public String getHasmetastaticdiseaseseqnbr() {
    return hasmetastaticdiseaseseqnbr;
  }

  public void setHasmetastaticdiseaseseqnbr(String hasmetastaticdiseaseseqnbr) {
    this.hasmetastaticdiseaseseqnbr = hasmetastaticdiseaseseqnbr;
  }


  public byte[]  getStrprofiledocument() {
    return strprofiledocument;
  }

  public void setStrprofiledocument(byte[] strprofiledocument) {
    this.strprofiledocument = strprofiledocument;
  }


  public String getStrprofilemimetype() {
    return strprofilemimetype;
  }

  public void setStrprofilemimetype(String strprofilemimetype) {
    this.strprofilemimetype = strprofilemimetype;
  }


  public String getStrprofilefilename() {
    return strprofilefilename;
  }

  public void setStrprofilefilename(String strprofilefilename) {
    this.strprofilefilename = strprofilefilename;
  }


  public String getContributorpdxid() {
    return contributorpdxid;
  }

  public void setContributorpdxid(String contributorpdxid) {
    this.contributorpdxid = contributorpdxid;
  }


  public String getContributorseqnbr() {
    return contributorseqnbr;
  }

  public void setContributorseqnbr(String contributorseqnbr) {
    this.contributorseqnbr = contributorseqnbr;
  }


  public String getGermlinewesftpttuseqnbr() {
    return germlinewesftpttuseqnbr;
  }

  public void setGermlinewesftpttuseqnbr(String germlinewesftpttuseqnbr) {
    this.germlinewesftpttuseqnbr = germlinewesftpttuseqnbr;
  }


  public String getGermlinewesftpyn() {
    return germlinewesftpyn;
  }

  public void setGermlinewesftpyn(String germlinewesftpyn) {
    this.germlinewesftpyn = germlinewesftpyn;
  }


  public String getGermlinewesftpversion() {
    return germlinewesftpversion;
  }

  public void setGermlinewesftpversion(String germlinewesftpversion) {
    this.germlinewesftpversion = germlinewesftpversion;
  }


  public String getGermlinewes2Ftpttuseqnbr() {
    return germlinewes2Ftpttuseqnbr;
  }

  public void setGermlinewes2Ftpttuseqnbr(String germlinewes2Ftpttuseqnbr) {
    this.germlinewes2Ftpttuseqnbr = germlinewes2Ftpttuseqnbr;
  }


  public String getGermlinewes2Ftpyn() {
    return germlinewes2Ftpyn;
  }

  public void setGermlinewes2Ftpyn(String germlinewes2Ftpyn) {
    this.germlinewes2Ftpyn = germlinewes2Ftpyn;
  }


  public String getGermlinewes2Ftpversion() {
    return germlinewes2Ftpversion;
  }

  public void setGermlinewes2Ftpversion(String germlinewes2Ftpversion) {
    this.germlinewes2Ftpversion = germlinewes2Ftpversion;
  }


  public String getGermlinewesoncftpttuseqnbr() {
    return germlinewesoncftpttuseqnbr;
  }

  public void setGermlinewesoncftpttuseqnbr(String germlinewesoncftpttuseqnbr) {
    this.germlinewesoncftpttuseqnbr = germlinewesoncftpttuseqnbr;
  }


  public String getGermlinewesoncftpyn() {
    return germlinewesoncftpyn;
  }

  public void setGermlinewesoncftpyn(String germlinewesoncftpyn) {
    this.germlinewesoncftpyn = germlinewesoncftpyn;
  }


  public String getGermlinewesoncftpversion() {
    return germlinewesoncftpversion;
  }

  public void setGermlinewesoncftpversion(String germlinewesoncftpversion) {
    this.germlinewesoncftpversion = germlinewesoncftpversion;
  }

}
