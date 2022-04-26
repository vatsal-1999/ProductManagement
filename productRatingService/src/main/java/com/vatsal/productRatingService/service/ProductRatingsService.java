package com.vatsal.productRatingService.service;

import com.vatsal.productRatingService.dto.Product;
import com.vatsal.productRatingService.entity.ProductRatings;
import com.vatsal.productRatingService.models.ProductDetails;
import com.vatsal.productRatingService.repository.ProductRatingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductRatingsService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ProductRatingsRepository repository;

//    @Autowired
//    ProductDetailsControllerApi productDetailsControllerApi;
//
    public ProductDetails getProductDetailsById(long id) {
        return restTemplate.getForObject("http://localhost:8080/product-details/getProduct/"+id,ProductDetails.class);
    }

    public List<Product> getProductRatings() {
        List<ProductRatings> ratings = repository.findAll();
        return ratings.stream().map(
                rating -> {
                    ProductDetails details = getProductDetailsById(rating.getId());
                    return new Product(rating.getId(),details.getName(),details.getPrice(),details.getQuantity(),rating.getRating());
                }
        ).collect(Collectors.toList());
    }

    public Product getProductById(long id) {
        ProductDetails details = getProductDetailsById(id);
        ProductRatings ratings = repository.findById(id).get();
        return new Product(id,details.getName(),details.getPrice(),details.getQuantity(),ratings.getRating());
    }
}
