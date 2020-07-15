package org.pdxfinder.repository;

import org.pdxfinder.domain.PatientInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientInfoRepo extends JpaRepository<PatientInfo, Integer> {

}