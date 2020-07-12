package org.sprintell;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.pdxfinder.TissueTypes;

@Repository
public interface TissueTypesRepo extends JpaRepository<TissueTypes, Integer> {

}

