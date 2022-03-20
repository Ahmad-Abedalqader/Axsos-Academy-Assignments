package com.lookify.dojo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lookify.dojo.models.Lookify;


public interface LookifyRepo extends CrudRepository<Lookify, Long> {
	List<Lookify> findAll();
	List<Lookify> findByArtistContaining(String artist);
	List<Lookify> findTop10ByOrderByRatingDesc();
}
