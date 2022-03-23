package com.projectmanager.repositories;



import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.projectmanager.models.Project;

public interface ProjectRepo extends CrudRepository<Project, Long> {
	
    // this method retrieves all the books from the database
    List<Project> findAll();
    Optional<Project> findById(Long id);


}
