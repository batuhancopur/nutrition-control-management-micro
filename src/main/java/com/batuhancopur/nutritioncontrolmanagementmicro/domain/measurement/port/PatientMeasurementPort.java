package com.batuhancopur.nutritioncontrolmanagementmicro.domain.measurement.port;

import com.batuhancopur.nutritioncontrolmanagementmicro.domain.measurement.model.Measurement;
import com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.common.exception.DataNotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface PatientMeasurementPort {
    void createPatientMeasurementRecord(Measurement measurement) throws DataNotFoundException;

    List<Measurement> getPatientMeasurementRecordList(Long patientId) throws DataNotFoundException;

    Measurement getPatientMeasurementRecord(Long patientId, LocalDate measurementDate) throws DataNotFoundException;
}
