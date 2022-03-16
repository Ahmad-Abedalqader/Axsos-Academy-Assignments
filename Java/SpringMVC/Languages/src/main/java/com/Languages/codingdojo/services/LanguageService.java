package com.Languages.codingdojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Languages.codingdojo.models.Language;
import com.Languages.codingdojo.repositories.LangRepo;

@Service
public class LanguageService {
 // adding the Expense repository as a dependency
	private final LangRepo langRepo;
 
 public LanguageService(LangRepo langRepo) {
     this.langRepo = langRepo;
 }
 // returns all the Expenses
 public List<Language> allLanguages() {
     return langRepo.findAll();
 }
 // creates a Expense
 public Language createLanguage(Language b) {
     return langRepo.save(b);
 }
 // retrieves a Expense
 public Language findLanguage(Long id) {
     Optional<Language> optionalLanguage = langRepo.findById(id);
     if(optionalLanguage.isPresent()) {
         return optionalLanguage.get();
     } else {
         return null;
     }
 }
public Language updateLanguage(Language language) {
	return langRepo.save(language);
}
public void deleteLanguage(Long id) {
	Language language = findLanguage(id);
	if (language != null) {
		langRepo.deleteById(id);
	}
	
	
}
}

