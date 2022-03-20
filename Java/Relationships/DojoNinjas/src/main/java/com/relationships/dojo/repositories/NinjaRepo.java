package com.relationships.dojo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.relationships.dojo.models.Ninja;

public interface NinjaRepo extends CrudRepository<Ninja, Long> {
	List<Ninja> findAll();
}
