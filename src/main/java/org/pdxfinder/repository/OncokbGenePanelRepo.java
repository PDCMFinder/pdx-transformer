package org.pdxfinder.repository;

import org.pdxfinder.domain.OncokbGenePanel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OncokbGenePanelRepo extends JpaRepository<OncokbGenePanel, Integer> {


}
