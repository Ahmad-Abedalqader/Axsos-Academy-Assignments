package com.queriesandjoins.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.queriesandjoins.models.Country;
import com.queriesandjoins.repositories.CityRepo;
import com.queriesandjoins.repositories.CountryRepo;
import com.queriesandjoins.repositories.LanguageRepo;

@Service
public class ApiService {

	@Autowired
	private CountryRepo countryRepo;
	@Autowired
	private CityRepo cityRepo;
	@Autowired
	private LanguageRepo langRepo;
	
	public List<Country> allCities() {
	    return countryRepo.findAll();
	}
	
	//#1
	public List<Object[]> countriesSpeaksSlovene() {
	    return countryRepo.countriesSpeaksSlovene();
	}
	
	//#2
	public List<Object[]> numberOfCities() {
	    return cityRepo.numOfCities();
	}
	
	//#3
	public List<Object[]> cityInMexico() {
	    return cityRepo.citiesInMexico();
	}
	
	
	//#4
	public List<Object[]> countryLang() {
	    return langRepo.countryLanguage();
	}
	
	//#5
	public List<Object[]> surfaceArea() {
	    return countryRepo.sarfaceAreaAndPop();
	}
	
	//#6
	public List<Object[]> constitutionalMonarchy() {
	    return countryRepo.constitutionalMon();
	}
	
	//#7
	public List<Object[]> argentinaCitiesBuenos() {
	    return cityRepo.argentinaCities();
	}
	
	//#8
	public List<Object[]> countryRegion() {
	    return countryRepo.numOfCountriesInRegion();
	}
	
	
	
	
	

}

