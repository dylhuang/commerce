package com.group.consult.commerce.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi api() {
        return GroupedOpenApi.builder()
                .group("Commerce Consult")
                .pathsToMatch("/**")
                .packagesToScan("com.group.consult.commerce.controller")
                .build();
    }
}
