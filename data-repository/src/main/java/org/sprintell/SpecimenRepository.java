package org.sprintell;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.pdxfinder.Specimen;

@Repository
public interface SpecimenRepository extends JpaRepository<Specimen, Integer> {

}

