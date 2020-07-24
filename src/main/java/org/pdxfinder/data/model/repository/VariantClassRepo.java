package org.pdxfinder.data.model.repository;

import org.pdxfinder.data.model.VariantClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VariantClassRepo extends JpaRepository<VariantClass, Integer> {
}
