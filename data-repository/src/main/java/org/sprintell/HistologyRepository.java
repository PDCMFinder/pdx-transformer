package org.sprintell;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.pdxfinder.Histology;

import java.util.List;
import java.util.Optional;

@Repository
public interface HistologyRepository extends JpaRepository<Histology, Integer> {

    Optional<Histology> findByHistologyseqnbr(String seqNumber);

    @Query("SELECT his.histologyseqnbr, his.sampleseqnbr, his.tumorgradeseqnbr, his.tumorcontent, his.necrosis, " +
            "his.stromal, his.inflammatorycellseqnbr, his.pathologynotes, his.lowmagimagemimetype, his.lowmagimagefilename, his.highmagimagefilename from Histology his")
    List<Object[]> findAllHistology();


}
