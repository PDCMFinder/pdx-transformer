package org.sprintell;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.pdxfinder.CurrentTherapy;

@Repository
public interface CurrentTherapyRepo extends JpaRepository<CurrentTherapy, Integer> {

}
