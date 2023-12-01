package com.mech.api.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mech.api.product.dto.ProductCreationDto;
import com.mech.api.product.dto.ProductDto;
import com.mech.api.product.dto.ProductUpdateDto;
import com.mech.api.product.entity.Product;
import com.mech.api.product.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;
    
    public void createProduct(ProductCreationDto productDto){

        //TODO:Check for errors

        Product product = convertToProduct(productDto);

        repository.save(product);

    }

    public ProductDto getProduct(String id){
        //TODO:Check for errors

        Product product = repository.findById(id).orElseThrow();

        return convertToDto(product);
    }

    public List<ProductDto> getAllProducts(){

        return repository.findAll().stream().map(x -> convertToDto(x)).toList();
    }

    public ProductDto updateProduct(ProductUpdateDto updateDto){
        //TODO:Check for errors

        Product product = repository.findById(updateDto.updateId()).orElseThrow();
        product.setName(updateDto.updateName());
        product.setDescription(updateDto.updateDescription());
        product.setPrice(updateDto.updatePrice());

        repository.save(product);

        return convertToDto(product);
    }

    public void deleteProduct(String id){
        //TODO:Check for errors

        repository.deleteById(id);
        
    }

    public Product convertToProduct(ProductCreationDto dto){
        Product product = new Product();
        product.setName(dto.name());
        product.setDescription(dto.description());
        product.setPrice(dto.price());
        return product;
    }

    public ProductDto convertToDto(Product product) {
        return new ProductDto(product.getId(), product.getName(), 
        product.getDescription(), product.getPrice());
    }



}
