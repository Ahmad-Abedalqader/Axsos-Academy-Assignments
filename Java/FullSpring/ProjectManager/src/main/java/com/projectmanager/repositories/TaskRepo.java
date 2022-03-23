package com.projectmanager.repositories;



import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.projectmanager.models.Task;

public interface TaskRepo extends CrudRepository<Task, Long> {
	
    // this method retrieves all the books from the database
    List<Task> findAll();
    Optional<Task> findById(Long id);


}
