package com.teamtreehouse.countries.controller;

import org.junit.After;
import org.junit.Before;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;

public class CountryControllerTest {
    private MockMvc mockMvc;
    private CountryController countryController;

    @Before
    public void setUp() throws Exception {
        countryController = new CountryController();
        mockMvc = MockMvcBuilders
                .standaloneSetup(countryController)
                .build();
    }

}