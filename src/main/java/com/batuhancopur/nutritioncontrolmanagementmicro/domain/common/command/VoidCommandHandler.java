package com.batuhancopur.nutritioncontrolmanagementmicro.domain.common.command;

import com.batuhancopur.nutritioncontrolmanagementmicro.domain.common.model.Command;

public interface VoidCommandHandler<T extends Command> {

    void handle(T command);
}
