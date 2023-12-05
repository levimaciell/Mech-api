package com.mech.api.product.exceptions;

import org.springframework.http.HttpStatus;

public class ProductServiceException extends RuntimeException{
    
    private HttpStatus status;

    public ProductServiceException(String msg, HttpStatus status){
        super(msg);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

    
}
