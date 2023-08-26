package com.ifdeveloper.runway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class Config {

    @Bean
    @Profile("test")
    public EnvironmentConfig fileForTest() {
        return new EnvironmentConfig("test-zipcode.pdf");
    }

    @Bean
    @Profile("!test")
    public EnvironmentConfig fileForProduction() {
        return new EnvironmentConfig("prod-zipcode.pdf");
    }
}
