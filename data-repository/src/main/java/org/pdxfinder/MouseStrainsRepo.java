package org.pdxfinder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MouseStrainsRepo extends JpaRepository<MouseStrains, Integer> {

}
