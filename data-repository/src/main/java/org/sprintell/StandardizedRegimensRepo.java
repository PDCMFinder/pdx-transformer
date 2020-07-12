package org.sprintell;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.pdxfinder.StandardizedRegimens;

@Repository
public interface StandardizedRegimensRepo extends JpaRepository<StandardizedRegimens, Integer> {

}
