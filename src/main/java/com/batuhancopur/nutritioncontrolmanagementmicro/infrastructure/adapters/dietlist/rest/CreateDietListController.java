package com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.dietlist.rest;

import com.batuhancopur.nutritioncontrolmanagementmicro.domain.common.command.VoidCommandHandler;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.dietlist.command.CreateDietListCommand;
import com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.dietlist.rest.dto.CreateDietListRequest;
import com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.common.exception.DataNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("api/patient/dietlist")
@Tag(name = "Diet List")
@RequiredArgsConstructor
public class CreateDietListController {

    private final VoidCommandHandler<CreateDietListCommand> createDietList;

    @Operation(summary = "Create new diet list")
    @ApiResponse(responseCode = "201")
    @PostMapping("/create")
    public void createDietList(@RequestBody CreateDietListRequest request) throws DataNotFoundException, IOException {
        createDietList.handle(toCommand(request));
    }

    private CreateDietListCommand toCommand(CreateDietListRequest request) {
        return CreateDietListCommand.builder()
                .patientId(request.getPatientId())
                .createdDate(request.getCreatedDate())
                .meals(request.getMeals().stream().map(meal -> com.batuhancopur.nutritioncontrolmanagementmicro.domain.dietlist.model.Meal.builder()
                        .name(meal.getName())
                        .time(meal.getTime())
                        .foods(meal.getFoods())
                        .build()).toList())
                .build();
    }

}
