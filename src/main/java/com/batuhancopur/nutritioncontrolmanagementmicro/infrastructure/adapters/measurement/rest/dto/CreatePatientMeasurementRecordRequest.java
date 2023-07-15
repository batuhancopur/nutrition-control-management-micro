package com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.measurement.rest.dto;

import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreatePatientMeasurementRecordRequest {
    @Nonnull
    private Long patientId;
    @Nonnull
    private BigDecimal weight;
    @Nonnull
    private BigDecimal height;
    @Nonnull
    private BigDecimal waist;
    @Nonnull
    private BigDecimal hip;
    @Nonnull
    private BigDecimal neck;
}
