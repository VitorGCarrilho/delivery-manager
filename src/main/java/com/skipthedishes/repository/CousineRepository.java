package com.skipthedishes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skipthedishes.domain.Cousine;

/**
 * @author Vitor Carrilho - 18/03/2018
 *
 */
@Repository
public interface CousineRepository extends JpaRepository<Cousine, Long> {
	Optional<Cousine> findByName(String name);
}
