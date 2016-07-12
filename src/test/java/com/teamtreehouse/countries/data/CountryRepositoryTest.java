package com.teamtreehouse.countries.data;

import com.teamtreehouse.countries.model.Country;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CountryRepositoryTest {

    private CountryRepository mCountryRepository;

    @Before
    public void setUp() throws Exception {
        mCountryRepository =
                new CountryRepository();
    }

    @Test
    public void countriesAreCorrectlySortedByName() throws Exception {
        // Given Country repository
        // When repository is sorted by name
        List<Country> sortedList =
                mCountryRepository.sortCountriesByName();
        // Then first country in the list should be less or equal than second
        Country country1 = sortedList.get(1);
        Country country2 = sortedList.get(2);
        int comparisonInteger =
                country1.getName().compareTo(country2.getName());
        assertTrue(comparisonInteger <= 0);
    }

    @Test
    public void countriesAreCorrectlySortedByPopulation() throws Exception {
        // Given Country repository
        // When repository is sorted by population
        List<Country> sortedList =
                mCountryRepository.sortCountriesByPopulation();
        // Then first country in the list should be more or equal than second
        Country country1 = sortedList.get(1);
        Country country2 = sortedList.get(2);
        int comparisonInteger =
                country1.getPopulation().compareTo(country2.getPopulation());
        assertTrue(comparisonInteger >= 0);
    }
}