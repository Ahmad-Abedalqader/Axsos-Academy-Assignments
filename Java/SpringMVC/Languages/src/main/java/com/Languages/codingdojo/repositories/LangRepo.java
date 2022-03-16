package com.Languages.codingdojo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Languages.codingdojo.models.Language;

@Repository
public interface LangRepo extends CrudRepository<Language, Long> {
    // this method retrieves all the books from the database
    List<Language> findAll(); 
}