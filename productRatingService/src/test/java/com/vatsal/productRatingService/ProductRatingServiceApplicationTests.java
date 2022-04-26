package com.vatsal.productRatingService;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vatsal.productRatingService.repository.ProductRatingsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ProductRatingServiceApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private ProductRatingsRepository repository;

	@Test
	void contextLoads() {
	}

	@Test
	void getProducts() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/product-ratings")).andExpect(status().isOk());
	}

	@Test
	void getProductById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/product-ratings/getProduct/{id}",3)).andExpect(status().isOk());
	}
}
