package com.batuhancopur.nutritioncontrolmanagementmicro.infrastructure.common.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class DateUtils {

    public static final DateTimeFormatter basicFormatter = DateTimeFormatter.BASIC_ISO_DATE;

    public static long localDateToLongDate(LocalDate date) {
        return Long.parseLong(basicFormatter.format(date));
    }

    public static LocalDate longDateToLocalDate(long date) {
        return LocalDate.parse(String.valueOf(date), basicFormatter);
    }
}
