package com.vatsal.productRatingService.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
public class ProductDetails {

    public ProductDetails() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private long quantity;
    private long price;

    public ProductDetails(String name, long quantity, long price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}
