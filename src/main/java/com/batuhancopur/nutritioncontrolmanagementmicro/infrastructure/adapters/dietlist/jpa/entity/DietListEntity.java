package com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.dietlist.jpa.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(collection = "dietList")
@Data
@Builder
public class DietListEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String id;
    private Long patientId;
    private Long createdDate;
    private List<Meal> meals;

}
