package com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.measurement.rest;

import com.batuhancopur.nutritioncontrolmanagementmicro.domain.common.command.VoidCommandHandler;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.measurement.command.CreatePatientMeasurementRecordCommand;
import com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.measurement.rest.dto.CreatePatientMeasurementRecordRequest;
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
@RequestMapping("api/patient/measurement")
@Tag(name = "Patient Measurement")
@RequiredArgsConstructor
public class CreatePatientMeasurementController {

    private final VoidCommandHandler<CreatePatientMeasurementRecordCommand> createPatientMeasurementRecord;

    @Operation(summary = "Create new patient measurement record")
    @ApiResponse(responseCode = "201")
    @PostMapping("/create")
    public void createPatientMeasurementRecord(@RequestBody CreatePatientMeasurementRecordRequest request) throws DataNotFoundException, IOException {
        createPatientMeasurementRecord.handle(toCommand(request));
    }

    private CreatePatientMeasurementRecordCommand toCommand(CreatePatientMeasurementRecordRequest request) {
        return CreatePatientMeasurementRecordCommand.builder()
                .patientId(request.getPatientId())
                .weight(request.getWeight())
                .height(request.getHeight())
                .hip(request.getHip())
                .waist(request.getWaist())
                .neck(request.getNeck())
                .chest(request.getChest())
                .leftArm(request.getLeftArm())
                .rightArm(request.getRightArm())
                .leftLeg(request.getLeftLeg())
                .rightLeg(request.getRightLeg())
                .build();
    }



}
