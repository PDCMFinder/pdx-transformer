package org.pdxfinder;

import javax.persistence.*;

@Entity
@Table(name = "Mousestrains")
public class MouseStrains {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mousestrain_Sequence")
  @SequenceGenerator(name = "mousestrain_Sequence", sequenceName = "MOUSESTRAIN_SEQ")
  private String mousestrainseqnbr;

  private String mousestraindescript;


  public String getMousestrainseqnbr() {
    return mousestrainseqnbr;
  }

  public String getMousestraindescript() {
    return mousestraindescript;
  }

}
