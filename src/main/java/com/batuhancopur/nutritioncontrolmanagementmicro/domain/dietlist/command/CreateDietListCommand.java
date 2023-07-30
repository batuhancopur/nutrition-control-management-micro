package com.batuhancopur.nutritioncontrolmanagementmicro.domain.dietlist.command;

import com.batuhancopur.nutritioncontrolmanagementmicro.domain.common.model.Command;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.dietlist.model.Meal;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
public class CreateDietListCommand implements Command {

    private Long patientId;
    private LocalDate createdDate;
    private List<Meal> meals;

}
