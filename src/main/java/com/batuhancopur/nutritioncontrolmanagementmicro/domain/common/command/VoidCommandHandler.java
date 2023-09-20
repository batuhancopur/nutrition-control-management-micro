package com.batuhancopur.nutritioncontrolmanagementmicro.domain.common.command;

import com.batuhancopur.nutritioncontrolmanagementmicro.domain.common.model.Command;
import com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.common.exception.DataNotFoundException;
import com.itextpdf.text.DocumentException;

import java.io.IOException;

public interface VoidCommandHandler<T extends Command> {

    void handle(T command) throws DataNotFoundException, IOException;
}
