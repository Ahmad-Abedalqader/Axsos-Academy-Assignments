package com.relationships.dojo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.relationships.dojo.models.Category;
import com.relationships.dojo.models.Product;

public interface CategRepo extends CrudRepository<Category, Long> {
	List<Category> findAll();
	List<Category> findAllByProducts(Product product);
	List<Category> findByProductsNotContains(Product product);
}
