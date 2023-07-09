package com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.patient.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAllPatientsResponse {
    List<Patient> patientList;

    public static GetAllPatientsResponse fromModel(List<com.batuhancopur.nutritioncontrolmanagementmicro.domain.patient.model.Patient> patientList) {
        return GetAllPatientsResponse.builder()
                .patientList(patientList.stream().map(ptn -> Patient.builder()
                        .guid(ptn.getGuid())
                        .name(ptn.getName())
                        .surname(ptn.getSurname())
                        .birthDate(ptn.getBirthDate())
                        .age(Period.between(ptn.getBirthDate(), LocalDate.now()).getYears())
                        .phoneNumber(ptn.getPhoneNumber())
                        .mailAddress(ptn.getMailAddress())
                        .packageInfo(ptn.getPackageInfo())
                        .build()).toList())
                .build();
    }
}
