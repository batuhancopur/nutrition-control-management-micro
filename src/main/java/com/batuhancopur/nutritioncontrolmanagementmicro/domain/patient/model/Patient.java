package com.batuhancopur.nutritioncontrolmanagementmicro.domain.patient.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class Patient {
    private Long guid;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private String phoneNumber;
    private String mailAddress;
    private Integer packageInfo;
}
