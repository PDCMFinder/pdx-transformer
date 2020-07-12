package org.pdxfinder;

import javax.persistence.*;

@Entity
public class Genders {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "genders_Sequence")
    @SequenceGenerator(name = "genders_Sequence", sequenceName = "GENDERS_SEQ")
    @Column(name = "GENDERSEQNBR")
    private Integer genderSeqnbr;

    @Column(name = "GENDERSHORTNAME")
    private String genderShortName;

    @Column(name = "GENDERDESCRIPTION")
    private String genderDescription;

    public Genders() {
    }

    public Genders(String genderShortName, String genderDescription) {
        this.genderShortName = genderShortName;
        this.genderDescription = genderDescription;
    }

    public Integer getGenderSeqnbr() {
        return genderSeqnbr;
    }

    public void setGenderSeqnbr(Integer genderSeqnbr) {
        this.genderSeqnbr = genderSeqnbr;
    }

    public String getGenderShortName() {
        return genderShortName;
    }

    public void setGenderShortName(String genderShortName) {
        this.genderShortName = genderShortName;
    }

    public String getGenderDescription() {
        return genderDescription;
    }

    public void setGenderDescription(String genderDescription) {
        this.genderDescription = genderDescription;
    }
}
