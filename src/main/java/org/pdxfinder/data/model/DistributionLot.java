package org.pdxfinder.data.model;
import javax.persistence.*;

@Entity
@Table(name = "distributionlot")
public class DistributionLot {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "distributionlotseqnbr_Sequence")
    @SequenceGenerator(name = "distributionlotseqnbr_Sequence", sequenceName = "DistributionLot_SEQ")
    private String distributionlotseqnbr;
    private String specimenseqnbr;
    private String pdmtypeseqnbr;
    private String distributionlotname;
    private String distributionlotpassage;
    private String matchedculturepairyn;
    private String matchedculturepairname;
    private String publicaccessyn;
    private String cryopreservedfragmentsseqnbr;
    private String dnavialsseqnbr;
    private String rnavialsseqnbr;
    private String proteinextractionvialsseqnbr;
    private String invitroculturematerialseqnbr;
    private String invitrosampleseqnbr;


    public String distributionlotseqnbr() {
        return distributionlotseqnbr;
    }

    public String specimenseqnbr() {
        return specimenseqnbr;
    }

    public String pdmtypeseqnbr() {
        return pdmtypeseqnbr;
    }

    public String distributionlotname() {
        return distributionlotname;
    }

    public String distributionlotpassage() {
        return distributionlotpassage;
    }

    public String matchedculturepairyn() {
        return matchedculturepairyn;
    }

    public String matchedculturepairname() {
        return matchedculturepairname;
    }

    public String publicaccessyn() {
        return publicaccessyn;
    }

    public String cryopreservedfragmentsseqnbr() {
        return cryopreservedfragmentsseqnbr;
    }

    public String dnavialsseqnbr() {
        return dnavialsseqnbr;
    }

    public String rnavialsseqnbr() {
        return rnavialsseqnbr;
    }

    public String proteinextractionvialsseqnbr() {
        return proteinextractionvialsseqnbr;
    }

    public String invitroculturematerialseqnbr() {
        return invitroculturematerialseqnbr;
    }

    public String invitrosampleseqnbr() {
        return invitrosampleseqnbr;
    }
}

