package org.sprintell;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.pdxfinder.Genders;

import java.util.Optional;

@Repository
public interface GendersRepository extends JpaRepository<Genders, Integer> {

    Optional<Genders> findByGenderSeqnbr(Integer seqNumber);

}
