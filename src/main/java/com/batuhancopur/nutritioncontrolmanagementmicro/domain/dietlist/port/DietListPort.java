package com.batuhancopur.nutritioncontrolmanagementmicro.domain.dietlist.port;

import com.batuhancopur.nutritioncontrolmanagementmicro.domain.dietlist.model.DietList;
import com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.common.exception.DataNotFoundException;

import java.time.LocalDate;

public interface DietListPort {
    void createDietList(DietList dietList);

    DietList getDietList(Long patientId, LocalDate createdDate  ) throws DataNotFoundException;
}
