package org.pdxfinder.data.model.repository;

import org.pdxfinder.data.model.Diagnoses;
import org.pdxfinder.data.model.MedDRACodes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeddraRepo extends JpaRepository<MedDRACodes, Integer> {

}

