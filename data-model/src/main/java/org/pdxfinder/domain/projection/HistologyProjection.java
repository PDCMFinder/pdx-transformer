package org.pdxfinder.domain.projection;

public interface HistologyProjection {

    String getHistologyseqnbr();
    String getSampleSeqnbr();
    String getTumorGradeSeqNbr();
    String getTumorContent();

    String getNecrosis();
    String getStromal();
    String getInflammatoryCellSeqNbr();
    String getPathologyNotes();
    String getLowMagImageMimeType();
    String getLowMagImageFileName();
    String getHighMagImageFileName();

}
