package org.pdxfinder.domain;

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

  public String getPatientseqnbr() {
    return patientseqnbr;
  }

  public String getRegimen() {
    return regimen;
  }

  public java.sql.Date getDateregimenstarted() {
    return dateregimenstarted;
  }

  public String getBestresponseseqnbr() {
    return bestresponseseqnbr;
  }

  public String getDurationmonths() {
    return durationmonths;
  }

  public String getComments() {
    return comments;
  }

  public String getPtid() {
    return ptid;
  }

  public String getStandardizedregimenseqnbr() {
    return standardizedregimenseqnbr;
  }

}
