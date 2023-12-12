package com.mech.api.product.dto;

public class ProductCreationDto{

    private String name;
    private String description;
    private Double price;
    
    public ProductCreationDto(String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }
    
    

    
}
