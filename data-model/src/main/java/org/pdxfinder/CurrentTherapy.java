package org.pdxfinder;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Currenttherapy")
public class CurrentTherapy {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "currenttherapyseqnbr_Sequence")
    @SequenceGenerator(name = "currenttherapyseqnbr_Sequence", sequenceName = "CURRENTTHERAPY_SEQ")
    private String currenttherapyseqnbr;

    private String patientseqnbr;
    private String regimen;
    private Date dateregimenstarted;
    private String bestresponseseqnbr;
    private String numberofcycles;
    private Date dateprogressionoroff;
    private String comments;
    private String paid;
    private String standardizedregimenseqnbr;
    private String reasonforofftherapy;

    public String getCurrenttherapyseqnbr() {
        return currenttherapyseqnbr;
    }

    public String getPatientseqnbr() {
        return patientseqnbr;
    }

    public String getRegimen() {
        return regimen;
    }

    public Date getDateregimenstarted() {
        return dateregimenstarted;
    }

    public String getBestresponseseqnbr() {
        return bestresponseseqnbr;
    }

    public String getNumberofcycles() {
        return numberofcycles;
    }

    public Date getDateprogressionoroff() {
        return dateprogressionoroff;
    }

    public String getComments() {
        return comments;
    }

    public String getPaid() {
        return paid;
    }

    public String getStandardizedregimenseqnbr() {
        return standardizedregimenseqnbr;
    }

    public String getReasonforofftherapy() {
        return reasonforofftherapy;
    }

}
