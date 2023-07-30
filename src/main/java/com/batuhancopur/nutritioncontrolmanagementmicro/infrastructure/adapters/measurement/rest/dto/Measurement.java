package com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.measurement.rest.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
public class Measurement {
    private Long patientId;
    private LocalDate measurementDate;
    private BigDecimal weight;
    private BigDecimal height;
    private BigDecimal waist;
    private BigDecimal hip;
    private BigDecimal neck;
    private BigDecimal chest;
    private BigDecimal leftArm;
    private BigDecimal rightArm;
    private BigDecimal leftLeg;
    private BigDecimal rightLeg;
    private BigDecimal bmi;

}
