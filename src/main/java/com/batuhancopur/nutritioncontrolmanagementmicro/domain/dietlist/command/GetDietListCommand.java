package com.batuhancopur.nutritioncontrolmanagementmicro.domain.dietlist.command;

import com.batuhancopur.nutritioncontrolmanagementmicro.domain.common.model.Command;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class GetDietListCommand implements Command {

    private Long patientId;
    private LocalDate createdDate;
    private HttpServletResponse response;
}
