package org.pdxfinder.data.model;

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

  public String getTumorgradestageshortname() {
    return tumorgradestageshortname;
  }

  public String getTumorgradestagedescription() {
    return tumorgradestagedescription;
  }
}
