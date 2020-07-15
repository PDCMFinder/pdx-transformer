package org.pdxfinder.repository;

import org.pdxfinder.domain.omic.VariantClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VariantClassRepo extends JpaRepository<VariantClass, Integer> {
}
