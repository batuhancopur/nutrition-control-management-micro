package com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.configuration;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public GroupedOpenApi ncmCoreApiGroup() {
        return GroupedOpenApi.builder()
                .group("Nutrition Control Management Service")
                .pathsToMatch("/api/**")
                .packagesToScan(API_BASE_PACKAGE)
                .build();
    }

    private static final String API_BASE_PACKAGE = "com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters";
}
