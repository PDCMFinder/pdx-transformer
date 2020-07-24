package org.pdxfinder.data.model;

import javax.persistence.*;

@Entity
@Table(name = "Providedtissueorigins")
public class ProvidedTissueOrigins {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "providedtissueorigin_Sequence")
  @SequenceGenerator(name = "providedtissueorigin_Sequence", sequenceName = "PROVIDEDTISSUEORIGIN_SEQ")
  private String providedtissueoriginseqnbr;

  private String providedtissueorigindescript;


  public String getProvidedtissueoriginseqnbr() {
    return providedtissueoriginseqnbr;
  }

  public String getProvidedtissueorigindescript() {
    return providedtissueorigindescript;
  }

}
