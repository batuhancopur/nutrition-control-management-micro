package com.batuhancopur.nutritioncontrolmanagementmicro.domain.measurement;

import com.batuhancopur.nutritioncontrolmanagementmicro.domain.common.command.CommandHandler;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.measurement.command.GetPatientMeasurementRecordListCommand;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.measurement.model.Measurement;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.measurement.port.PatientMeasurementPort;
import com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.common.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class GetPatientMeasurementRecordListHandler implements CommandHandler<List<Measurement>, GetPatientMeasurementRecordListCommand> {

    private final PatientMeasurementPort patientMeasurementPort;
    @Override
    public List<Measurement> handle(GetPatientMeasurementRecordListCommand command) throws DataNotFoundException {
        return patientMeasurementPort.getPatientMeasurementRecordList(command.getPatientId());
    }
}
