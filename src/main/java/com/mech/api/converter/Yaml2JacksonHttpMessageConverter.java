package com.mech.api.converter;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.fasterxml.jackson.annotation.JsonInclude;

public class Yaml2JacksonHttpMessageConverter extends AbstractJackson2HttpMessageConverter{

    public Yaml2JacksonHttpMessageConverter() {
        super(new YAMLMapper().setSerializationInclusion(
            JsonInclude.Include.NON_NULL),
            MediaType.parseMediaType("application/x-yaml")
            );
        
    }
    

}
