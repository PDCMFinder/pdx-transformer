package org.pdxfinder.data.model.repository;

import org.pdxfinder.data.model.ClinicalResponses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicalResponsesRepo extends JpaRepository<ClinicalResponses, Integer> {

}