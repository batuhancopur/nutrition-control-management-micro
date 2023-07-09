package com.batuhancopur.nutritioncontrolmanagementmicro.domain.common.command;

import com.batuhancopur.nutritioncontrolmanagementmicro.domain.common.model.Command;
import com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.common.exception.DataNotFoundException;

public interface CommandHandler<E, T extends Command> {
    E handle(T command) throws DataNotFoundException;
}
