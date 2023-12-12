package com.mech.api.product.dto;

public class ProductDtoV2{
    private String id;
    private String name;
    private Double price;
    
    public ProductDtoV2(String id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    
} 
