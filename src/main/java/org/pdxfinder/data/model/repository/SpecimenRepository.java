package org.pdxfinder.data.model.repository;

import org.pdxfinder.data.model.Specimen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecimenRepository extends JpaRepository<Specimen, Integer> {

}

