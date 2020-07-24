package org.pdxfinder.data.model.repository;

import org.pdxfinder.data.model.TumorGrades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TumorGradesRepo extends JpaRepository<TumorGrades, Integer> {

}

