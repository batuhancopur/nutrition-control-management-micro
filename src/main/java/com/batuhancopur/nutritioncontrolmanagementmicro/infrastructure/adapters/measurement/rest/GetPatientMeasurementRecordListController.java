package com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.measurement.rest;

import com.batuhancopur.nutritioncontrolmanagementmicro.domain.common.command.CommandHandler;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.measurement.command.GetPatientMeasurementRecordListCommand;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.measurement.model.Measurement;
import com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.measurement.rest.dto.GetPatientMeasurementRecordListResponse;
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
@RequestMapping("api/patient/measurement")
@Tag(name = "Patient Measurement")
@RequiredArgsConstructor
public class GetPatientMeasurementRecordListController {

    private final CommandHandler<List<Measurement>, GetPatientMeasurementRecordListCommand> getPatientMeasurementListHandler;

    @Operation(summary = "Get patient measurement record list")
    @ApiResponse(responseCode = "201")
    @GetMapping("/get/list")
    public ResponseEntity<GetPatientMeasurementRecordListResponse> getPatientMeasurementList(@RequestParam Long patientGuid) throws DataNotFoundException {
        List<Measurement> measurement = getPatientMeasurementListHandler.handle(toCommand(patientGuid));
        return ResponseEntity.ok(GetPatientMeasurementRecordListResponse.fromModel(measurement));
    }

    private GetPatientMeasurementRecordListCommand toCommand(Long patientGuid) {
        return GetPatientMeasurementRecordListCommand.builder()
                .patientId(patientGuid)
                .build();
    }

}
