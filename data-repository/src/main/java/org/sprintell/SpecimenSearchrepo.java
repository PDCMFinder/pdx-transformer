package org.sprintell;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.pdxfinder.SpecimenSearch;

@Repository
public interface SpecimenSearchrepo extends JpaRepository<SpecimenSearch, Integer> {

}
