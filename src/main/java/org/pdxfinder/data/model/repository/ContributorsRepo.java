package org.pdxfinder.data.model.repository;

import org.pdxfinder.data.model.Contributors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContributorsRepo extends JpaRepository<Contributors, Integer> {

}
