package org.pdxfinder;

import javax.persistence.*;

@Entity
@Table(name = "Tissuetypes")
public class TissueTypes {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tissuetype_Sequence")
  @SequenceGenerator(name = "tissuetypeSequence", sequenceName = "TISSUETYPE_SEQ")
  private String tissuetypeseqnbr;

  private String tissuetypeshortname;
  private String tissuetypedescription;


  public String getTissuetypeseqnbr() {
    return tissuetypeseqnbr;
  }

  public void setTissuetypeseqnbr(String tissuetypeseqnbr) {
    this.tissuetypeseqnbr = tissuetypeseqnbr;
  }


  public String getTissuetypeshortname() {
    return tissuetypeshortname;
  }

  public void setTissuetypeshortname(String tissuetypeshortname) {
    this.tissuetypeshortname = tissuetypeshortname;
  }


  public String getTissuetypedescription() {
    return tissuetypedescription;
  }

  public void setTissuetypedescription(String tissuetypedescription) {
    this.tissuetypedescription = tissuetypedescription;
  }

}
