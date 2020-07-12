package org.pdxfinder;

import javax.persistence.*;

@Entity
@Table(name = "Standardizedregimens")
public class StandardizedRegimens {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "regimen_Sequence")
  @SequenceGenerator(name = "regimen_Sequence", sequenceName = "REGIMEN_SEQ")
  private String regimenseqnbr;

  private String inputregimen;
  private String displayedregimen;


  public String getRegimenseqnbr() {
    return regimenseqnbr;
  }

  public void setRegimenseqnbr(String regimenseqnbr) {
    this.regimenseqnbr = regimenseqnbr;
  }


  public String getInputregimen() {
    return inputregimen;
  }

  public void setInputregimen(String inputregimen) {
    this.inputregimen = inputregimen;
  }


  public String getDisplayedregimen() {
    return displayedregimen;
  }

  public void setDisplayedregimen(String displayedregimen) {
    this.displayedregimen = displayedregimen;
  }

}
