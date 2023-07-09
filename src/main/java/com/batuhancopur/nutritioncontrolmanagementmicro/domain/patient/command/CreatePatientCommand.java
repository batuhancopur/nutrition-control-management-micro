package com.batuhancopur.nutritioncontrolmanagementmicro.domain.patient.command;

import com.batuhancopur.nutritioncontrolmanagementmicro.domain.common.model.Command;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class CreatePatientCommand implements Command {

    private String name;
    private String surname;
    private LocalDate birthDate;
    private String phoneNumber;
    private String mailAddress;
    private Integer packageInfo;

}
