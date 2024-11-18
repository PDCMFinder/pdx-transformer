package org.pdxfinder.data.model;
import javax.persistence.*;

@Entity
@Table(name = "REQUIREDMEDIA")
public class RequiredMedia {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "requiredmediaseqnbr_Sequence")
    @SequenceGenerator(name = "requiredmediaseqnbr_Sequence", sequenceName = "RequiredMedia_SEQ")
    private String requiredmediaseqnbr;
    private String requiredmediadescription;


    public String getRequiredmediaseqnbr(){ return requiredmediaseqnbr;}

    public String getRequiredmediadescription(){ return requiredmediadescription;}

}

