package com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.patient.jpa;

import com.batuhancopur.nutritioncontrolmanagementmicro.domain.common.exception.PatientException;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.patient.model.Patient;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.patient.port.PatientInfoPort;
import com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.patient.jpa.entity.PatientInfoEntity;
import com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.patient.jpa.repository.PatientInfoRepository;
import com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.common.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientInfoDataAdapter implements PatientInfoPort {

    private final PatientInfoRepository repository;

    @Override
    public void createPatient(Patient patient) {

        PatientInfoEntity entity = PatientInfoEntity.builder()
                .status(Boolean.TRUE)
                .lastUpdated(1L)
                .name(patient.getName())
                .surname(patient.getSurname())
                .birthDate(patient.getBirthDate())
                .phoneNumber(patient.getPhoneNumber())
                .mailAddress(patient.getMailAddress())
                .packageInfo(patient.getPackageInfo())
                .build();

        repository.save(entity);
    }

    @Override
    public Patient getPatient(Long patientGuid) throws DataNotFoundException {

        PatientInfoEntity patientInfoEntity = repository.findByGuid(patientGuid)
                .orElseThrow(() -> new DataNotFoundException(PatientException.PATIENT_NOT_EXIST));

            return Patient.builder()
                    .guid(patientInfoEntity.getGuid())
                    .name(patientInfoEntity.getName())
                    .surname(patientInfoEntity.getSurname())
                    .birthDate(patientInfoEntity.getBirthDate())
                    .phoneNumber(patientInfoEntity.getPhoneNumber())
                    .mailAddress(patientInfoEntity.getMailAddress())
                    .packageInfo(patientInfoEntity.getPackageInfo())
                    .build();
        }

    @Override
    public List<Patient> getAllPatients() {
        List<PatientInfoEntity> entityList = repository.findAll();

        return entityList.stream().map(ptn -> Patient.builder()
                .guid(ptn.getGuid())
                .name(ptn.getName())
                .surname(ptn.getSurname())
                .birthDate(ptn.getBirthDate())
                .phoneNumber(ptn.getPhoneNumber())
                .mailAddress(ptn.getMailAddress())
                .packageInfo(ptn.getPackageInfo())
                .build()).toList();
    }

}
