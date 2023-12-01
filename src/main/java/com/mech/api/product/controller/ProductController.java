package com.mech.api.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mech.api.product.dto.ProductCreationDto;
import com.mech.api.product.dto.ProductDto;
import com.mech.api.product.dto.ProductUpdateDto;
import com.mech.api.product.service.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    
    @Autowired
    private ProductService service;

    @PostMapping
    public void createProduct(@RequestBody ProductCreationDto productDto){
        service.createProduct(productDto);
    }

    @GetMapping(value = "/{id}")
    public ProductDto getProduct(@PathVariable String id){
        return service.getProduct(id);
    }

    @GetMapping
    public List<ProductDto> getAllProducts(){
        return service.getAllProducts();
    }

    @PutMapping()
    public ProductDto updateProduct(@RequestBody ProductUpdateDto updateDto){
        return service.updateProduct(updateDto);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteProduct(@PathVariable String id){
        service.deleteProduct(id);
    }

}
