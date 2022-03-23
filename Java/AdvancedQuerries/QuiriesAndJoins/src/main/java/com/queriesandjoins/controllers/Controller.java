package com.queriesandjoins.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.queriesandjoins.services.ApiService;

@RestController
public class Controller {
	
	@Autowired
	private ApiService apiServ;
	
    @RequestMapping("/")
	public List<Object[]> index() {
	    return apiServ.countryRegion();
	}
    
    
}
