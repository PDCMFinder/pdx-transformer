package org.pdxfinder.data.model.repository;

import org.pdxfinder.data.model.GrowthProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GrowthPropertiesRepo extends JpaRepository<GrowthProperties, Integer> {

}
