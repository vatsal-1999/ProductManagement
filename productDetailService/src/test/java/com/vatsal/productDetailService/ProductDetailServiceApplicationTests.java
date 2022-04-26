package com.vatsal.productDetailService;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vatsal.productDetailService.repository.ProductDetailsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ProductDetailServiceApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private ProductDetailsRepository repository;

	@Test
	void contextLoads() {
	}

	@Test
	void getProducts() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/product-details")).andExpect(status().isOk());
	}

	@Test
	void getProductById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/product-details/getProduct/{id}",1)).andExpect(status().isOk());
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
