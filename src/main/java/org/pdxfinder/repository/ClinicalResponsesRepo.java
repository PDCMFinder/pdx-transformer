package org.pdxfinder.repository;

import org.pdxfinder.domain.ClinicalResponses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicalResponsesRepo extends JpaRepository<ClinicalResponses, Integer> {

}