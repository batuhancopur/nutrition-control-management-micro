package com.batuhancopur.nutritioncontrolmanagementmicro.domain.dietlist.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class Meal {
    private String name;
    private String time;
    private List<String> foods;
}
