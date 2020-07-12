package org.pdxfinder.projection;

public interface HistologyProjection {

    String getHistologyseqnbr();
    String getSampleseqnbr();
    String getTumorgradeseqnbr();
    String getTumorcontent();

    String getNecrosis();
    String getStromal();
    String getInflammatorycellseqnbr();
    String getPathologynotes();
    String getLowmagimagemimetype();
    String getLowmagimagefilename();
    String getHighmagimagefilename();
}
