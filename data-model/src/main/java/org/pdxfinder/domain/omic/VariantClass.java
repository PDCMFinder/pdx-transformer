package org.pdxfinder.domain.omic;

import javax.persistence.*;

@Entity
@Table(name = "Variantclass")
public class VariantClass {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "variantclassseqnbr_Sequence")
  @SequenceGenerator(name = "variantclassseqnbr_Sequence", sequenceName = "VARIANTCLASS_SEQ")
  private String variantclassseqnbr;
  private String variantclassdescription;

  public String getVariantclassseqnbr() {
    return variantclassseqnbr;
  }

  public String getVariantclassdescription() {
    return variantclassdescription;
  }
}
