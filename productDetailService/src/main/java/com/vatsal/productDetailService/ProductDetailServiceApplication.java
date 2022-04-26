package com.vatsal.productDetailService;

import com.vatsal.productDetailService.entity.ProductDetails;
import com.vatsal.productDetailService.service.ProductDetailsService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
		title = "Product Details Service",
		version = "1.1",
		description = "Microservice for providing details of a product"
))
public class ProductDetailServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductDetailServiceApplication.class, args);
	}

}
