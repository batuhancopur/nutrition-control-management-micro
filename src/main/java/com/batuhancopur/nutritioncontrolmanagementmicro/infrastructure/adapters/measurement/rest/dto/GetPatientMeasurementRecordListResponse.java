package com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.measurement.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetPatientMeasurementRecordListResponse {

    private String name;
    private String surname;
    private List<Measurement> measurementList;
    public static GetPatientMeasurementRecordListResponse fromModel(List<com.batuhancopur.nutritioncontrolmanagementmicro.domain.measurement.model.Measurement> measurement) {
        return GetPatientMeasurementRecordListResponse.builder()
                .name(measurement.get(0).getName())
                .surname(measurement.get(0).getSurname())
                .measurementList(measurement.stream().map(msr -> Measurement.builder()
                        .measurementDate(msr.getMeasurementDate())
                        .weight(msr.getWeight())
                        .height(msr.getHeight())
                        .bmi(msr.getBmi())
                        .waist(msr.getWaist())
                        .hip(msr.getHip())
                        .neck(msr.getNeck())
                        .patientId(msr.getPatientId())
                        .build()).toList())
                .build();
    }

}
