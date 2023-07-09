package com.batuhancopur.nutritioncontrolmanagementmicro.domain.patient;

import com.batuhancopur.nutritioncontrolmanagementmicro.domain.common.command.CommandHandler;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.patient.command.GetAllPatientsCommand;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.patient.model.Patient;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.patient.port.PatientPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class GetAllPatientsHandler implements CommandHandler<List<Patient>, GetAllPatientsCommand> {
    private final PatientPort patientPort;
    @Override
    public List<Patient> handle(GetAllPatientsCommand command) {
        return patientPort.getAllPatients();
    }
}
