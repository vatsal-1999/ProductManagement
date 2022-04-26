package com.vatsal.productRatingService.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vatsal.productRatingService.repository.ProductRatingsRepository;
import com.vatsal.productRatingService.service.ProductRatingsService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(ProductRatingsController.class)
class ProductRatingsControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    ProductRatingsRepository repository;

    @MockBean
    ProductRatingsService service;

    @Test
    void getProducts() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/product-ratings")).andExpect(status().isOk());
    }

    @Test
    void getProductById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/product-ratings/getProduct/{id}",1)).andExpect(status().isOk());
    }
}