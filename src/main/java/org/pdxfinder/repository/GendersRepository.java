package org.pdxfinder.repository;

import org.pdxfinder.domain.Genders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GendersRepository extends JpaRepository<Genders, Integer> {

    Optional<Genders> findByGenderSeqnbr(Integer seqNumber);

}
