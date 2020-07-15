package org.pdxfinder.repository;

import org.pdxfinder.domain.TissueTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TissueTypesRepo extends JpaRepository<TissueTypes, Integer> {

}

