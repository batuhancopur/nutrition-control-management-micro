package com.batuhancopur.nutritioncontrolmanagementmicro.domain.patient;

import com.batuhancopur.nutritioncontrolmanagementmicro.domain.common.command.CommandHandler;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.patient.command.GetPatientCommand;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.patient.model.Patient;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.patient.port.PatientPort;
import com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.common.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetPatientHandler implements CommandHandler<Patient, GetPatientCommand> {

    private final PatientPort patientPort;
    @Override
    public Patient handle(GetPatientCommand command) throws DataNotFoundException {
        return patientPort.getPatient(command.getPatientGuid());
    }
}
