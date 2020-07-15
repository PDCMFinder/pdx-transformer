package org.pdxfinder.repository;

import org.pdxfinder.domain.MouseStrains;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MouseStrainsRepo extends JpaRepository<MouseStrains, Integer> {

}
