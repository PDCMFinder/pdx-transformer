package org.pdxfinder.domain;

import javax.persistence.*;

@Entity
@Table(name = "Implantationsites")
public class ImplantationSites {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "implantationsites_Sequence")
  @SequenceGenerator(name = "implantationsites_Sequence", sequenceName = "IMPLANTATIONSITES_SEQ")
  private String implantationsiteseqnbr;

  private String implantationsitedescription;


  public String getImplantationsiteseqnbr() {
    return implantationsiteseqnbr;
  }

  public String getImplantationsitedescription() {
    return implantationsitedescription;
  }

}
