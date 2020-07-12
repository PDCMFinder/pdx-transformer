package org.pdxfinder;

import javax.persistence.*;

@Entity
public class Histology {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "histology_Sequence")
    @SequenceGenerator(name = "histology_Sequence", sequenceName = "HISTOLOGY_SEQ")
    private String histologyseqnbr;

    private String sampleseqnbr;
    private String tumorgradeseqnbr;
    private String tumorcontent;
    private String necrosis;
    private String stromal;
    private String inflammatorycellseqnbr;
    private String pathologynotes;
    @Lob
    private byte[] lowmagimage;
    private String lowmagimagemimetype;
    private String lowmagimagefilename;
    @Lob
    private byte[] highmagimage;
    private String highmagimagemimetype;
    private String highmagimagefilename;


    public String getHistologyseqnbr() {
        return histologyseqnbr;
    }

    public Histology setHistologyseqnbr(String histologyseqnbr) {
        this.histologyseqnbr = histologyseqnbr;
        return this;
    }

    public String getSampleseqnbr() {
        return sampleseqnbr;
    }

    public Histology setSampleseqnbr(String sampleseqnbr) {
        this.sampleseqnbr = sampleseqnbr;
        return this;
    }


    public String getTumorgradeseqnbr() {
        return tumorgradeseqnbr;
    }

    public Histology setTumorgradeseqnbr(String tumorgradeseqnbr) {
        this.tumorgradeseqnbr = tumorgradeseqnbr;
        return this;
    }


    public String getTumorcontent() {
        return tumorcontent;
    }

    public Histology setTumorcontent(String tumorcontent) {
        this.tumorcontent = tumorcontent;
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


    public String getInflammatorycellseqnbr() {
        return inflammatorycellseqnbr;
    }

    public Histology setInflammatorycellseqnbr(String inflammatorycellseqnbr) {
        this.inflammatorycellseqnbr = inflammatorycellseqnbr;
        return this;
    }


    public String getPathologynotes() {
        return pathologynotes;
    }

    public Histology setPathologynotes(String pathologynotes) {
        this.pathologynotes = pathologynotes;
        return this;
    }


    public byte[] getLowmagimage() {
        return lowmagimage;
    }

    public Histology setLowmagimage(byte[] lowmagimage) {
        this.lowmagimage = lowmagimage;
        return this;
    }


    public String getLowmagimagemimetype() {
        return lowmagimagemimetype;
    }

    public Histology setLowmagimagemimetype(String lowmagimagemimetype) {
        this.lowmagimagemimetype = lowmagimagemimetype;
        return this;
    }


    public String getLowmagimagefilename() {
        return lowmagimagefilename;
    }

    public Histology setLowmagimagefilename(String lowmagimagefilename) {
        this.lowmagimagefilename = lowmagimagefilename;
        return this;
    }


    public byte[] getHighmagimage() {
        return highmagimage;
    }

    public Histology setHighmagimage(byte[] highmagimage) {
        this.highmagimage = highmagimage;
        return this;
    }


    public String getHighmagimagemimetype() {
        return highmagimagemimetype;
    }

    public Histology setHighmagimagemimetype(String highmagimagemimetype) {
        this.highmagimagemimetype = highmagimagemimetype;
        return this;
    }


    public String getHighmagimagefilename() {
        return highmagimagefilename;
    }

    public Histology setHighmagimagefilename(String highmagimagefilename) {
        this.highmagimagefilename = highmagimagefilename;
        return this;
    }

}
