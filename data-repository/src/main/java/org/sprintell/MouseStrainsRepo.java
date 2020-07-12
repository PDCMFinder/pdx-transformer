package org.sprintell;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.pdxfinder.MouseStrains;

@Repository
public interface MouseStrainsRepo extends JpaRepository<MouseStrains, Integer> {

}
