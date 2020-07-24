package org.pdxfinder.data.model.repository;

import org.pdxfinder.data.model.StandardizedRegimens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StandardizedRegimensRepo extends JpaRepository<StandardizedRegimens, Integer> {

}
