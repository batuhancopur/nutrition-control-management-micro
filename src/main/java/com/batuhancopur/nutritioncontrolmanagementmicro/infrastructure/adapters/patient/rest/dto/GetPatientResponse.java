package com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.patient.rest.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetPatientResponse {

    Patient patient;

    public static GetPatientResponse fromModel(com.batuhancopur.nutritioncontrolmanagementmicro.domain.patient.model.Patient patient) {
        return GetPatientResponse.builder()
                .patient(Patient.builder()
                        .guid(patient.getGuid())
                        .name(patient.getName())
                        .surname(patient.getSurname())
                        .birthDate(patient.getBirthDate())
                        .age(Period.between(patient.getBirthDate(), LocalDate.now()).getYears())
                        .phoneNumber(patient.getPhoneNumber())
                        .mailAddress(patient.getMailAddress())
                        .packageInfo(patient.getPackageInfo())
                        .build())
                .build();
    }
}
