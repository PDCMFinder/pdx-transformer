package org.pdxfinder.data.model.repository;

import org.pdxfinder.data.model.OncokbGenePanel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OncokbGenePanelRepo extends JpaRepository<OncokbGenePanel, Integer> {


}
