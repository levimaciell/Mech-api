package com.mech.api.product.dto;

public class ProductCreationDtoV2{
    private String name;
    private Double price;
    
    public ProductCreationDtoV2(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    
}
