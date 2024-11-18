package org.pdxfinder.data.model.repository;

import org.pdxfinder.data.model.DistributionLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DistributionLotRepo extends JpaRepository<DistributionLot, Integer> {

}
