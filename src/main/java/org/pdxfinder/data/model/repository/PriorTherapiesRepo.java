package org.pdxfinder.data.model.repository;

import org.pdxfinder.data.model.PriorTherapies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriorTherapiesRepo extends JpaRepository<PriorTherapies, Integer> {

}
