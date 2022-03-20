package com.relationships.dojo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.relationships.dojo.models.Dojo;

public interface DojoRepo extends CrudRepository<Dojo, Long> {
	List<Dojo> findAll();

}
