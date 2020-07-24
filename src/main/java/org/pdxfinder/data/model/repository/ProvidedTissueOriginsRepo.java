package org.pdxfinder.data.model.repository;

import org.pdxfinder.data.model.ProvidedTissueOrigins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvidedTissueOriginsRepo extends JpaRepository<ProvidedTissueOrigins, Integer> {

}
