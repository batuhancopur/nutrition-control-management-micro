package com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.batuhancopur.nutritioncontrolmanagementmicro")
@EnableJpaRepositories
@OpenAPIDefinition
public class NutritionControlManagementMicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(NutritionControlManagementMicroApplication.class, args);
	}

}
