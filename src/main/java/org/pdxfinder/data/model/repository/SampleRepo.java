package org.pdxfinder.data.model.repository;

import org.pdxfinder.data.model.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleRepo extends JpaRepository<Sample, Integer> {

}
