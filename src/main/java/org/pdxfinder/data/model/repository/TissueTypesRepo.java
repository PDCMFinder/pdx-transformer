package org.pdxfinder.data.model.repository;

import org.pdxfinder.data.model.TissueTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TissueTypesRepo extends JpaRepository<TissueTypes, Integer> {

}

