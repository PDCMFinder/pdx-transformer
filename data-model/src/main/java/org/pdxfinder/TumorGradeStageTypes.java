package org.pdxfinder;

import javax.persistence.*;

@Entity
@Table(name = "Tumorgradestagetypes")
public class TumorGradeStageTypes {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tumorgradestage_Sequence")
  @SequenceGenerator(name = "tumorgradestage_Sequence", sequenceName = "TUMORGRADESTAGE_SEQ")
  private String tumorgradestageseqnbr;

  private String tumorgradestageshortname;
  private String tumorgradestagedescription;


  public String getTumorgradestageseqnbr() {
    return tumorgradestageseqnbr;
  }

  public void setTumorgradestageseqnbr(String tumorgradestageseqnbr) {
    this.tumorgradestageseqnbr = tumorgradestageseqnbr;
  }


  public String getTumorgradestageshortname() {
    return tumorgradestageshortname;
  }

  public void setTumorgradestageshortname(String tumorgradestageshortname) {
    this.tumorgradestageshortname = tumorgradestageshortname;
  }


  public String getTumorgradestagedescription() {
    return tumorgradestagedescription;
  }

  public void setTumorgradestagedescription(String tumorgradestagedescription) {
    this.tumorgradestagedescription = tumorgradestagedescription;
  }

}
