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
public class GetDietListResponse {
    private Long patientGuid;
    private LocalDate createdDate;
    private List<Meal> meals;

    public static GetDietListResponse fromModel(com.batuhancopur.nutritioncontrolmanagementmicro.domain.dietlist.model.DietList dietList) {
        return GetDietListResponse.builder()
                .patientGuid(dietList.getPatientId())
                .createdDate(dietList.getCreatedDate())
                .meals(dietList.getMeals().stream().map(meal -> Meal.builder()
                        .name(meal.getName())
                        .time(meal.getTime())
                        .foods(meal.getFoods())
                        .build()).toList())
                .build();
    }

}
