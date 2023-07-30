package com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure;

import com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.dietlist.jpa.repository.DietListRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = "com.batuhancopur.nutritioncontrolmanagementmicro")
@EnableJpaRepositories
@EnableMongoRepositories(basePackageClasses = DietListRepository.class)
@OpenAPIDefinition
public class NutritionControlManagementMicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(NutritionControlManagementMicroApplication.class, args);
	}

}
