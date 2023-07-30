package com.batuhancopur.nutritioncontrolmanagementmicro.domain.dietlist.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@Builder
public class DietList {
    private Long patientId;
    private LocalDate createdDate;
    private List<Meal> meals;
}
