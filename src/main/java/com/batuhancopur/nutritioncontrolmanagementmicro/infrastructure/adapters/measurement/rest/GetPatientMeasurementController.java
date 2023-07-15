package com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.measurement.rest;

import com.batuhancopur.nutritioncontrolmanagementmicro.domain.common.command.CommandHandler;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.measurement.command.GetPatientMeasurementRecordCommand;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.measurement.model.Measurement;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.patient.model.Patient;
import com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.measurement.rest.dto.GetPatientMeasurementResponse;
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

import java.time.LocalDate;

@RestController
@RequestMapping("api/patient/measurement")
@Tag(name = "Patient Measurement")
@RequiredArgsConstructor
public class GetPatientMeasurementController {

    private final CommandHandler<Measurement, GetPatientMeasurementRecordCommand> getPatientMeasurementHandler;

    @Operation(summary = "Get patient measurement record")
    @ApiResponse(responseCode = "201")
    @GetMapping("/get")
    public ResponseEntity<GetPatientMeasurementResponse> getPatient(@RequestParam Long patientGuid, @RequestParam LocalDate measurementDate) throws DataNotFoundException {
        Measurement measurement = getPatientMeasurementHandler.handle(toCommand(patientGuid, measurementDate));
        return ResponseEntity.ok(GetPatientMeasurementResponse.fromModel(measurement));
    }

    private GetPatientMeasurementRecordCommand toCommand(Long patientGuid, LocalDate measurementDate) {
        return GetPatientMeasurementRecordCommand.builder()
                .patientId(patientGuid)
                .measurementDate(measurementDate)
                .build();
    }

}
