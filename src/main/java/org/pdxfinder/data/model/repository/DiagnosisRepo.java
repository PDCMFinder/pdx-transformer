package org.pdxfinder.data.model.repository;

import org.pdxfinder.data.model.Diagnoses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosisRepo extends JpaRepository<Diagnoses, Integer> {

}

