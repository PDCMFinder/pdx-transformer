package org.pdxfinder.data.model;
import javax.persistence.*;

@Entity
@Table(name = "Meddracodes")
public class MedDRACodes {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "meddra_Sequence")
    @SequenceGenerator(name = "meddraSequence", sequenceName = "MEDDRA_SEQ")
    private String meddraseqnbr;
    private String meddracode;
    private String meddrashortname;
    private String meddradescription;

    public String getMeddraseqnbr() {
        return meddraseqnbr;
    }

    public String getMeddracode() {
        return meddracode;
    }

    public String getMeddrashortname() {
        return meddrashortname;
    }

    public String getMeddradescription() {
        return meddradescription;
    }

}
