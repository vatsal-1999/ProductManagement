package com.vatsal.productDetailService.service;

import com.vatsal.productDetailService.entity.ProductDetails;
import com.vatsal.productDetailService.repository.ProductDetailsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class ProductDetailsServiceTest {

    @MockBean
    ProductDetailsRepository repository;

    @InjectMocks
    ProductDetailsService service;

    @Test
    void getProductsDetails() {
        Mockito.when(repository.findAll()).thenReturn(List.of(new ProductDetails()));
        assertEquals(1,service.getProductsDetails().size());
    }

    @Test
    void getProductDetailsById() {
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(new ProductDetails("Product1",100,10000)));
        assertEquals(100,service.getProductDetailsById(1).getQuantity());
    }

    @Test
    void addProduct() {
        ProductDetails product = new ProductDetails();
        product.setId(1);
        ProductDetails dummy = new ProductDetails();
        Mockito.when(repository.save(dummy)).thenReturn(product);
        assertTrue(service.addProduct(dummy));
    }

    @Test
    void updateProduct() {
        ProductDetails existing = new ProductDetails("Product101",700,1000);
        Mockito.when(repository.findById(101L)).thenReturn(Optional.of(existing));
        existing.setName("Product102");
        Mockito.when(repository.save(existing)).thenReturn(existing);
        existing.setName("Product101");
        assertTrue(service.updateProduct(101L, existing));
    }

    @Test
    void deleteProduct() {
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(new ProductDetails()));
        assertTrue(service.deleteProduct(1L));
    }
}