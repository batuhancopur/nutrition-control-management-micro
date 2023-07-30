package com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.dietlist.jpa.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.List;
@Getter
@Setter
@Builder
public class Meal {
    private String name;
    private String time;
    private List<String> foods;
}
