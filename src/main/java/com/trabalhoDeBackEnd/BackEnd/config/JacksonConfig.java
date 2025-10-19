package com.trabalhoDeBackEnd.BackEnd.config;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.time.format.DateTimeFormatter;

@Configuration
public class JacksonConfig {

  @Bean
  public Jackson2ObjectMapperBuilder jacksonBuilder() {
    Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
    builder.modules(new JavaTimeModule());
    builder.simpleDateFormat("dd/MM/yyyy");
    builder.serializers(new com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer(
            DateTimeFormatter.ofPattern("dd/MM/yyyy")
    ));
    builder.deserializers(new com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer(
            DateTimeFormatter.ofPattern("dd/MM/yyyy")
    ));
    builder.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    return builder;
  }
}
