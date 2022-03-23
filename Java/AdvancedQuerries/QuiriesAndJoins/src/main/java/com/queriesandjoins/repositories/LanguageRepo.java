package com.queriesandjoins.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.queriesandjoins.models.Language;

@Repository
public interface LanguageRepo extends CrudRepository<Language, Long>{

	@Query("SELECT co.name, l.language, l.percentage FROM Language l JOIN l.country co WHERE l.percentage>89 ORDER BY l.percentage DESC")
	List<Object[]> countryLanguage();


}