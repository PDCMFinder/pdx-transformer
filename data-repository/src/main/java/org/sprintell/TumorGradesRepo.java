package org.sprintell;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.pdxfinder.TumorGrades;

@Repository
public interface TumorGradesRepo extends JpaRepository<TumorGrades, Integer> {

}

