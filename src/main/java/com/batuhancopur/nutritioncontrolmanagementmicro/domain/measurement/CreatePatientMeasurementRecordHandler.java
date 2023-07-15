package com.batuhancopur.nutritioncontrolmanagementmicro.domain.measurement;

import com.batuhancopur.nutritioncontrolmanagementmicro.domain.common.command.VoidCommandHandler;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.common.exception.PatientException;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.measurement.command.CreatePatientMeasurementRecordCommand;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.measurement.model.Measurement;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.measurement.port.PatientMeasurementPort;
import com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.common.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CreatePatientMeasurementRecordHandler implements VoidCommandHandler<CreatePatientMeasurementRecordCommand> {

    private final PatientMeasurementPort patientMeasurementPort;

    @Override
    public void handle(CreatePatientMeasurementRecordCommand command) throws DataNotFoundException {

        if (patientMeasurementPort.getPatientMeasurementRecord(command.getPatientId(), LocalDate.now()) != null)
            throw new DataNotFoundException(PatientException.MEASUREMENT_ALREADY_EXISTS);

        patientMeasurementPort.createPatientMeasurementRecord(Measurement.builder()
                        .patientId(command.getPatientId())
                        .waist(command.getWaist())
                        .hip(command.getHip())
                        .weight(command.getWeight())
                        .height(command.getHeight())
                        .neck(command.getNeck())
                        .bmi(command.getWeight().divide(command.getHeight().pow(2), RoundingMode.CEILING))
                .build());
    }
}
