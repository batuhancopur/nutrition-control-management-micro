package com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.patient.rest;

import com.batuhancopur.nutritioncontrolmanagementmicro.domain.common.command.VoidCommandHandler;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.patient.command.CreatePatientCommand;
import com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.patient.rest.dto.CreatePatientRequest;
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
@RequestMapping("api/patient/info")
@Tag(name = "Patient Info")
@RequiredArgsConstructor
public class CreatePatientController {

    private final VoidCommandHandler<CreatePatientCommand> createPatientHandler;

    @Operation(summary = "Create new patient record")
    @ApiResponse(responseCode = "201")
    @PostMapping("/create")
    public void createPatient(@RequestBody CreatePatientRequest request) throws DataNotFoundException, IOException {
        createPatientHandler.handle(toCommand(request));
    }

    private CreatePatientCommand toCommand(CreatePatientRequest request) {
        return CreatePatientCommand.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .birthDate(request.getBirthDate())
                .phoneNumber(request.getPhoneNumber())
                .mailAddress(request.getMailAddress())
                .packageInfo(request.getPackageInfo())
                .build();
    }


}
