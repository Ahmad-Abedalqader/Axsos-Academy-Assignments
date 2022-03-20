package com.relationships.dojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.relationships.dojo.models.Category;
import com.relationships.dojo.models.Product;
import com.relationships.dojo.repositories.CategRepo;

@Service
public class CategServ {
	private final CategRepo categRepo;
	 
	 public CategServ(CategRepo categRepo) {
	     this.categRepo = categRepo;
	 }
	 
	 public List<Category> allCategs() {
	     return categRepo.findAll();
	 }
	 
	 public Category createCateg(Category b) {
	     return categRepo.save(b);
	 }
	 
	 public Category findCateg(Long id) {
	     Optional<Category> optionalCateg = categRepo.findById(id);
	     if(optionalCateg.isPresent()) {
	         return optionalCateg.get();
	     } else {
	         return null;
	     }
	 }
	 
	 public List<Category> allCategNotContain(Product product) {
	     return categRepo.findByProductsNotContains(product);
	 }
	 public void associate(Product thisProduct, Category thisCategory) {
	    	thisProduct.getCategories().add(thisCategory);
	    	categRepo.save(thisCategory);
	 }
	 
	 
}
