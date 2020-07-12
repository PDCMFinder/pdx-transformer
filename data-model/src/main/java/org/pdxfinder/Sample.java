package org.pdxfinder;

import javax.persistence.*;

@Entity
public class Sample {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sample_Sequence")
  @SequenceGenerator(name = "sample_Sequence", sequenceName = "SAMPLE_SEQ")
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

  public void setSampleseqnbr(String sampleseqnbr) {
    this.sampleseqnbr = sampleseqnbr;
  }


  public String getSpecimenseqnbr() {
    return specimenseqnbr;
  }

  public void setSpecimenseqnbr(String specimenseqnbr) {
    this.specimenseqnbr = specimenseqnbr;
  }


  public String getSampleid() {
    return sampleid;
  }

  public void setSampleid(String sampleid) {
    this.sampleid = sampleid;
  }


  public String getPassageprimaryyn() {
    return passageprimaryyn;
  }

  public void setPassageprimaryyn(String passageprimaryyn) {
    this.passageprimaryyn = passageprimaryyn;
  }


  public String getPdmtypeseqnbr() {
    return pdmtypeseqnbr;
  }

  public void setPdmtypeseqnbr(String pdmtypeseqnbr) {
    this.pdmtypeseqnbr = pdmtypeseqnbr;
  }


  public String getPassageofthissample() {
    return passageofthissample;
  }

  public void setPassageofthissample(String passageofthissample) {
    this.passageofthissample = passageofthissample;
  }


  public String getMpactsequencingdatayn() {
    return mpactsequencingdatayn;
  }

  public void setMpactsequencingdatayn(String mpactsequencingdatayn) {
    this.mpactsequencingdatayn = mpactsequencingdatayn;
  }


  public String getSamplenotes() {
    return samplenotes;
  }

  public void setSamplenotes(String samplenotes) {
    this.samplenotes = samplenotes;
  }


  public String getWholeexomesequenceftpyn() {
    return wholeexomesequenceftpyn;
  }

  public void setWholeexomesequenceftpyn(String wholeexomesequenceftpyn) {
    this.wholeexomesequenceftpyn = wholeexomesequenceftpyn;
  }


  public String getRnasequenceftpyn() {
    return rnasequenceftpyn;
  }

  public void setRnasequenceftpyn(String rnasequenceftpyn) {
    this.rnasequenceftpyn = rnasequenceftpyn;
  }


  public String getAffymetrixftpyn() {
    return affymetrixftpyn;
  }

  public void setAffymetrixftpyn(String affymetrixftpyn) {
    this.affymetrixftpyn = affymetrixftpyn;
  }


  public String getWholeexomesequence2Ftpyn() {
    return wholeexomesequence2Ftpyn;
  }

  public void setWholeexomesequence2Ftpyn(String wholeexomesequence2Ftpyn) {
    this.wholeexomesequence2Ftpyn = wholeexomesequence2Ftpyn;
  }


  public String getCulturederivation() {
    return culturederivation;
  }

  public void setCulturederivation(String culturederivation) {
    this.culturederivation = culturederivation;
  }


  public String getGrowthpropertyseqnbr() {
    return growthpropertyseqnbr;
  }

  public void setGrowthpropertyseqnbr(String growthpropertyseqnbr) {
    this.growthpropertyseqnbr = growthpropertyseqnbr;
  }


  public String getProliferationrate() {
    return proliferationrate;
  }

  public void setProliferationrate(String proliferationrate) {
    this.proliferationrate = proliferationrate;
  }


  public String getSubculturerecommendations() {
    return subculturerecommendations;
  }

  public void setSubculturerecommendations(String subculturerecommendations) {
    this.subculturerecommendations = subculturerecommendations;
  }


  public String getSpheroidcultureyn() {
    return spheroidcultureyn;
  }

  public void setSpheroidcultureyn(String spheroidcultureyn) {
    this.spheroidcultureyn = spheroidcultureyn;
  }


  public String getSpheroidculturenotes() {
    return spheroidculturenotes;
  }

  public void setSpheroidculturenotes(String spheroidculturenotes) {
    this.spheroidculturenotes = spheroidculturenotes;
  }


  public String getSoftagargrowthyn() {
    return softagargrowthyn;
  }

  public void setSoftagargrowthyn(String softagargrowthyn) {
    this.softagargrowthyn = softagargrowthyn;
  }


  public String getSoftagargrowthnotes() {
    return softagargrowthnotes;
  }

  public void setSoftagargrowthnotes(String softagargrowthnotes) {
    this.softagargrowthnotes = softagargrowthnotes;
  }


  public String getTumorigenicinngsmiceyn() {
    return tumorigenicinngsmiceyn;
  }

  public void setTumorigenicinngsmiceyn(String tumorigenicinngsmiceyn) {
    this.tumorigenicinngsmiceyn = tumorigenicinngsmiceyn;
  }


  public String getFacsCharacterization() {
    return facsCharacterization;
  }

  public void setFacsCharacterization(String facsCharacterization) {
    this.facsCharacterization = facsCharacterization;
  }


  public String getQrtpcrC1Correlation() {
    return qrtpcrC1Correlation;
  }

  public void setQrtpcrC1Correlation(String qrtpcrC1Correlation) {
    this.qrtpcrC1Correlation = qrtpcrC1Correlation;
  }


  public String getQrtpcrC2Correlation() {
    return qrtpcrC2Correlation;
  }

  public void setQrtpcrC2Correlation(String qrtpcrC2Correlation) {
    this.qrtpcrC2Correlation = qrtpcrC2Correlation;
  }


