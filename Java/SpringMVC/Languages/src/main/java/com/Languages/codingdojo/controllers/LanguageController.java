package com.Languages.codingdojo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.Languages.codingdojo.models.Language;
import com.Languages.codingdojo.services.LanguageService;

@Controller
public class LanguageController {
    
	@Autowired
	LanguageService languageService;
    
    @GetMapping("/languages")
    public String index(Model model, @ModelAttribute("language") Language language) {
    	List<Language> alllanguages = languageService.allLanguages();
    	model.addAttribute("allLanguages", alllanguages);
        return "languages.jsp";
    }
    
    
    @PostMapping("/languages")
    public String showLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	List<Language> allLanguages = languageService.allLanguages();
        	model.addAttribute("allLanguages", allLanguages);
            return "languages.jsp";
        } else {
        	languageService.createLanguage(language);
        	return "redirect:/languages";
        }
    }
    
    @GetMapping("/languages/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Language language = languageService.findLanguage(id);
        model.addAttribute("language", language);
        return "edit.jsp";
    }
    
    @PutMapping("/languages/{id}")
    public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            languageService.updateLanguage(language);
            return "redirect:/languages";
        }
    }
    
    @DeleteMapping("/languages/{id}")
    public String destroy(@PathVariable("id") Long id) {
        languageService.deleteLanguage(id);
        return "redirect:/languages";
    }
    @GetMapping("/languages/{id}")
    public String index(@PathVariable("id") Long id, Model model) {
        model.addAttribute("language", languageService.findLanguage(id));
        return "langDetails.jsp";
    }
    
}
