package com.queriesandjoins.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.queriesandjoins.models.City;

@Repository
public interface CityRepo extends CrudRepository<City, Long>{
	
	@Query("SELECT co.name, COUNT(c) FROM City c JOIN c.country co GROUP BY co ORDER BY COUNT(c) DESC")
	List<Object[]> numOfCities();
	
	@Query("SELECT c.name, co.name, c.population FROM City c JOIN c.country co WHERE co.name='Mexico' AND c.population > 500000 ORDER BY c.population DESC")
	List<Object[]> citiesInMexico();

	@Query("SELECT co.name,c.name, c.district, c.population FROM City c JOIN c.country co WHERE co.name='Argentina' AND c.district='Buenos Aires' AND c.population > 500000")
	List<Object[]> argentinaCities();

	

	
}