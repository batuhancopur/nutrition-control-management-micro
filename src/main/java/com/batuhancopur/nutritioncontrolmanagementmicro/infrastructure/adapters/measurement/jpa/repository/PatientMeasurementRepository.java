package com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.measurement.jpa.repository;

import com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.measurement.jpa.entity.PatientMeasurementEntity;
import com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.patient.jpa.entity.PatientInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PatientMeasurementRepository extends JpaRepository<PatientMeasurementEntity, Long> {
    List<PatientMeasurementEntity> findAllByPatientInfoEntity(PatientInfoEntity patientInfoEntity);

    Optional<PatientMeasurementEntity> findByPatientInfoEntityAndMeasurementDate(PatientInfoEntity patientInfoEntity, LocalDate measurementDate);
}
