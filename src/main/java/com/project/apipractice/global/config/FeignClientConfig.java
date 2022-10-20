package com.project.apipractice.global.config;

import feign.Logger;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.form.FormEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;

@Configuration
@RequiredArgsConstructor
public class FeignClientConfig {

    private final ObjectFactory<HttpMessageConverters> messageConverters;

    @Bean
    public Decoder feignDecoder() {
        MappingJackson2XmlHttpMessageConverter c = new MappingJackson2XmlHttpMessageConverter();
        ObjectFactory<HttpMessageConverters> objectFactory = () ->new HttpMessageConverters(c);
        return new ResponseEntityDecoder(new SpringDecoder(objectFactory));
    }
    @Bean
    public Encoder feignFormEncoder() {
        return new FormEncoder(new SpringEncoder(messageConverters));
    }


    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
