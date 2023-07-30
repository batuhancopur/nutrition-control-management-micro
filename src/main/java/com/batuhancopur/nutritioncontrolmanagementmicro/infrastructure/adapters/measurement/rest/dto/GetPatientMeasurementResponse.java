package com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.measurement.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetPatientMeasurementResponse {

    private String name;
    private String surname;
    private Measurement measurement;

    public static GetPatientMeasurementResponse fromModel(com.batuhancopur.nutritioncontrolmanagementmicro.domain.measurement.model.Measurement measurement) {
        return GetPatientMeasurementResponse.builder()
                .name(measurement.getName())
                .surname(measurement.getSurname())
                .measurement(Measurement.builder()
                        .patientId(measurement.getPatientId())
                        .measurementDate(measurement.getMeasurementDate())
                        .weight(measurement.getWeight())
                        .height(measurement.getHeight())
                        .waist(measurement.getWaist())
                        .hip(measurement.getHip())
                        .neck(measurement.getNeck())
                        .chest(measurement.getChest())
                        .leftArm(measurement.getLeftArm())
                        .rightArm(measurement.getRightArm())
                        .leftLeg(measurement.getLeftLeg())
                        .rightLeg(measurement.getRightLeg())
                        .bmi(measurement.getBmi())
                        .build())
                .build();
    }

}
