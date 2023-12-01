package com.mech.api.product.service;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mech.api.product.dto.ProductCreationDto;
import com.mech.api.product.dto.ProductDto;
import com.mech.api.product.entity.Product;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService service;


    @Test
    void testConvertToProduct(){
        ProductCreationDto dto = new ProductCreationDto("Sensor map corsa 2008", "Peça de carro",
        69.99);

        Product product = service.convertToProduct(dto);
        assertEquals(dto.name(), product.getName());
        assertEquals(dto.description(), product.getDescription());
        assertEquals(dto.price(), product.getPrice());
    }

    @Test
    void testConvertToDto(){
        Product product = new Product("1161b7f0-16d3-4013-8ce9-f8f3683fd248",
        "Sensor map corsa 2008", "Peça de carro",
        69.99);

        ProductDto dto = service.convertToDto(product);

        assertEquals(dto.id(), product.getId());
        assertEquals(dto.name(), product.getName());
        assertEquals(dto.description(), product.getDescription());
        assertEquals(dto.price(), product.getPrice());

    }

    



}
