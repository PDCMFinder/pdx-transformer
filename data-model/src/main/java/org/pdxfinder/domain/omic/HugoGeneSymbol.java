package org.pdxfinder.domain.omic;


import javax.persistence.*;

@Entity
@Table(name = "Hugogenesymbol")
public class HugoGeneSymbol {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hugogenesymbolseqnbr_Sequence")
  @SequenceGenerator(name = "hugogenesymbolseqnbr_Sequence", sequenceName = "HUGOGENESYMBOL_SEQ")
  private String hugogenesymbolseqnbr;

  private String hugogenesymboldescription;

  public String getHugogenesymbolseqnbr() {
    return hugogenesymbolseqnbr;
  }

  public String getHugogenesymboldescription() {
    return hugogenesymboldescription;
  }
}
