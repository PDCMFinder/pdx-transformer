package org.pdxfinder.repository;

import org.pdxfinder.domain.Histology;
import org.pdxfinder.projection.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HistologyRepository extends JpaRepository<Histology, Integer> {

    Optional<Histology> findByHistologyseqnbr(String seqNumber);

    @Query("SELECT his.histologyseqnbr as histologyseqnbr, his.sampleSeqnbr as sampleSeqnbr, " +
            " his.tumorGradeSeqNbr as tumorGradeSeqNbr, his.tumorContent as tumorContent, his.necrosis as necrosis, " +
            " his.stromal as stromal, his.inflammatoryCellSeqNbr as inflammatoryCellSeqNbr, his.pathologyNotes as pathologyNotes, " +
            " his.lowMagImageMimeType as lowMagImageMimeType, his.lowMagImageFileName as lowMagImageFileName, " +
            " his.highMagImageFileName as highMagImageFileName from Histology his")
    List<HistologyProjection> findAllHistology();

}
