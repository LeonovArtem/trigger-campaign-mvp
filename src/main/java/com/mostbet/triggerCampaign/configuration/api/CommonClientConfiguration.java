package com.mostbet.triggerCampaign.configuration.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.mostbet.publicapi.sdk.encoder.SdkEncoder;
import feign.Logger;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

public class CommonClientConfiguration {

    @Bean
    public Encoder encoder(
            @Autowired ObjectFactory<HttpMessageConverters> messageConverters,
            @Autowired ObjectMapper objectMapper
    ) {
        return new SdkEncoder(new SpringEncoder(messageConverters), objectMapper);
    }

    @Bean
    public Decoder decoder(@Qualifier("clientObjectMapper") ObjectMapper objectMapper) {
        ObjectFactory<HttpMessageConverters> objectFactory = () -> new HttpMessageConverters(
                new MappingJackson2HttpMessageConverter(objectMapper)
        );

        return new ResponseEntityDecoder(new SpringDecoder(objectFactory));
    }

    @Bean(name = "clientObjectMapper")
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.registerModule(new Jdk8Module());
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return mapper;
    }

    @Bean
    public Logger.Level level() {
        return Logger.Level.FULL;
    }
}
