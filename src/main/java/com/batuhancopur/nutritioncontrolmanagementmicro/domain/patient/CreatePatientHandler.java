package com.batuhancopur.nutritioncontrolmanagementmicro.domain.patient;

import com.batuhancopur.nutritioncontrolmanagementmicro.domain.common.command.VoidCommandHandler;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.patient.command.CreatePatientCommand;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.patient.model.Patient;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.patient.port.PatientInfoPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreatePatientHandler implements VoidCommandHandler<CreatePatientCommand> {

    private final PatientInfoPort patientInfoPort;
    @Override
    public void handle(CreatePatientCommand command) {

        Patient patient = Patient.builder()
                .name(command.getName())
                .surname(command.getSurname())
                .birthDate(command.getBirthDate())
                .phoneNumber(command.getPhoneNumber())
                .mailAddress(command.getMailAddress())
                .packageInfo(command.getPackageInfo())
                .build();

        patientInfoPort.createPatient(patient);
    }


}
