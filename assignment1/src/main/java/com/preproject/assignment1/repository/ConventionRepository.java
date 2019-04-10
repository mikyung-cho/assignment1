
package com.preproject.assignment1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.preproject.assignment1.domain.Convention;

public interface ConventionRepository extends JpaRepository<Convention, String> {

	Optional<Convention> findByRegionNm(String regionNm);
	
}
