package com.queriesandjoins.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.queriesandjoins.models.Country;

@Repository
public interface CountryRepo extends CrudRepository<Country, Long>{
	List<Country> findAll();
	
	@Query("SELECT c.name, l.language, l.percentage FROM Country c JOIN c.languages l WHERE l.language='Slovene' ORDER BY l.percentage DESC")
	List<Object[]> countriesSpeaksSlovene();
	
	@Query("SELECT c.name, c.surface_area, c.population FROM Country c  WHERE c.surface_area < 501 AND c.population >100000")
	List<Object[]> sarfaceAreaAndPop();

	@Query("SELECT c.name, c.government_form, c.surface_area, c.life_expectancy FROM Country c  WHERE c.government_form='Constitutional Monarchy' AND c.surface_area>200 AND c.life_expectancy>75")
	List<Object[]> constitutionalMon();

	@Query("SELECT c.region, COUNT(c) FROM Country c GROUP BY c.region ORDER BY COUNT(c) DESC")
	List<Object[]> numOfCountriesInRegion();

}