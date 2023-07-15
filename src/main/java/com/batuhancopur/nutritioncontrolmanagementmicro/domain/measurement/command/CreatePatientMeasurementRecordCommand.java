package com.batuhancopur.nutritioncontrolmanagementmicro.domain.measurement.command;

import com.batuhancopur.nutritioncontrolmanagementmicro.domain.common.model.Command;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class CreatePatientMeasurementRecordCommand implements Command {
    private Long patientId;
    private BigDecimal weight;
    private BigDecimal height;
    private BigDecimal waist;
    private BigDecimal hip;
    private BigDecimal neck;
}
