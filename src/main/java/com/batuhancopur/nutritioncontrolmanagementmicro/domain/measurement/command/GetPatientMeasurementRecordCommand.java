package com.batuhancopur.nutritioncontrolmanagementmicro.domain.measurement.command;

import com.batuhancopur.nutritioncontrolmanagementmicro.domain.common.model.Command;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class GetPatientMeasurementRecordCommand implements Command {

    private Long patientId;
    private LocalDate measurementDate;


}
