package com.vatsal.productRatingService;

import com.vatsal.productRatingService.entity.ProductRatings;
import com.vatsal.productRatingService.repository.ProductRatingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@SpringBootApplication
public class ProductRatingServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProductRatingServiceApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Autowired
	ProductRatingsRepository repository;

	@Override
	public void run(String... args) throws Exception {
		for (int i=1; i<=200; i++) {
			repository.save(new ProductRatings(new Random().nextInt(5)));
		}
	}
}
