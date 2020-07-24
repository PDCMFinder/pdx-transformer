package org.pdxfinder.data.model.repository;

import org.pdxfinder.data.model.CurrentTherapy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentTherapyRepo extends JpaRepository<CurrentTherapy, Integer> {

}
