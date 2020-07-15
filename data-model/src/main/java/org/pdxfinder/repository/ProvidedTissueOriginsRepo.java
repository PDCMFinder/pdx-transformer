package org.pdxfinder.repository;

import org.pdxfinder.domain.ProvidedTissueOrigins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvidedTissueOriginsRepo extends JpaRepository<ProvidedTissueOrigins, Integer> {

}
