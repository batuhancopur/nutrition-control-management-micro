package com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.dietlist.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateDietListRequest {
    private List<Meal> meals;
    private Long patientId;
    private LocalDate createdDate;
}
