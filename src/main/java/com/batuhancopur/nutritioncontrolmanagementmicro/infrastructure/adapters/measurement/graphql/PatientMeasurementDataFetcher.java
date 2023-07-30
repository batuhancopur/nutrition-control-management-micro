package com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.adapters.measurement.graphql;

import com.batuhancopur.nutritioncontrolmanagementmicro.domain.common.command.CommandHandler;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.measurement.command.GetPatientMeasurementRecordCommand;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.measurement.command.GetPatientMeasurementRecordListCommand;
import com.batuhancopur.nutritioncontrolmanagementmicro.domain.measurement.model.Measurement;
import com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.common.exception.DataNotFoundException;
import com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.common.utils.DateUtils;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@DgsComponent
@RequiredArgsConstructor
public class PatientMeasurementDataFetcher {

    private final CommandHandler<Measurement, GetPatientMeasurementRecordCommand> getPatientMeasurementHandler;
    private final CommandHandler<List<Measurement>, GetPatientMeasurementRecordListCommand> getPatientMeasurementListHandler;

    @DgsQuery
    public Measurement getPatientMeasurement(@InputArgument Integer patientId,
                                             @InputArgument Integer measurementDate) throws DataNotFoundException {
        return getPatientMeasurementHandler.handle(toCommand(patientId.longValue(), DateUtils.longDateToLocalDate(measurementDate)));
    }

    @DgsQuery
    public List<Measurement> getPatientMeasurementList(@InputArgument Integer patientId) throws DataNotFoundException {
        return getPatientMeasurementListHandler.handle(toCommand(patientId.longValue()));
    }

    private GetPatientMeasurementRecordCommand toCommand(Long patientGuid, LocalDate measurementDate) {
        return GetPatientMeasurementRecordCommand.builder()
                .patientId(patientGuid)
                .measurementDate(measurementDate)
                .build();
    }

    private GetPatientMeasurementRecordListCommand toCommand(Long patientGuid) {
        return GetPatientMeasurementRecordListCommand.builder()
                .patientId(patientGuid)
                .build();
    }



}
