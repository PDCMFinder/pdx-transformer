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

  public String getClinicalresponseshortname() {
    return clinicalresponseshortname;
  }

  public String getClinicalresponsedescription() {
    return clinicalresponsedescription;
  }


}
