package com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.dietlist.rest;

import com.batuhancopur.nutritioncontrolmanagementmicro.domain.common.command.VoidCommandHandler;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.dietlist.command.GetDietListCommand;
import com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.common.exception.DataNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;

@RestController
@RequestMapping("api/patient/dietlist")
@Tag(name = "Diet List")
@RequiredArgsConstructor
public class GetDietListController {

    private final VoidCommandHandler<GetDietListCommand> getDietListHandler;

    @Operation(summary = "Get patients diet list")
    @ApiResponse(responseCode = "201")
    @GetMapping(value = "/get", produces = {"application/pdf"})
    public void getDietList(HttpServletResponse response,
                            @RequestParam Long patientId,
                            @RequestParam LocalDate createdDate) throws DataNotFoundException, IOException {
        response.setContentType("application/pdf");

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=list_" + createdDate.toString() + ".pdf";
        response.setHeader(headerKey, headerValue);
        getDietListHandler.handle(toCommand(patientId, createdDate, response));
    }

    private GetDietListCommand toCommand(Long patientId, LocalDate createdDate, HttpServletResponse response) {
        return GetDietListCommand.builder()
                .response(response)
                .patientId(patientId)
                .createdDate(createdDate)
                .build();
    }

}
