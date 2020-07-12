package org.sprintell;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.pdxfinder.Sample;

@Repository
public interface SampleRepo extends JpaRepository<Sample, Integer> {

}
