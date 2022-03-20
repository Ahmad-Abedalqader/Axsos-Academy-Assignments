package com.lookify.dojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lookify.dojo.models.Lookify;
import com.lookify.dojo.repositories.LookifyRepo;

@Service
public class LookifyService {
 // adding the Expense repository as a dependency
	private final LookifyRepo lookifyRepo;
 
 public LookifyService(LookifyRepo lookifyRepo) {
     this.lookifyRepo = lookifyRepo;
 }
 // returns all the Expenses
 public List<Lookify> allSongs() {
     return lookifyRepo.findAll();
 }
 // creates a Expense
 public Lookify addSong(Lookify b) {
     return lookifyRepo.save(b);
 }
 // retrieves a Expense
 public Lookify findSong(Long id) {
     Optional<Lookify> optionalSong = lookifyRepo.findById(id);
     if(optionalSong.isPresent()) {
         return optionalSong.get();
     } else {
         return null;
     }
 }
public Lookify updateSong(Lookify song) {
	return lookifyRepo.save(song);
}
public void deleteSong(Long id) {
	Lookify song = findSong(id);
	if (song != null) {
		lookifyRepo.deleteById(id);
	}
		
}

public List<Lookify> search (String artist) {
	List<Lookify> artistSongs = lookifyRepo.findByArtistContaining(artist);
        return artistSongs;
}

public List<Lookify> topTen() {
	List<Lookify> topTen = lookifyRepo.findTop10ByOrderByRatingDesc();
	return topTen;
}
}

