package com.mech.api.product.dto;

public class ProductUpdateDto{

    private String updateId;
    private String updateName; 
    private String updateDescription; 
    private Double updatePrice;
    
    public ProductUpdateDto(String updateId, String updateName, String updateDescription, Double updatePrice) {
        this.updateId = updateId;
        this.updateName = updateName;
        this.updateDescription = updateDescription;
        this.updatePrice = updatePrice;
    }

    public String getUpdateId() {
        return updateId;
    }

    public String getUpdateName() {
        return updateName;
    }

    public String getUpdateDescription() {
        return updateDescription;
    }

    public Double getUpdatePrice() {
        return updatePrice;
    }

    
}
