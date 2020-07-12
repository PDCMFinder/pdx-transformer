package org.sprintell;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.pdxfinder.ProvidedTissueOrigins;

@Repository
public interface ProvidedTissueOriginsRepo extends JpaRepository<ProvidedTissueOrigins, Integer> {

}
