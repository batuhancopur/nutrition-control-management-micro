package com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.dietlist.jpa;

import com.batuhancopur.nutritioncontrolmanagementmicro.domain.dietlist.model.DietList;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.dietlist.port.DietListPort;
import com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.dietlist.jpa.entity.DietListEntity;
import com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.dietlist.jpa.repository.DietListRepository;
import com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.common.exception.DataNotFoundException;
import com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.common.utils.DateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

import static com.batuhancopur.nutritioncontrolmanagementmicro.domain.common.exception.DietListException.DIET_LIST_NOT_EXIST;

/**
 * This class is an implementation of the {@link DietListPort} interface. It uses the Spring Data MongoDB library to interact with the database.
 */
@Service
@RequiredArgsConstructor
public class DietListDataAdapter implements DietListPort {

    private final DietListRepository dietListRepository;
    private final MongoTemplate mongoTemplate;

    /**
     * This method creates a new diet list in the database.
     *
     * @param dietList The diet list to be created.
     */
    @Override
    public void createDietList(DietList dietList) {
        DietListEntity entity = DietListEntity.builder()
                .patientId(dietList.getPatientId())
                .createdDate(DateUtils.localDateToLongDate(dietList.getCreatedDate()))
                .meals(dietList.getMeals().stream().map(meal -> com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.dietlist.jpa.entity.Meal.builder()
                        .name(meal.getName())
                        .time(meal.getTime())
                        .foods(meal.getFoods())
                        .build()).toList())
                .build();

        dietListRepository.save(entity);

    }

    /**
     * This method retrieves a diet list from the database based on the patient ID and creation date.
     *
     * @param patientId The ID of the patient.
     * @param createdDate The date the diet list was created.
     * @return The diet list.
     * @throws DataNotFoundException If the diet list does not exist.
     */
    @Override
    public DietList getDietList(Long patientId, LocalDate createdDate) throws DataNotFoundException {

        Query query = new Query();
        query.addCriteria(Criteria.where("patientId").is(patientId));
        query.addCriteria(Criteria.where("createdDate").is(DateUtils.localDateToLongDate(createdDate)));

        DietListEntity entity = mongoTemplate.findOne(query,DietListEntity.class);

        if (entity == null) throw new DataNotFoundException(DIET_LIST_NOT_EXIST);

        return DietList.builder()
                .createdDate(DateUtils.longDateToLocalDate(Objects.requireNonNull(entity.getCreatedDate())))
                .patientId(entity.getPatientId())
                .meals(entity.getMeals().stream().map(meal -> com.batuhancopur.nutritioncontrolmanagementmicro.domain.dietlist.model.Meal.builder()
                        .name(meal.getName())
                        .time(meal.getTime())
                        .foods(meal.getFoods())
                        .build()).toList())
                .build();
    }

}
