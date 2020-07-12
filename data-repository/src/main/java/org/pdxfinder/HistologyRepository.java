package org.pdxfinder;

import org.pdxfinder.projection.HistologyProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HistologyRepository extends JpaRepository<Histology, Integer> {

    Optional<Histology> findByHistologyseqnbr(String seqNumber);

    @Query("SELECT his.histologyseqnbr as histologyseqnbr, his.sampleseqnbr as sampleseqnbr, " +
            " his.tumorgradeseqnbr as tumorgradeseqnbr, his.tumorcontent as tumorcontent, his.necrosis as necrosis, " +
            " his.stromal as stromal, his.inflammatorycellseqnbr as inflammatorycellseqnbr, his.pathologynotes as pathologynotes, " +
            " his.lowmagimagemimetype as lowmagimagemimetype, his.lowmagimagefilename as lowmagimagefilename, " +
            " his.highmagimagefilename as highmagimagefilename from Histology his")
    List<HistologyProjection> findAllHistology();

}
