package com.mech.api.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mech.api.product.dto.ProductCreationDto;
import com.mech.api.product.dto.ProductCreationDtoV2;
import com.mech.api.product.dto.ProductDto;
import com.mech.api.product.dto.ProductDtoV2;
import com.mech.api.product.dto.ProductUpdateDto;
import com.mech.api.product.dto.ProductUpdateDtoV2;
import com.mech.api.product.service.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    
    @Autowired
    private ProductService service;

    @PostMapping(
        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/x-yaml"}
    )
    public void createProduct(@RequestBody ProductCreationDto productDto){
        service.createProduct(productDto);
    }

    @PostMapping(value = "/v2",
    consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/x-yaml"})
    public void createProductV2(@RequestBody ProductCreationDtoV2 productDto){
        service.createProductV2(productDto);
    }

    @GetMapping(value = "/{id}",
    produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/x-yaml"})
    public ProductDto getProduct(@PathVariable String id){
        return service.getProduct(id);
    }

    @GetMapping(value = "/{id}/v2",
    produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/x-yaml"})
    public ProductDtoV2 getProductV2(@PathVariable String id){
        return service.getProductV2(id);
    }

    @GetMapping(
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/x-yaml"}
    )
    public List<ProductDto> getAllProducts(){
        return service.getAllProducts();
    }

    @GetMapping(value = "/v2",
    produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/x-yaml"})
    public List<ProductDtoV2> getAllProductsV2(){
        return service.getAllProductsV2();
    }

    @PutMapping(
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/x-yaml"},
        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/x-yaml"}
    )
    public ProductDto updateProduct(@RequestBody ProductUpdateDto updateDto){
        return service.updateProduct(updateDto);
    }

    @PutMapping(value = "/v2",
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/x-yaml"},
        consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, "application/x-yaml"})
    public ProductDtoV2 updateProductV2(@RequestBody ProductUpdateDtoV2 updateDto){
        return service.updateProductV2(updateDto);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteProduct(@PathVariable String id){
        service.deleteProduct(id);
    }

}
