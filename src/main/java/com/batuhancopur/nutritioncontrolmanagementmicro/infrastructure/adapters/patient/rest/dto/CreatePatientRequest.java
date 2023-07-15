package com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.patient.rest.dto;


import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreatePatientRequest {
    @Nonnull
    private String name;
    @Nonnull
    private String surname;
    @Nonnull
    private LocalDate birthDate;
    @Nonnull
    private String phoneNumber;
    @Nullable
    private String mailAddress;
    @Nonnull
    private Integer packageInfo;
}
