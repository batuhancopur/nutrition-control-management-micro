package com.batuhancopur.nutritioncontrolmanagementmicro.domain.patient.command;

import com.batuhancopur.nutritioncontrolmanagementmicro.domain.common.model.Command;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GetPatientCommand implements Command {
    private Long patientGuid;

}
