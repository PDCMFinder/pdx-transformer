package org.pdxfinder.repository;

import org.pdxfinder.domain.SpecimenSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecimenSearchrepo extends JpaRepository<SpecimenSearch, Integer> {

}
