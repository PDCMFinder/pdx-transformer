package org.pdxfinder.repository;

import org.pdxfinder.domain.TumorGradeStageTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TumorGradeStageTypesRepo extends JpaRepository<TumorGradeStageTypes, Integer> {

}
