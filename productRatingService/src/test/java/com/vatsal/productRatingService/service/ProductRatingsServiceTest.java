package com.vatsal.productRatingService.service;

import com.vatsal.productRatingService.entity.ProductRatings;
import com.vatsal.productRatingService.models.ProductDetails;
import com.vatsal.productRatingService.repository.ProductRatingsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class ProductRatingsServiceTest {

    @MockBean
    ProductRatingsRepository repository;

    @InjectMocks
    ProductRatingsService service;

    @MockBean
    RestTemplate restTemplate;

    @Test
    void getProductDetailsById() {
        Mockito.when(restTemplate.getForObject("http://localhost:8080/product-details/getProduct/1", ProductDetails.class)).thenReturn(new ProductDetails("Product101",100,1000));
        assertEquals(100,service.getProductDetailsById(1L).getQuantity());
    }

    @Test
    void getProductRatings() {
        ProductRatings productRatings = new ProductRatings(10);
        productRatings.setId(1);
        Mockito.when(repository.findAll()).thenReturn(List.of(productRatings));
        Mockito.when(restTemplate.getForObject("http://localhost:8080/product-details/getProduct/1", ProductDetails.class)).thenReturn(new ProductDetails("Product101",100,1000));
        assertEquals(10,service.getProductRatings().get(0).getRating());
    }

    @Test
    void getProductById() {
        Mockito.when(restTemplate.getForObject("http://localhost:8080/product-details/getProduct/1", ProductDetails.class)).thenReturn(new ProductDetails("Product101",100,1000));
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(new ProductRatings(10)));
        assertEquals(10,service.getProductById(1L).getRating());
    }
}