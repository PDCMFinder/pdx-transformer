package org.pdxfinder.data.model.repository;

import org.pdxfinder.data.model.HugoGeneSymbol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HugoGeneSymbolRepo extends JpaRepository<HugoGeneSymbol, Integer> {
}
