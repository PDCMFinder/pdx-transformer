package org.pdxfinder.repository;

import org.pdxfinder.domain.ImplantationSites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImplantationSitesRepo extends JpaRepository<ImplantationSites, Integer> {

}