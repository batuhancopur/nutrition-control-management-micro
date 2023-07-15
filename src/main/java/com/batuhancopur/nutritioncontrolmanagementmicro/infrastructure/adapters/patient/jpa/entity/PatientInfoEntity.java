package com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.patient.jpa.entity;

import com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.measurement.jpa.entity.PatientMeasurementEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "PATIENT_INFO",schema = "PTN")
public class PatientInfoEntity {
    @Id
    @Column(name = "GUID", unique = true, updatable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GUID")
    @SequenceGenerator(name = "SEQ_GUID", initialValue = 99999, allocationSize = 1, sequenceName = "SEQ_PATIENT", schema = "PTN")
    private Long guid;
    @Column(name = "STATUS", nullable = false)
    private Boolean status;
    @Column(name = "LASTUPDATED")
    private Long lastUpdated;

    @Column(name = "NAME", length = 50, nullable = false)
    private String name;

    @Column(name = "SURNAME", length = 50, nullable = false)
    private String surname;

    @Column(name = "BIRTH_DATE", nullable = false)
    private LocalDate birthDate;

    @Column(name = "PHONE_NUMBER", length = 12, nullable = false)
    private String phoneNumber;

    @Column(name = "MAIL_ADDRESS", length = 50, nullable = true)
    private String mailAddress;

    @Column(name = "PACKAGE_INFO", length = 2, nullable = false)
    private Integer packageInfo;

    @OneToMany(mappedBy = "patientInfoEntity", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY, targetEntity = PatientMeasurementEntity.class)
    private List<PatientMeasurementEntity> patientMeasurementEntity;

}
