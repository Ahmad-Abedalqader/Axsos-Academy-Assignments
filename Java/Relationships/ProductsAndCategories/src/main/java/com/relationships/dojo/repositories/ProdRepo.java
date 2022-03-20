package com.relationships.dojo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.relationships.dojo.models.Category;
import com.relationships.dojo.models.Product;

public interface ProdRepo extends CrudRepository<Product, Long> {
	List<Product> findAll();
	List<Product> findAllByCategories(Category category);
	List<Product> findByCategoriesNotContains(Category category);

}
