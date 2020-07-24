package org.pdxfinder.domain;

import javax.persistence.*;

@Entity
public class Sample {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "specimen_Sequence")
  @SequenceGenerator(name = "specimen_Sequence", sequenceName = "SPECIMEN_SEQ")
  private String sampleseqnbr;

  private String specimenseqnbr;
  private String sampleid;
  private String passageprimaryyn;
  private String pdmtypeseqnbr;
  private String passageofthissample;
  private String mpactsequencingdatayn;
  private String samplenotes;
  private String wholeexomesequenceftpyn;
  private String rnasequenceftpyn;
  private String affymetrixftpyn;
  private String wholeexomesequence2Ftpyn;
  private String culturederivation;
  private String growthpropertyseqnbr;
  private String proliferationrate;
  private String subculturerecommendations;
  private String spheroidcultureyn;
  private String spheroidculturenotes;
  private String softagargrowthyn;
  private String softagargrowthnotes;
  private String tumorigenicinngsmiceyn;
  private String facsCharacterization;

  @Column(name = "QRTPCR_C1CORRELATION")
  private String qrtpcrC1Correlation;

  @Column(name = "QRTPCR_C2CORRELATION")
  private String qrtpcrC2Correlation;

  @Column(name = "QRTPCR_TOPHITS")
  private String qrtpcrTophits;
  private String humanpathogentesting;
  private String rnasequencetpmftpyn;
  private String wholeexomesequenceftpversion;
  private String wholeexomesequence2Ftpversion;
  private String rnasequenceftpversion;
  private String rnasequencetpmftpversion;
  private String affymetrixftpversion;
  private String wholeexomesequenceftpttuseqnbr;
  private String wholeexomesequence2Ftpttusn;
  private String rnasequenceftpttuseqnbr;
  private String rnasequencetpmftpttuseqnbr;
  private String affymetrixftpttuseqnbr;
  private String somaticwesftpttuseqnbr;
  private String somaticwesftpyn;
  private String somaticwesftpversion;
  private String cultureoriginseqnbr;
  private String requiredmediaseqnbr;
  private String wesoncokbftpyn;
  private String wesoncokbftpversion;
  private String wesoncokbftpversionprocessed;


  public String getSampleseqnbr() {
    return sampleseqnbr;
  }

  public String getSpecimenseqnbr() {
    return specimenseqnbr;
  }

  public String getSampleid() {
    return sampleid;
  }

  public String getPassageprimaryyn() {
    return passageprimaryyn;
  }

  public String getPdmtypeseqnbr() {
    return pdmtypeseqnbr;
  }

  public String getPassageofthissample() {
    return passageofthissample;
  }

  public String getMpactsequencingdatayn() {
    return mpactsequencingdatayn;
  }

  public String getSamplenotes() {
    return samplenotes;
  }

  public String getWholeexomesequenceftpyn() {
    return wholeexomesequenceftpyn;
  }

  public String getRnasequenceftpyn() {
    return rnasequenceftpyn;
  }

  public String getAffymetrixftpyn() {
    return affymetrixftpyn;
  }

  public String getWholeexomesequence2Ftpyn() {
    return wholeexomesequence2Ftpyn;
  }

  public String getCulturederivation() {
    return culturederivation;
  }

  public String getGrowthpropertyseqnbr() {
    return growthpropertyseqnbr;
  }

  public String getProliferationrate() {
    return proliferationrate;
  }

  public String getSubculturerecommendations() {
    return subculturerecommendations;
  }

  public String getSpheroidcultureyn() {
    return spheroidcultureyn;
  }

  public String getSpheroidculturenotes() {
    return spheroidculturenotes;
  }

  public String getSoftagargrowthyn() {
    return softagargrowthyn;
  }

  public String getSoftagargrowthnotes() {
    return softagargrowthnotes;
  }

  public String getTumorigenicinngsmiceyn() {
    return tumorigenicinngsmiceyn;
  }

  public String getFacsCharacterization() {
    return facsCharacterization;
  }

  public String getQrtpcrC1Correlation() {
    return qrtpcrC1Correlation;
  }

  public String getQrtpcrC2Correlation() {
    return qrtpcrC2Correlation;
  }

  public String getQrtpcrTophits() {
    return qrtpcrTophits;
  }

  public String getHumanpathogentesting() {
    return humanpathogentesting;
  }

  public String getRnasequencetpmftpyn() {
    return rnasequencetpmftpyn;
  }

  public String getWholeexomesequenceftpversion() {
    return wholeexomesequenceftpversion;
  }

  public String getWholeexomesequence2Ftpversion() {
    return wholeexomesequence2Ftpversion;
  }

  public String getRnasequenceftpversion() {
    return rnasequenceftpversion;
  }

  public String getRnasequencetpmftpversion() {
    return rnasequencetpmftpversion;
  }

  public String getAffymetrixftpversion() {
    return affymetrixftpversion;
  }

  public String getWholeexomesequenceftpttuseqnbr() {
    return wholeexomesequenceftpttuseqnbr;
  }

  public String getWholeexomesequence2Ftpttusn() {
    return wholeexomesequence2Ftpttusn;
  }

  public String getRnasequenceftpttuseqnbr() {
    return rnasequenceftpttuseqnbr;
  }

  public String getRnasequencetpmftpttuseqnbr() {
    return rnasequencetpmftpttuseqnbr;
  }

  public String getAffymetrixftpttuseqnbr() {
    return affymetrixftpttuseqnbr;
  }

  public String getSomaticwesftpttuseqnbr() {
    return somaticwesftpttuseqnbr;
  }

  public String getSomaticwesftpyn() {
    return somaticwesftpyn;
  }

  public String getSomaticwesftpversion() {
    return somaticwesftpversion;
  }

  public String getCultureoriginseqnbr() {
    return cultureoriginseqnbr;
  }

  public String getRequiredmediaseqnbr() {
    return requiredmediaseqnbr;
  }

  public String getWesoncokbftpyn() {
    return wesoncokbftpyn;
  }

  public String getWesoncokbftpversion() {
    return wesoncokbftpversion;
  }

  public String getWesoncokbftpversionprocessed() {
    return wesoncokbftpversionprocessed;
  }

}
