package com.relationships.dojo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.relationships.dojo.models.Dojo;
import com.relationships.dojo.models.Ninja;
import com.relationships.dojo.services.DojoServ;
import com.relationships.dojo.services.NinjaServ;

@Controller
public class mainCont {
    
	@Autowired
	DojoServ dojoServ;
	@Autowired
	NinjaServ ninjaServ;
	
	@GetMapping("/")
	public String start() {
		return "welcome.jsp";	
	}
    
    @GetMapping("/dojos/new")
    public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
        return "newDojo.jsp"; 
    }
    
    
    @PostMapping("/dojos/new")
    public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
        if (result.hasErrors()) {
            return "newDojo.jsp";
        } else {
        	dojoServ.createDojo(dojo);
        	return "redirect:/dojos/new";
        }
    }
    
    @GetMapping("/ninjas/new")
    public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
        model.addAttribute("allDojos", dojoServ.allDojos());
    	return "newNinja.jsp"; 
    }
    
    
    @PostMapping("/ninjas/new")
    public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
        if (result.hasErrors()) {
            return "newNinja.jsp";
        } else {
        	ninjaServ.createNinja(ninja);
        	return "redirect:/dojos/"+ninja.getDojo().getId();
        }
    }
    @GetMapping ("/dojos/{dojo_id}")
    public String showNinjas(@PathVariable("dojo_id") Long id, Model model){
    	Dojo myDojo = dojoServ.findDojo(id);
    	model.addAttribute("dojo", myDojo);
    	return "dojoNinjas.jsp";
    	
    }
    
    
}
