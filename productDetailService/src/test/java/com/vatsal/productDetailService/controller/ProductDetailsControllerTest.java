package com.vatsal.productDetailService.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vatsal.productDetailService.entity.ProductDetails;
import com.vatsal.productDetailService.repository.ProductDetailsRepository;
import com.vatsal.productDetailService.service.ProductDetailsService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(ProductDetailsController.class)
class ProductDetailsControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    ProductDetailsService service;

    @MockBean
    ProductDetailsRepository repository;

    @Test
    void getProducts() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/product-details")).andExpect(status().isOk());
    }

    @Test
    void getProductById() throws Exception {
//      mockMvc.perform(MockMvcRequestBuilders.get("/product-details/getProduct/{id}",1)).andExpect(status().isOk());
    }

    @Test
    void saveProduct() throws Exception {
        String json = "{\n" +
                "  \"id\": 0,\n" +
                "  \"name\": \"string\",\n" +
                "  \"quantity\": 0,\n" +
                "  \"price\": 0\n" +
                "}";
        mockMvc.perform(MockMvcRequestBuilders.post("/product-details/addProduct").contentType(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isOk());
    }

    @Test
    void updateProduct() throws Exception {
        String json = "{\n" +
                "  \"id\": 0,\n" +
                "  \"name\": \"string\",\n" +
                "  \"quantity\": 0,\n" +
                "  \"price\": 0\n" +
                "}";
        mockMvc.perform(MockMvcRequestBuilders.put("/product-details/updateProduct/{id}",1).contentType(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isOk());
    }

    @Test
    void deleteProduct() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/product-details/deleteProduct/{id}",1)).andExpect(status().isOk());
    }
}