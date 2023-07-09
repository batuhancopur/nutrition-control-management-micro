package com.batuhancopur.nutritioncontrolmanagementmicro.domain.patient.port;

import com.batuhancopur.nutritioncontrolmanagementmicro.domain.patient.model.Patient;
import com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.common.exception.DataNotFoundException;

import java.util.List;

public interface PatientPort {
    void createPatient(Patient patient);

    Patient getPatient(Long patientGuid) throws DataNotFoundException;

    List<Patient> getAllPatients();
}
