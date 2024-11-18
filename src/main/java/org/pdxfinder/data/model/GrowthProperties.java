package org.pdxfinder.data.model;
import javax.persistence.*;

@Entity
@Table(name = "Growthproperties")
public class GrowthProperties {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "growthpropertyseqnbr_Sequence")
    @SequenceGenerator(name = "growthpropertyseqnbr_Sequence", sequenceName = "Growthproperties_SEQ")
    private String growthpropertyseqnbr;
    private String growthpropertydescription;


    public String getGrowthpropertyseqnbr(){ return growthpropertyseqnbr;}

    public String getGrowthpropertydescription(){ return growthpropertydescription;}

}

