package com.batuhancopur.nutritioncontrolmanagementmicro.domain.measurement;

import com.batuhancopur.nutritioncontrolmanagementmicro.domain.common.command.CommandHandler;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.measurement.command.GetPatientMeasurementRecordCommand;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.measurement.model.Measurement;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.measurement.port.PatientMeasurementPort;
import com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.common.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetPatientMeasurementRecordHandler implements CommandHandler<Measurement, GetPatientMeasurementRecordCommand> {

    private final PatientMeasurementPort patientMeasurementPort;

    @Override
    public Measurement handle(GetPatientMeasurementRecordCommand command) throws DataNotFoundException {

        return patientMeasurementPort.getPatientMeasurementRecord(command.getPatientId(), command.getMeasurementDate());
    }
}
