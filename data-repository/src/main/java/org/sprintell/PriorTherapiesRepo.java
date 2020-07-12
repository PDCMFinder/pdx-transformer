package org.sprintell;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.pdxfinder.PriorTherapies;

@Repository
public interface PriorTherapiesRepo extends JpaRepository<PriorTherapies, Integer> {

}
