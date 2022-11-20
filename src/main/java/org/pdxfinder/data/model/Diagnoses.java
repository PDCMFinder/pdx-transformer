package org.pdxfinder.data.model;
import javax.persistence.*;

@Entity
@Table(name = "Diagnoses")
public class Diagnoses {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "diagnosis_Sequence")
    @SequenceGenerator(name = "diagnosisSequence", sequenceName = "DIAGNOSIS_SEQ")
    private String diagnosisseqnbr;
    private String diagnosisshortname;
    private String diagnosisdescription;

    public String getDiagnosisseqnbr() {
        return diagnosisseqnbr;
    }

    public String getDiagnosisshortname() {
        return diagnosisshortname;
    }

    public String getDiagnosisdescription() {
        return diagnosisdescription;
    }

}
