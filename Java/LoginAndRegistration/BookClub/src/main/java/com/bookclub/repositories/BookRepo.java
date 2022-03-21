package com.bookclub.repositories;



import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bookclub.models.Book;

public interface BookRepo extends CrudRepository<Book, Long> {
	
    // this method retrieves all the books from the database
    List<Book> findAll();


}
