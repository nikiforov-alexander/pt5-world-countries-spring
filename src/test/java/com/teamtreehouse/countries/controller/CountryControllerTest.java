package com.teamtreehouse.countries.controller;

import com.teamtreehouse.countries.data.CountryRepository;
import com.teamtreehouse.countries.model.Country;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class CountryControllerTest {
    private MockMvc mockMvc;
    @InjectMocks
    private CountryController countryController;

    @Mock
    private CountryRepository countryRepository;

    private List<Country> mExampleListOfCounties;
    private List<Country> mExampleListOfCountiesSortedByName;
    private List<Country> mExampleListOfCountiesSortedByPopulation;
    private Country mFranceCountry;
    private Country mEcuadorCountry;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders
                .standaloneSetup(countryController)
                .build();
        // set couple of test countries
        mFranceCountry = new Country.CountryBuilder(1)
                    .withName("France")
                    .withCapital("Paris")
                    .withPopulation(66710000L)
                    .withFlagFileName("france.png")
                    .withLanguages(Arrays.asList("French"))
                    .build();
        mEcuadorCountry = new Country.CountryBuilder(2)
                    .withName("Ecuador")
                    .withCapital("Quito")
                    .withPopulation(1614400L)
                    .withFlagFileName("ecuador.png")
                    .withLanguages(Arrays.asList("Spanish"))
                    .build();
        // set test list of countries, serving as repository
        mExampleListOfCounties = Arrays.asList(
                mFranceCountry, mEcuadorCountry
        );
        // set test list of countries sorted by name
        mExampleListOfCountiesSortedByName = Arrays.asList(
                mEcuadorCountry, mFranceCountry
        );
        // set test list of countries sorted by population
        mExampleListOfCountiesSortedByPopulation = Arrays.asList(
                mFranceCountry, mEcuadorCountry
        );
    }

    @Test
    public void home_ShouldRenderListAllCountries() throws Exception {
        // Arrange the mock behaviour
        Mockito.when(countryRepository.findAll()).thenReturn(
                mExampleListOfCounties
        );
        // Act (perform the MVC request) and Assert results
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(
                        model().attribute("countries",
                                mExampleListOfCounties)
        );
        Mockito.verify(countryRepository).findAll();
    }

    @Test
    public void detail_ShouldRenderCountryDetailPage() throws Exception {
        // set up first country in repository
        Country firstCountryInExampleRepository =
                mExampleListOfCounties.get(0);
        int firstCountryId =
                firstCountryInExampleRepository.getId();
        String firstCountrySlug =
                firstCountryInExampleRepository.getSlugFromName();
        // Arrange the mock behaviour
        Mockito.when(countryRepository.findById(
                firstCountryId
            )).thenReturn(
                firstCountryInExampleRepository
        );
        // Act (perform the MVC request) and Assert results
        mockMvc.perform(
                    get("/country/" + firstCountryId +
                    "/" + firstCountrySlug)
                )
                .andExpect(status().isOk())
                .andExpect(view().name("country-details"))
                .andExpect(
                        model().attribute("country",
                                firstCountryInExampleRepository)
                );
        Mockito.verify(countryRepository).findById(
                firstCountryInExampleRepository.getId()
        );
    }

    @Test
    public void sortByName_ShouldRenderSortedListOfCountriesView()
            throws Exception {
        // Arrange the mock behaviour
        Mockito.when(countryRepository.sortCountriesByName())
                .thenReturn(
                mExampleListOfCountiesSortedByName
        );
        // Act (perform the MVC request) and Assert results
        mockMvc.perform(get("/?sort=name"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(
                        model().attribute("countries",
                                mExampleListOfCountiesSortedByName)
                );
        Mockito.verify(countryRepository).sortCountriesByName();
    }

    @Test
    public void sortByPopulation_ShouldRenderSortedListOfCountriesView()
            throws Exception {
        // Arrange the mock behaviour
        Mockito.when(countryRepository.sortCountriesByPopulation())
                .thenReturn(
                        mExampleListOfCountiesSortedByPopulation
                );
        // Act (perform the MVC request) and Assert results
        mockMvc.perform(get("/?sort=population"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(
                        model().attribute("countries",
                                mExampleListOfCountiesSortedByPopulation)
                );
        Mockito.verify(countryRepository).sortCountriesByPopulation();
    }
}