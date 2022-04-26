package com.vatsal.productRatingService.controller;

import com.vatsal.productRatingService.dto.Product;
import com.vatsal.productRatingService.service.ProductRatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product-ratings")
public class ProductRatingsController {

    @Autowired
    ProductRatingsService service;

    @GetMapping
    public List<Product> getProducts() {
        return service.getProductRatings();
    }

    @GetMapping("/getProduct/{id}")
    public Product getProductById(@PathVariable long id) {
        return service.getProductById(id);
    }
}
