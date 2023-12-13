package com.mech.api.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.mech.api.product.controller.ProductController;
import com.mech.api.product.dto.ProductCreationDto;
import com.mech.api.product.dto.ProductCreationDtoV2;
import com.mech.api.product.dto.ProductDto;
import com.mech.api.product.dto.ProductDtoV2;
import com.mech.api.product.dto.ProductUpdateDto;
import com.mech.api.product.dto.ProductUpdateDtoV2;
import com.mech.api.product.entity.Product;
import com.mech.api.product.exceptions.ProductServiceException;
import com.mech.api.product.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;
    
    public void createProduct(ProductCreationDto productDto){

        if(productDto == null) 
            throw new ProductServiceException("Json informed is null!", HttpStatus.BAD_REQUEST);

        if(productDto.getName() == null || productDto.getName().isBlank())
            throw new ProductServiceException("Cannot create a product without a name", HttpStatus.BAD_REQUEST);

        if(productDto.getPrice() == null)
            throw new ProductServiceException("Cannot create a product without a price", HttpStatus.BAD_REQUEST);        

        if(productDto.getPrice() <= 0 )
            throw new ProductServiceException("Product must have a price greater than zero!", HttpStatus.BAD_REQUEST);

        Product product = convertToProduct(productDto);

        repository.save(product);

    }

    public void createProductV2(ProductCreationDtoV2 productDto){
        createProduct(new ProductCreationDto(productDto.getName(), null, productDto.getPrice()));
    }

    public ProductDto getProduct(String id){
        if(id == null || id.isBlank()) 
            throw new ProductServiceException("Id is needed to get a product", HttpStatus.BAD_REQUEST);

        Product product = repository.findById(id)
        .orElseThrow(() -> new ProductServiceException("Product not found", HttpStatus.NOT_FOUND));

        ProductDto dto = convertToDto(product);
        
        dto.add(linkTo(methodOn(ProductController.class).getProduct(id)).withSelfRel());

        return dto;
    }

    public ProductDtoV2 getProductV2(String id){
        ProductDto dto = getProduct(id);
        return new ProductDtoV2(dto.getKey(), dto.getName(), dto.getPrice());
    }

    public List<ProductDto> getAllProducts(){

        List<ProductDto> list = repository.findAll().stream().map(x -> convertToDto(x)).toList();

        list.stream().forEach(x -> x.add(linkTo(methodOn(ProductController.class).getAllProducts()).withSelfRel()));
        
        return list;
    }

    public List<ProductDtoV2> getAllProductsV2(){

        return repository.findAll().stream().map(x -> new ProductDtoV2(
            x.getId(),
            x.getName(),
            x.getPrice()
        )).toList();
    }

    public ProductDto updateProduct(ProductUpdateDto updateDto){
        if(updateDto == null)
            throw new ProductServiceException("A body is needed for updating a product!", HttpStatus.BAD_REQUEST);

        if(updateDto.getUpdateId() == null || updateDto.getUpdateId().isBlank())
            throw new ProductServiceException("An id is needed to update the product", HttpStatus.BAD_REQUEST);

        if(updateDto.getUpdateName() == null || updateDto.getUpdateName().isBlank())
            throw new ProductServiceException("A name to update is needed to update the product", HttpStatus.BAD_REQUEST);

        if(updateDto.getUpdatePrice() == null)
            throw new ProductServiceException("A price to update is needed to update the product", HttpStatus.BAD_REQUEST);

        if(updateDto.getUpdatePrice() <= 0)
            throw new ProductServiceException("Update price must be greater than 0!", HttpStatus.BAD_REQUEST);
        
        Product product = repository.findById(updateDto.getUpdateId())
        .orElseThrow(() -> new ProductServiceException("Product not found for update", HttpStatus.NOT_FOUND));

        product.setName(updateDto.getUpdateName());
        product.setDescription(updateDto.getUpdateDescription());
        product.setPrice(updateDto.getUpdatePrice());

        repository.save(product);

        return convertToDto(product).add(linkTo(methodOn(ProductController.class).updateProduct(updateDto)).withSelfRel());
    }

    public ProductDtoV2 updateProductV2(ProductUpdateDtoV2 productDto){
        ProductDto product = updateProduct(new ProductUpdateDto(productDto.getUpdateId(), productDto.getUpdateName(), null, productDto.getUpdatePrice()));

        return new ProductDtoV2(product.getKey(), product.getName(), product.getPrice());
    }

    public void deleteProduct(String id){
        if(id == null || id.isBlank())
            throw new ProductServiceException("An id is needed to delete a product", HttpStatus.BAD_REQUEST);
        
        if(!repository.existsById(id))
            throw new ProductServiceException("Product to delete not found", HttpStatus.NOT_FOUND);

        repository.deleteById(id);
        
    }

    public Product convertToProduct(ProductCreationDto dto){
        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        return product;
    }

    public ProductDto convertToDto(Product product) {
        return new ProductDto(product.getId(), product.getName(), 
        product.getDescription(), product.getPrice());
    }

}
