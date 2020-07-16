package org.pdxfinder.repository;

import org.pdxfinder.domain.HugoGeneSymbol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HugoGeneSymbolRepo extends JpaRepository<HugoGeneSymbol, Integer> {
}
