package com.mech.api.configurations;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mech.api.converter.Yaml2JacksonHttpMessageConverter;

@Configuration
public class Webconfig implements WebMvcConfigurer{

    private static final MediaType MEDIA_TYPE_APPLICATION_YML = MediaType.valueOf("application/x-yaml");

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        // //via query param: http://localhost:8080/products?mediatype=xml 

        // //favorParameter: indica a permissão de parâmetros
        // configurer.favorParameter(true)
        // //parameternName: indica o nome do parâmetro para content negotiation
        // .parameterName("mediaType")
        // //ignoreAcceptHeader: ignora o header,
        // .ignoreAcceptHeader(true)
        // .useRegisteredExtensionsOnly(false)
        // //defaultContentType: Usa como padrão o json
        // .defaultContentType(MediaType.APPLICATION_JSON)
        // .mediaType("json", MediaType.APPLICATION_JSON)
        // .mediaType("xml", MediaType.APPLICATION_XML ); 

        //via Header param: http://localhost:8080/products
        configurer.favorParameter(false)
        .ignoreAcceptHeader(false)
        .useRegisteredExtensionsOnly(false)
        .defaultContentType(MediaType.APPLICATION_JSON)
        .mediaType("json", MediaType.APPLICATION_JSON)
        .mediaType("xml", MediaType.APPLICATION_XML )
        .mediaType("yaml", MEDIA_TYPE_APPLICATION_YML); 

    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new Yaml2JacksonHttpMessageConverter());
    }
    
}
