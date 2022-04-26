package com.vatsal.productDetailService.service;

import com.vatsal.productDetailService.entity.ProductDetails;
import com.vatsal.productDetailService.repository.ProductDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductDetailsService {

    @Autowired
    ProductDetailsRepository productRepository;

    public List<ProductDetails> getProductsDetails() {
        return productRepository.findAll();
    }

    public ProductDetails getProductDetailsById(long id) {
        return productRepository.findById(id).get();
    }

    public boolean addProduct(ProductDetails product) {
        ProductDetails addedProduct = productRepository.save(product);
        return addedProduct.getId() != 0;
    }

    public boolean updateProduct(long id, ProductDetails product) {
        Optional<ProductDetails> optional = productRepository.findById(id);
        if (optional.isEmpty()) throw new IllegalStateException("No Product found");
        ProductDetails existing = optional.get();
        if (product.getName() != null && !product.getName().equals("")) {
            existing.setName(product.getName());
        }
        if (product.getQuantity() != 0) {
            existing.setQuantity(product.getQuantity());
        }
        if (product.getPrice() != 0) {
            existing.setPrice(product.getPrice());
        }
        ProductDetails updatedProduct = productRepository.save(product);
        return updatedProduct.getName().equals(product.getName() == null ? updatedProduct.getName() : product.getName()) && updatedProduct.getQuantity() == (product.getQuantity() != 0 ? product.getQuantity() : updatedProduct.getQuantity()) && updatedProduct.getPrice() == (product.getPrice() != 0 ? product.getPrice() : updatedProduct.getPrice());
    }

    public boolean deleteProduct(long id) {
        Optional<ProductDetails> optional = productRepository.findById(id);
        if (optional.isEmpty()) throw new IllegalStateException("No product found");
        productRepository.deleteById(id);
        return true;
    }
}
