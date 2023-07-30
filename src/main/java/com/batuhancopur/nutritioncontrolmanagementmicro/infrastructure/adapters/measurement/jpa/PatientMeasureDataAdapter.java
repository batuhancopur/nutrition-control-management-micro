package com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.measurement.jpa;

import com.batuhancopur.nutritioncontrolmanagementmicro.domain.common.exception.PatientException;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.measurement.model.Measurement;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.measurement.port.PatientMeasurementPort;
import com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.measurement.jpa.entity.PatientMeasurementEntity;
import com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.measurement.jpa.repository.PatientMeasurementRepository;
import com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.patient.jpa.entity.PatientInfoEntity;
import com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.patient.jpa.repository.PatientInfoRepository;
import com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.common.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientMeasureDataAdapter implements PatientMeasurementPort {

    private final PatientMeasurementRepository measurementRepository;
    private final PatientInfoRepository patientInfoRepository;

    @Override
    public void createPatientMeasurementRecord(Measurement measurement) throws DataNotFoundException {

        PatientInfoEntity patientInfoEntity = patientInfoRepository.findByGuid(measurement.getPatientId())
                .orElseThrow(() -> new DataNotFoundException(PatientException.PATIENT_NOT_EXIST));

        PatientMeasurementEntity entity = PatientMeasurementEntity.builder()
                .status(Boolean.TRUE)
                .lastUpdated(1L)
                .measurementDate(LocalDate.now())
                .patientInfoEntity(patientInfoEntity)
                .waist(measurement.getWaist())
                .hip(measurement.getHip())
                .weight(measurement.getWeight())
                .height(measurement.getHeight())
                .neck(measurement.getNeck())
                .chest(measurement.getChest())
                .rightArm(measurement.getRightArm())
                .leftArm(measurement.getLeftArm())
                .rightLeg(measurement.getRightLeg())
                .leftLeg(measurement.getLeftLeg())
                .bmi(measurement.getBmi())
                .build();

        measurementRepository.save(entity);
    }

    @Override
    public List<Measurement> getPatientMeasurementRecordList(Long patientId) throws DataNotFoundException {

        List<PatientMeasurementEntity> entityList = measurementRepository.findAllByPatientInfoEntity(patientInfoRepository.findByGuid(patientId)
                .orElseThrow(() -> new DataNotFoundException(PatientException.PATIENT_NOT_EXIST)));


        return entityList.stream().map(msr -> Measurement.builder()
                .patientId(msr.getPatientInfoEntity().getGuid())
                .name(msr.getPatientInfoEntity().getName())
                .surname(msr.getPatientInfoEntity().getSurname())
                .measurementDate(msr.getMeasurementDate())
                .waist(msr.getWaist())
                .hip(msr.getHip())
                .weight(msr.getWeight())
                .height(msr.getHeight())
                .neck(msr.getNeck())
                .chest(msr.getChest())
                .rightArm(msr.getRightArm())
                .leftArm(msr.getLeftArm())
                .rightLeg(msr.getRightLeg())
                .leftLeg(msr.getLeftLeg())
                .bmi(msr.getBmi())
                .build()).toList();
    }

    @Override
    public Measurement getPatientMeasurementRecord(Long patientId, LocalDate measurementDate) throws DataNotFoundException {

        try {
            PatientMeasurementEntity entity = measurementRepository.findByPatientInfoEntityAndMeasurementDate(patientInfoRepository.findByGuid(patientId)
                            .orElseThrow(() -> new DataNotFoundException(PatientException.PATIENT_NOT_EXIST)), measurementDate)
                    .orElseThrow(() -> new DataNotFoundException(PatientException.MEASUREMENT_NOT_EXIST));

            return Measurement.builder()
                    .patientId(entity.getPatientInfoEntity().getGuid())
                    .name(entity.getPatientInfoEntity().getName())
                    .surname(entity.getPatientInfoEntity().getSurname())
                    .measurementDate(entity.getMeasurementDate())
                    .waist(entity.getWaist())
                    .hip(entity.getHip())
                    .weight(entity.getWeight())
                    .height(entity.getHeight())
                    .neck(entity.getNeck())
                    .chest(entity.getChest())
                    .rightArm(entity.getRightArm())
                    .leftArm(entity.getLeftArm())
                    .rightLeg(entity.getRightLeg())
                    .leftLeg(entity.getLeftLeg())
                    .bmi(entity.getBmi())
                    .build();
        } catch (Exception e) {
            return null;
        }


    }
}
