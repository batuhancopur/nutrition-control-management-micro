package com.batuhancopur.nutritioncontrolmanagementmicro.domain.patient;

import com.batuhancopur.nutritioncontrolmanagementmicro.domain.common.command.CommandHandler;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.patient.command.GetAllPatientsCommand;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.patient.model.Patient;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.patient.port.PatientInfoPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class GetAllPatientsHandler implements CommandHandler<List<Patient>, GetAllPatientsCommand> {
    private final PatientInfoPort patientInfoPort;
    @Override
    public List<Patient> handle(GetAllPatientsCommand command) {
        return patientInfoPort.getAllPatients();
    }
}
