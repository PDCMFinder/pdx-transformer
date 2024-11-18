package org.pdxfinder.data.model.repository;

import org.pdxfinder.data.model.RequiredMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RequiredMediaRepo extends JpaRepository<RequiredMedia, Integer> {

}
