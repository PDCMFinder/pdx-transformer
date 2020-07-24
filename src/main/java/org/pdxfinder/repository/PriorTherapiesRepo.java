package org.pdxfinder.repository;

import org.pdxfinder.domain.PriorTherapies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriorTherapiesRepo extends JpaRepository<PriorTherapies, Integer> {

}
