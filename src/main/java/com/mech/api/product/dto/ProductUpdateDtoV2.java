package com.mech.api.product.dto;

public class ProductUpdateDtoV2{

    private String updateId;
    private String updateName; 
    private Double updatePrice;
    
    public ProductUpdateDtoV2(String updateId, String updateName, Double updatePrice) {
        this.updateId = updateId;
        this.updateName = updateName;
        this.updatePrice = updatePrice;
    }

    public String getUpdateId() {
        return updateId;
    }

    public String getUpdateName() {
        return updateName;
    }

    public Double getUpdatePrice() {
        return updatePrice;
    }
}
