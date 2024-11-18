package org.pdxfinder.data.model;
import javax.persistence.*;

@Entity
@Table(name = "Contributors")
public class Contributors {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contributorseqnbr_Sequence")
    @SequenceGenerator(name = "contributorseqnbr_Sequence", sequenceName = "contributors_SEQ")
    private String contributorseqnbr;
    private String contributorshortname;
    private String contributordescription;


    public String getContributorseqnbr(){ return contributorseqnbr;}

    public String getContributorshortname(){ return contributorshortname;}

    public String getContributordescription(){ return contributordescription;}


}

