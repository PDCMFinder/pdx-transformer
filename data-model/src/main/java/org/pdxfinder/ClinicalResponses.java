package org.pdxfinder;


import javax.persistence.*;

@Entity
@Table(name = "Clinicalresponses")
public class ClinicalResponses {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clinicalresponseseqnbr_Sequence")
  @SequenceGenerator(name = "clinicalresponseseqnbr_Sequence", sequenceName = "CLINICALRESPONSE_SEQ")
  private String clinicalresponseseqnbr;

  private String clinicalresponseshortname;
  private String clinicalresponsedescription;


  public String getClinicalresponseseqnbr() {
    return clinicalresponseseqnbr;
  }

  public void setClinicalresponseseqnbr(String clinicalresponseseqnbr) {
    this.clinicalresponseseqnbr = clinicalresponseseqnbr;
  }


  public String getClinicalresponseshortname() {
    return clinicalresponseshortname;
  }

  public void setClinicalresponseshortname(String clinicalresponseshortname) {
    this.clinicalresponseshortname = clinicalresponseshortname;
  }


  public String getClinicalresponsedescription() {
    return clinicalresponsedescription;
  }

  public void setClinicalresponsedescription(String clinicalresponsedescription) {
    this.clinicalresponsedescription = clinicalresponsedescription;
  }

}
