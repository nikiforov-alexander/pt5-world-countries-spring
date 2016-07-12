package com.teamtreehouse.countries.data;

import com.teamtreehouse.countries.model.Country;
import com.teamtreehouse.countries.model.Country.CountryBuilder;
import org.springframework.stereotype.Component;

import java.util.*;

@Component // with this we can use @Autowired later
public class CountryRepository {
    private static final List<Country> ALL_COUNTRIES = Arrays.asList(
            new CountryBuilder(1)
                    .withName("France")
                    .withCapital("Paris")
                    .withPopulation(66710000L)
                    .withFlagFileName("france.png")
                    .withLanguages(Arrays.asList("French"))
                    .build(),
            new CountryBuilder(2)
                    .withName("Ecuador")
                    .withCapital("Quito")
                    .withPopulation(1614400L)
                    .withFlagFileName("ecuador.png")
                    .withLanguages(Arrays.asList("Spanish"))
                    .build(),
            new CountryBuilder(3)
                    .withName("India")
                    .withCapital("New Delhi")
                    .withPopulation(1293057000L)
                    .withFlagFileName("india.png")
                    .withLanguages(Arrays.asList("Hindi", "English"))
                    .build(),
            new CountryBuilder(4)
                    .withName("Italy")
                    .withCapital("Rome")
                    .withPopulation(60674003L)
                    .withFlagFileName("italy.png")
                    .withLanguages(Arrays.asList("Italian"))
                    .build(),
            new CountryBuilder(5)
                    .withName("Kenya")
                    .withCapital("Nairobi")
                    .withPopulation(45010056L)
                    .withFlagFileName("kenya.png")
                    .withLanguages(Arrays.asList("English", "Kishwahili"))
                    .build()
    );

    public List<Country> findAll() {
        return ALL_COUNTRIES;
    }

    public Country findById(int id) {
        return ALL_COUNTRIES.stream()
                .filter(country -> country.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // sort countries in descending order A-Z
    public List<Country> sortCountriesByName() {
        List<Country> listOfCountriesSortedByName =
                new ArrayList<>(ALL_COUNTRIES);
        listOfCountriesSortedByName.sort(
                (c1,c2) -> c1.getName().compareToIgnoreCase(c2.getName())
        );
        return listOfCountriesSortedByName;
    }

    // sort countries in ascending order 1-9
    public List<Country> sortCountriesByPopulation() {
        List<Country> listOfCountriesSortedByName =
                new ArrayList<>(ALL_COUNTRIES);
        listOfCountriesSortedByName.sort(
                (c1,c2) -> c2.getPopulation().compareTo(c1.getPopulation())
        );
        return listOfCountriesSortedByName;
    }
}
