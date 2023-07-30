package com.batuhancopur.nutritioncontrolmanagementmicro.domain.dietlist;

import com.batuhancopur.nutritioncontrolmanagementmicro.domain.common.command.VoidCommandHandler;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.dietlist.command.CreateDietListCommand;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.dietlist.model.DietList;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.dietlist.port.DietListPort;
import com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.common.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CreateDietListHandler implements VoidCommandHandler<CreateDietListCommand> {

    private final DietListPort dietListPort;

    @Override
    public void handle(CreateDietListCommand command) throws DataNotFoundException {

        dietListPort.createDietList(toDietList(command));

    }

    private DietList toDietList(CreateDietListCommand command) {
        return DietList.builder()
                .patientId(command.getPatientId())
                .createdDate(command.getCreatedDate())
                .meals(command.getMeals())
                .build();
    }
}
