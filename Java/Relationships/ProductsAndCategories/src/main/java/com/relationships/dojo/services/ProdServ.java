package com.relationships.dojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.relationships.dojo.models.Category;
import com.relationships.dojo.models.Product;
import com.relationships.dojo.repositories.ProdRepo;

@Service
public class ProdServ {
	
private final ProdRepo prodRepo;
	 
	 public ProdServ(ProdRepo prodRepo) {
	     this.prodRepo = prodRepo;
	 }
	 
	 public List<Product> allProducts() {
	     return prodRepo.findAll();
	 }
	 
	 public Product createProduct(Product b) {
	     return prodRepo.save(b);
	 }
	 
	 public Product findProduct(Long id) {
	     Optional<Product> optionalProduct = prodRepo.findById(id);
	     if(optionalProduct.isPresent()) {
	         return optionalProduct.get();
	     } else {
	         return null;
	     }
	 }
	 
	 public List<Product> allCategNotContain(Category categ) {
	     return prodRepo.findByCategoriesNotContains(categ);
	 }
	
}
