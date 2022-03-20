package com.relationships.dojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.relationships.dojo.models.Dojo;
import com.relationships.dojo.repositories.DojoRepo;

@Service
public class DojoServ {
	
private final DojoRepo dojoRepo;
	 
	 public DojoServ(DojoRepo dojoRepo) {
	     this.dojoRepo = dojoRepo;
	 }
	 
	 public List<Dojo> allDojos() {
	     return dojoRepo.findAll();
	 }
	 
	 public Dojo createDojo(Dojo b) {
	     return dojoRepo.save(b);
	 }
	 
	 public Dojo findDojo(Long id) {
	     Optional<Dojo> optionalDojo = dojoRepo.findById(id);
	     if(optionalDojo.isPresent()) {
	         return optionalDojo.get();
	     } else {
	         return null;
	     }
	 }
	
}
