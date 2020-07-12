package org.pdxfinder;

import javax.persistence.*;

@Entity
@Table(name = "Priortherapies")
public class PriorTherapies {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "priortherapies_Sequence")
  @SequenceGenerator(name = "priortherapies_Sequence", sequenceName = "PRIORTHERAPIES_SEQ")
  private String priortherapiesseqnbr;

  private String patientseqnbr;
  private String regimen;
  private java.sql.Date dateregimenstarted;
  private String bestresponseseqnbr;
  private String durationmonths;
  private String comments;
  private String ptid;
  private String standardizedregimenseqnbr;


  public String getPriortherapiesseqnbr() {
    return priortherapiesseqnbr;
  }

  public void setPriortherapiesseqnbr(String priortherapiesseqnbr) {
    this.priortherapiesseqnbr = priortherapiesseqnbr;
  }


  public String getPatientseqnbr() {
    return patientseqnbr;
  }

  public void setPatientseqnbr(String patientseqnbr) {
    this.patientseqnbr = patientseqnbr;
  }


  public String getRegimen() {
    return regimen;
  }

  public void setRegimen(String regimen) {
    this.regimen = regimen;
  }


  public java.sql.Date getDateregimenstarted() {
    return dateregimenstarted;
  }

  public void setDateregimenstarted(java.sql.Date dateregimenstarted) {
    this.dateregimenstarted = dateregimenstarted;
  }


  public String getBestresponseseqnbr() {
    return bestresponseseqnbr;
  }

  public void setBestresponseseqnbr(String bestresponseseqnbr) {
    this.bestresponseseqnbr = bestresponseseqnbr;
  }


  public String getDurationmonths() {
    return durationmonths;
  }

  public void setDurationmonths(String durationmonths) {
    this.durationmonths = durationmonths;
  }


  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }


  public String getPtid() {
    return ptid;
  }

  public void setPtid(String ptid) {
    this.ptid = ptid;
  }


  public String getStandardizedregimenseqnbr() {
    return standardizedregimenseqnbr;
  }

  public void setStandardizedregimenseqnbr(String standardizedregimenseqnbr) {
    this.standardizedregimenseqnbr = standardizedregimenseqnbr;
  }

}
