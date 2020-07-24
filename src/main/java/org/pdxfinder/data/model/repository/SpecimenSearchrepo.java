package org.pdxfinder.data.model.repository;

import org.pdxfinder.data.model.SpecimenSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecimenSearchrepo extends JpaRepository<SpecimenSearch, Integer> {

}
