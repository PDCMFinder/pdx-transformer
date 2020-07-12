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

    public Histology setHistologyseqnbr(String histologyseqnbr) {
        this.histologyseqnbr = histologyseqnbr;
        return this;
    }

    public String getSampleSeqnbr() {
        return sampleSeqnbr;
    }

    public Histology setSampleSeqnbr(String sampleSeqnbr) {
        this.sampleSeqnbr = sampleSeqnbr;
        return this;
    }


    public String getTumorGradeSeqNbr() {
        return tumorGradeSeqNbr;
    }

    public Histology setTumorGradeSeqNbr(String tumorGradeSeqNbr) {
        this.tumorGradeSeqNbr = tumorGradeSeqNbr;
        return this;
    }


    public String getTumorContent() {
        return tumorContent;
    }

    public Histology setTumorContent(String tumorContent) {
        this.tumorContent = tumorContent;
        return this;
    }

    public String getNecrosis() {
        return necrosis;
    }

    public Histology setNecrosis(String necrosis) {
        this.necrosis = necrosis;
        return this;
    }


    public String getStromal() {
        return stromal;
    }

    public Histology setStromal(String stromal) {
        this.stromal = stromal;
        return this;
    }


    public String getInflammatoryCellSeqNbr() {
        return inflammatoryCellSeqNbr;
    }

    public Histology setInflammatoryCellSeqNbr(String inflammatorycellseqnbr) {
        this.inflammatoryCellSeqNbr = inflammatorycellseqnbr;
        return this;
    }

    public String getPathologyNotes() {
        return pathologyNotes;
    }

    public Histology setPathologyNotes(String pathologynotes) {
        this.pathologyNotes = pathologynotes;
        return this;
    }

    public byte[] getLowMagImage() {
        return lowMagImage;
    }

    public Histology setLowMagImage(byte[] lowmagimage) {
        this.lowMagImage = lowmagimage;
        return this;
    }


    public String getLowMagImageMimeType() {
        return lowMagImageMimeType;
    }

    public Histology setLowMagImageMimeType(String lowmagimagemimetype) {
        this.lowMagImageMimeType = lowmagimagemimetype;
        return this;
    }


    public String getLowMagImageFileName() {
        return lowMagImageFileName;
    }

    public Histology setLowMagImageFileName(String lowmagimagefilename) {
        this.lowMagImageFileName = lowmagimagefilename;
        return this;
    }


    public byte[] getHighMagImage() {
        return highMagImage;
    }

    public Histology setHighMagImage(byte[] highmagimage) {
        this.highMagImage = highmagimage;
        return this;
    }


    public String getHighMagImageMimeType() {
        return highMagImageMimeType;
    }

    public Histology setHighMagImageMimeType(String highmagimagemimetype) {
        this.highMagImageMimeType = highmagimagemimetype;
        return this;
    }


    public String getHighMagImageFileName() {
        return highMagImageFileName;
    }

    public Histology setHighMagImageFileName(String highmagimagefilename) {
        this.highMagImageFileName = highmagimagefilename;
        return this;
    }

}
