package com.batuhancopur.nutritioncontrolmanagementmicro.domain.measurement.model;

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
    private String name;
    private String surname;
    private LocalDate measurementDate;
    private BigDecimal weight;
    private BigDecimal height;
    private BigDecimal waist;
    private BigDecimal hip;
    private BigDecimal neck;
    private BigDecimal bmi;
}
