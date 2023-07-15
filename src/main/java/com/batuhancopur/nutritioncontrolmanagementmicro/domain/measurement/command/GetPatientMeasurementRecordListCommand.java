package com.batuhancopur.nutritioncontrolmanagementmicro.domain.measurement.command;

import com.batuhancopur.nutritioncontrolmanagementmicro.domain.common.model.Command;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GetPatientMeasurementRecordListCommand implements Command {
    private Long patientId;
}
