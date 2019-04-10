
package com.preproject.assignment1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.preproject.assignment1.domain.Convention;

public interface ConventionRepository extends JpaRepository<Convention, String> {

	Optional<Convention> findByRegionNm(String regionNm);
	
	/*
	 * @Modifying
	 * 
	 * @Query(value="update convention c " + "set c.target = :#{#convention.target}"
	 * + ", c.usage = :#{#convention.usage}" + ", c.slimit = :#{#convention.limit}"
	 * + ", c.rate = :#{#convention.rate}" +
	 * ", c.institute = :#{#convention.institute}" +
	 * ", c.mgmt = :#{#convention.mgmt}" +
	 * ", c.reception = :#{#convention.reception}" +
	 * " WHERE c.regionCd = :#{#convention.regionCd}", nativeQuery = false) void
	 * update(@Param("convention") Convention convention);
	 */

	
}
