package com.relationships.dojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.relationships.dojo.models.Ninja;
import com.relationships.dojo.repositories.NinjaRepo;

@Service
public class NinjaServ {
	private final NinjaRepo ninjaRepo;
	 
	 public NinjaServ(NinjaRepo ninjaRepo) {
	     this.ninjaRepo = ninjaRepo;
	 }
	 
	 public List<Ninja> allNinjas() {
	     return ninjaRepo.findAll();
	 }
	 
	 public Ninja createNinja(Ninja b) {
	     return ninjaRepo.save(b);
	 }
	 
	 public Ninja findNinja(Long id) {
	     Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
	     if(optionalNinja.isPresent()) {
	         return optionalNinja.get();
	     } else {
	         return null;
	     }
	 }
	 
}
