package org.pdxfinder;

import javax.persistence.*;

@Entity
public class Histology {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "histology_Sequence")
    @SequenceGenerator(name = "histology_Sequence", sequenceName = "HISTOLOGY_SEQ")
    private String histologyseqnbr;

    @Column(name = "sampleseqnbr")
    private String sampleSeqnbr;

    @Column(name = "tumorgradeseqnbr")
    private String tumorGradeSeqNbr;

    @Column(name = "tumorcontent")
    private String tumorContent;

    @Column(name = "necrosis")
    private String necrosis;

    @Column(name = "stromal")
    private String stromal;

    @Column(name = "inflammatorycellseqnbr")
    private String inflammatoryCellSeqNbr;

    @Column(name = "pathologynotes")
    private String pathologyNotes;

    @Lob
    @Column(name = "lowmagimage")
    private byte[] lowMagImage;

    @Column(name = "lowmagimagemimetype")
    private String lowMagImageMimeType;

    @Column(name = "lowmagimagefilename")
    private String lowMagImageFileName;

    @Lob
    @Column(name = "highmagimage")
    private byte[] highMagImage;

    @Column(name = "highmagimagemimetype")
    private String highMagImageMimeType;

    @Column(name = "highmagimagefilename")
    private String highMagImageFileName;


    public String getHistologyseqnbr() {
        return histologyseqnbr;
    }

    public String getSampleSeqnbr() {
        return sampleSeqnbr;
    }

    public String getTumorGradeSeqNbr() {
        return tumorGradeSeqNbr;
    }

    public String getTumorContent() {
        return tumorContent;
    }

    public String getNecrosis() {
        return necrosis;
    }

    public String getStromal() {
        return stromal;
    }

    public String getInflammatoryCellSeqNbr() {
        return inflammatoryCellSeqNbr;
    }

    public String getPathologyNotes() {
        return pathologyNotes;
    }

    public byte[] getLowMagImage() {
        return lowMagImage;
    }

    public String getLowMagImageMimeType() {
        return lowMagImageMimeType;
    }

    public String getLowMagImageFileName() {
        return lowMagImageFileName;
    }

    public byte[] getHighMagImage() {
        return highMagImage;
    }

    public String getHighMagImageMimeType() {
        return highMagImageMimeType;
    }

    public String getHighMagImageFileName() {
        return highMagImageFileName;
    }

}
