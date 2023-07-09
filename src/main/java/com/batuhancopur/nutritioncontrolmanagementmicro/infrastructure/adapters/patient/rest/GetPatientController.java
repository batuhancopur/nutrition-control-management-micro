package com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.patient.rest;

import com.batuhancopur.nutritioncontrolmanagementmicro.domain.common.command.CommandHandler;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.patient.command.GetPatientCommand;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.patient.model.Patient;
import com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.patient.rest.dto.GetPatientResponse;
import com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.common.exception.DataNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/patient")
@Tag(name = "Patient")
@RequiredArgsConstructor
public class GetPatientController {

    private final CommandHandler<Patient, GetPatientCommand> getPatientHandler;

    @Operation(summary = "Get patient record")
    @ApiResponse(responseCode = "201")
    @GetMapping("/get")
    public ResponseEntity<GetPatientResponse> getPatient(@RequestParam Long patientGuid) throws DataNotFoundException {
        Patient patient = getPatientHandler.handle(toCommand(patientGuid));
        return ResponseEntity.ok(GetPatientResponse.fromModel(patient));
    }

    private GetPatientCommand toCommand(Long patientGuid) {
        return GetPatientCommand.builder().patientGuid(patientGuid).build();
    }

}
