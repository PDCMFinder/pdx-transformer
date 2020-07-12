package org.pdxfinder;

import javax.persistence.*;

@Entity
@Table(name = "Tumorgrades")
public class TumorGrades {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tumorgrade_Sequence")
  @SequenceGenerator(name = "tumorgrade_Sequence", sequenceName = "TUMORGRADE_SEQ")
  private String tumorgradeseqnbr;

  private String tumorgradeshortname;
  private String tumorgradedescription;


  public String getTumorgradeseqnbr() {
    return tumorgradeseqnbr;
  }

  public void setTumorgradeseqnbr(String tumorgradeseqnbr) {
    this.tumorgradeseqnbr = tumorgradeseqnbr;
  }


  public String getTumorgradeshortname() {
    return tumorgradeshortname;
  }

  public void setTumorgradeshortname(String tumorgradeshortname) {
    this.tumorgradeshortname = tumorgradeshortname;
  }


  public String getTumorgradedescription() {
    return tumorgradedescription;
  }

  public void setTumorgradedescription(String tumorgradedescription) {
    this.tumorgradedescription = tumorgradedescription;
  }

}
