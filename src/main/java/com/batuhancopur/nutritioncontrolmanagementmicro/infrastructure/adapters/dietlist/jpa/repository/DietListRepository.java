package com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.dietlist.jpa.repository;

import com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.dietlist.jpa.entity.DietListEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface DietListRepository extends MongoRepository<DietListEntity,Long> {
}
