package org.sprintell;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.pdxfinder.TumorGradeStageTypes;

@Repository
public interface TumorGradeStageTypesRepo extends JpaRepository<TumorGradeStageTypes, Integer> {

}
