package com.mech.api.product.dto;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"key", "name", "description", "price"})
public class ProductDto extends RepresentationModel<ProductDto>{
    @JsonProperty("id")
    private String key;
    private String name;
    private String description;
    private Double price;

    public ProductDto(String key, String name, String description, Double price) {
        this.key = key;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getKey() {
        return key;
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
