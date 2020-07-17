package org.pdxfinder.repository;

import org.pdxfinder.domain.TumorGrades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TumorGradesRepo extends JpaRepository<TumorGrades, Integer> {

}

