package com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.patient.rest;

import com.batuhancopur.nutritioncontrolmanagementmicro.domain.common.command.CommandHandler;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.patient.command.GetAllPatientsCommand;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.patient.model.Patient;
import com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.patient.rest.dto.GetAllPatientsResponse;
import com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.patient.rest.dto.GetPatientResponse;
import com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.common.exception.DataNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/patient/info")
@Tag(name = "Patient Info")
@RequiredArgsConstructor
public class GetAllPatientsController {


    private final CommandHandler<List<Patient>, GetAllPatientsCommand> getAllPatientsHandler;

    @Operation(summary = "Get all patients record")
    @ApiResponse(responseCode = "201")
    @GetMapping("/getAll")
    public ResponseEntity<GetAllPatientsResponse> getAllPatients() throws DataNotFoundException {
        List<Patient> patient = getAllPatientsHandler.handle(new GetAllPatientsCommand());
        return ResponseEntity.ok(GetAllPatientsResponse.fromModel(patient));
    }


}
