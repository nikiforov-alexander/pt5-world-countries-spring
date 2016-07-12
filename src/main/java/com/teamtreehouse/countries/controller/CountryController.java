package com.teamtreehouse.countries.controller;

import com.teamtreehouse.countries.data.CountryRepository;
import com.teamtreehouse.countries.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CountryController {

    @Autowired
    private CountryRepository mCountryRepository;

    @RequestMapping("/")
    public String listCountries(ModelMap modelMap) {
        List<Country> countries = mCountryRepository.findAll();
        modelMap.put("countries", countries);
        return "index";
    }

    @RequestMapping(value = "/", params = "sort")
    public String sortByName(@RequestParam ("sort") String property,
            ModelMap modelMap) {
        List<Country> countries;
        switch (property) {
            case "name":
                countries = mCountryRepository.sortCountriesByName();
                break;
            case "population":
                countries = mCountryRepository.sortCountriesByPopulation();
                break;
            default:
                countries = mCountryRepository.findAll();
                break;
        }
        modelMap.put("countries", countries);
        return "index";
    }

    @RequestMapping("/country/{id}/{slugFromName}")
    public String countryDetails(
            @PathVariable("id") String id,
            @PathVariable("slugFromName") String slugFromName,
            ModelMap modelMap) {
        int parsedId = Integer.valueOf(id);
        Country country = mCountryRepository.findById(parsedId);
        modelMap.put("country", country);
        return "country-details";
    }
}
