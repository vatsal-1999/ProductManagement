package com.vatsal.productDetailService.controller;

import com.vatsal.productDetailService.entity.ProductDetails;
import com.vatsal.productDetailService.service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-details")
public class ProductDetailsController {

    @Autowired
    ProductDetailsService productService;

    @GetMapping
    public List<ProductDetails> getProducts() {
        return productService.getProductsDetails();
    }

    @GetMapping("/getProduct/{id}")
    public ProductDetails getProductById(@PathVariable long id) {
        return productService.getProductDetailsById(id);
    }

    @PostMapping("/addProduct")
    public String saveProduct(@RequestBody ProductDetails product) {
        boolean isSaved = productService.addProduct(product);
        return isSaved ? "Product Saved Successfully" : "Error";
    }

    @PutMapping("updateProduct/{id}")
    public String updateProduct(@PathVariable long id, @RequestBody ProductDetails product) {
        boolean isUpdated = productService.updateProduct(id, product);
        return isUpdated ? "Successfully updated" : "Error";
    }

    @DeleteMapping("deleteProduct/{id}")
    public String deleteProduct(@PathVariable long id) {
        boolean isDeleted = productService.deleteProduct(id);
        return isDeleted ? "Successfully deleted" : "Error";
    }
}
