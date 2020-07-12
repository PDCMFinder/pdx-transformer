package org.pdxfinder;

import javax.persistence.*;

@Entity
@Table(name = "Currenttherapy")
public class CurrentTherapy {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "currenttherapyseqnbr_Sequence")
  @SequenceGenerator(name = "currenttherapyseqnbr_Sequence", sequenceName = "CURRENTTHERAPY_SEQ")
  private String currenttherapyseqnbr;

  private String patientseqnbr;
  private String regimen;
  private java.sql.Date dateregimenstarted;
  private String bestresponseseqnbr;
  private String numberofcycles;
  private java.sql.Date dateprogressionoroff;
  private String comments;
  private String paid;
  private String standardizedregimenseqnbr;
  private String reasonforofftherapy;


  public String getCurrenttherapyseqnbr() {
    return currenttherapyseqnbr;
  }

  public void setCurrenttherapyseqnbr(String currenttherapyseqnbr) {
    this.currenttherapyseqnbr = currenttherapyseqnbr;
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


  public String getNumberofcycles() {
    return numberofcycles;
  }

  public void setNumberofcycles(String numberofcycles) {
    this.numberofcycles = numberofcycles;
  }


  public java.sql.Date getDateprogressionoroff() {
    return dateprogressionoroff;
  }

  public void setDateprogressionoroff(java.sql.Date dateprogressionoroff) {
    this.dateprogressionoroff = dateprogressionoroff;
  }


  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }


  public String getPaid() {
    return paid;
  }

  public void setPaid(String paid) {
    this.paid = paid;
  }


  public String getStandardizedregimenseqnbr() {
    return standardizedregimenseqnbr;
  }

  public void setStandardizedregimenseqnbr(String standardizedregimenseqnbr) {
    this.standardizedregimenseqnbr = standardizedregimenseqnbr;
  }


  public String getReasonforofftherapy() {
    return reasonforofftherapy;
  }

  public void setReasonforofftherapy(String reasonforofftherapy) {
    this.reasonforofftherapy = reasonforofftherapy;
  }

}
