package org.pdxfinder.domain;

import javax.persistence.*;

@Entity
@Table(name = "Oncokbgenepanel")
public class OncokbGenePanel {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oncokbgenepanelseqnbr_Sequence")
  @SequenceGenerator(name = "oncokbgenepanelseqnbr_Sequence", sequenceName = "ONCOKBGENEPANEL_SEQ")
  private String oncokbgenepanelseqnbr;

  private String sampleseqnbr;
  private String hugogenesymbolseqnbr;
  private String chromosome;
  private String startposition;
  private String endposition;
  private String variantclassseqnbr;
  private String referenceallele;
  private String altallele;
  private String hgvscdnachange;
  private String hgvsproteinchange;
  private String existingvariant;
  private String totalreads;
  private String variantadellefreq;
  private String sift;
  private String polyphen;
  private String oncogenicity;
  private String mutationeffect;


  public String getOncokbgenepanelseqnbr() {
    return oncokbgenepanelseqnbr;
  }

  public String getSampleseqnbr() {
    return sampleseqnbr;
  }

  public String getHugogenesymbolseqnbr() {
    return hugogenesymbolseqnbr;
  }

  public String getChromosome() {
    return chromosome;
  }

  public String getStartposition() {
    return startposition;
  }

  public String getEndposition() {
    return endposition;
  }

  public String getVariantclassseqnbr() {
    return variantclassseqnbr;
  }

  public String getReferenceallele() {
    return referenceallele;
  }

  public String getAltallele() {
    return altallele;
  }

  public String getHgvscdnachange() {
    return hgvscdnachange;
  }

  public String getHgvsproteinchange() {
    return hgvsproteinchange;
  }

  public String getExistingvariant() {
    return existingvariant;
  }

  public String getTotalreads() {
    return totalreads;
  }

  public String getVariantadellefreq() {
    return variantadellefreq;
  }

  public String getSift() {
    return sift;
  }

  public String getPolyphen() {
    return polyphen;
  }

  public String getOncogenicity() {
    return oncogenicity;
  }

  public String getMutationeffect() {
    return mutationeffect;
  }
}