  public String getQrtpcrTophits() {
    return qrtpcrTophits;
  }

  public void setQrtpcrTophits(String qrtpcrTophits) {
    this.qrtpcrTophits = qrtpcrTophits;
  }


  public String getHumanpathogentesting() {
    return humanpathogentesting;
  }

  public void setHumanpathogentesting(String humanpathogentesting) {
    this.humanpathogentesting = humanpathogentesting;
  }


  public String getRnasequencetpmftpyn() {
    return rnasequencetpmftpyn;
  }

  public void setRnasequencetpmftpyn(String rnasequencetpmftpyn) {
    this.rnasequencetpmftpyn = rnasequencetpmftpyn;
  }


  public String getWholeexomesequenceftpversion() {
    return wholeexomesequenceftpversion;
  }

  public void setWholeexomesequenceftpversion(String wholeexomesequenceftpversion) {
    this.wholeexomesequenceftpversion = wholeexomesequenceftpversion;
  }


  public String getWholeexomesequence2Ftpversion() {
    return wholeexomesequence2Ftpversion;
  }

  public void setWholeexomesequence2Ftpversion(String wholeexomesequence2Ftpversion) {
    this.wholeexomesequence2Ftpversion = wholeexomesequence2Ftpversion;
  }


  public String getRnasequenceftpversion() {
    return rnasequenceftpversion;
  }

  public void setRnasequenceftpversion(String rnasequenceftpversion) {
    this.rnasequenceftpversion = rnasequenceftpversion;
  }


  public String getRnasequencetpmftpversion() {
    return rnasequencetpmftpversion;
  }

  public void setRnasequencetpmftpversion(String rnasequencetpmftpversion) {
    this.rnasequencetpmftpversion = rnasequencetpmftpversion;
  }


  public String getAffymetrixftpversion() {
    return affymetrixftpversion;
  }

  public void setAffymetrixftpversion(String affymetrixftpversion) {
    this.affymetrixftpversion = affymetrixftpversion;
  }


  public String getWholeexomesequenceftpttuseqnbr() {
    return wholeexomesequenceftpttuseqnbr;
  }

  public void setWholeexomesequenceftpttuseqnbr(String wholeexomesequenceftpttuseqnbr) {
    this.wholeexomesequenceftpttuseqnbr = wholeexomesequenceftpttuseqnbr;
  }


  public String getWholeexomesequence2Ftpttusn() {
    return wholeexomesequence2Ftpttusn;
  }

  public void setWholeexomesequence2Ftpttusn(String wholeexomesequence2Ftpttusn) {
    this.wholeexomesequence2Ftpttusn = wholeexomesequence2Ftpttusn;
  }


  public String getRnasequenceftpttuseqnbr() {
    return rnasequenceftpttuseqnbr;
  }

  public void setRnasequenceftpttuseqnbr(String rnasequenceftpttuseqnbr) {
    this.rnasequenceftpttuseqnbr = rnasequenceftpttuseqnbr;
  }


  public String getRnasequencetpmftpttuseqnbr() {
    return rnasequencetpmftpttuseqnbr;
  }

  public void setRnasequencetpmftpttuseqnbr(String rnasequencetpmftpttuseqnbr) {
    this.rnasequencetpmftpttuseqnbr = rnasequencetpmftpttuseqnbr;
  }


  public String getAffymetrixftpttuseqnbr() {
    return affymetrixftpttuseqnbr;
  }

  public void setAffymetrixftpttuseqnbr(String affymetrixftpttuseqnbr) {
    this.affymetrixftpttuseqnbr = affymetrixftpttuseqnbr;
  }


  public String getSomaticwesftpttuseqnbr() {
    return somaticwesftpttuseqnbr;
  }

  public void setSomaticwesftpttuseqnbr(String somaticwesftpttuseqnbr) {
    this.somaticwesftpttuseqnbr = somaticwesftpttuseqnbr;
  }


  public String getSomaticwesftpyn() {
    return somaticwesftpyn;
  }

  public void setSomaticwesftpyn(String somaticwesftpyn) {
    this.somaticwesftpyn = somaticwesftpyn;
  }


  public String getSomaticwesftpversion() {
    return somaticwesftpversion;
  }

  public void setSomaticwesftpversion(String somaticwesftpversion) {
    this.somaticwesftpversion = somaticwesftpversion;
  }


  public String getCultureoriginseqnbr() {
    return cultureoriginseqnbr;
  }

  public void setCultureoriginseqnbr(String cultureoriginseqnbr) {
    this.cultureoriginseqnbr = cultureoriginseqnbr;
  }


  public String getRequiredmediaseqnbr() {
    return requiredmediaseqnbr;
  }

  public void setRequiredmediaseqnbr(String requiredmediaseqnbr) {
    this.requiredmediaseqnbr = requiredmediaseqnbr;
  }


  public String getWesoncokbftpyn() {
    return wesoncokbftpyn;
  }

  public void setWesoncokbftpyn(String wesoncokbftpyn) {
    this.wesoncokbftpyn = wesoncokbftpyn;
  }


  public String getWesoncokbftpversion() {
    return wesoncokbftpversion;
  }

  public void setWesoncokbftpversion(String wesoncokbftpversion) {
    this.wesoncokbftpversion = wesoncokbftpversion;
  }


  public String getWesoncokbftpversionprocessed() {
    return wesoncokbftpversionprocessed;
  }

  public void setWesoncokbftpversionprocessed(String wesoncokbftpversionprocessed) {
    this.wesoncokbftpversionprocessed = wesoncokbftpversionprocessed;
  }

}
