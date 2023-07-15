package com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.measurement.jpa.entity;

import com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.patient.jpa.entity.PatientInfoEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "PATIENT_MEASUREMENT",schema = "PTN")
public class PatientMeasurementEntity {

    @Id
    @Column(name = "GUID", unique = true, updatable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GUID")
    @SequenceGenerator(name = "SEQ_GUID", initialValue = 99999, allocationSize = 1, sequenceName = "SEQ_PATIENT", schema = "PTN")
    private Long guid;
    @Column(name = "STATUS", nullable = false)
    private Boolean status;
    @Column(name = "LASTUPDATED")
    private Long lastUpdated;
    @Column(name = "PATIENT_GUID", nullable = false, insertable=false, updatable=false)
    private Long patientGuid;
    @Column(name = "MEASUREMENT_DATE", nullable = false)
    private LocalDate measurementDate;
    @Column(name = "HEIGHT", nullable = false)
    private BigDecimal height;
    @Column(name = "WEIGHT", nullable = false)
    private BigDecimal weight;
    @Column(name = "HIP", nullable = false)
    private BigDecimal hip;
    @Column(name = "WAIST", nullable = false)
    private BigDecimal waist;
    @Column(name = "NECK", nullable = false)
    private BigDecimal neck;
    @Column(name = "BMI", nullable = false)
    private BigDecimal bmi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PATIENT_GUID", referencedColumnName = "GUID")
    private PatientInfoEntity patientInfoEntity;


}
