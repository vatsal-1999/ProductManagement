package com.vatsal.productRatingService.dto;

public class Product {

    private long id;
    private String name;
    private long price;
    private long quantity;
    private int rating;

    public Product(long id, String name, long price, long quantity, int rating) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.rating = rating;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
