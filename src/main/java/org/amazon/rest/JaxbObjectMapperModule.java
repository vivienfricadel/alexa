package org.amazon.rest;

import javax.inject.Singleton;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

import io.quarkus.jackson.ObjectMapperCustomizer;

@Singleton
public class JaxbObjectMapperModule implements ObjectMapperCustomizer {

    public void customize(ObjectMapper mapper) {
        mapper.registerModule(new JaxbAnnotationModule());
    }
}