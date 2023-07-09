package com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.patient.jpa.repository;

import com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.patient.jpa.entity.PatientInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientInfoRepository extends JpaRepository<PatientInfoEntity, Long> {
    @Query("select ptn from PatientInfoEntity ptn where ptn.guid = :guid")
    Optional<PatientInfoEntity> findByGuid(@Param("guid") Long guid);

}
