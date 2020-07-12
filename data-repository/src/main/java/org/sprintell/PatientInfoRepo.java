package org.sprintell;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.pdxfinder.PatientInfo;

@Repository
public interface PatientInfoRepo extends JpaRepository<PatientInfo, Integer> {

}