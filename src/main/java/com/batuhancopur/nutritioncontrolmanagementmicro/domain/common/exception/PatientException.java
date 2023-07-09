package com.batuhancopur.nutritioncontrolmanagementmicro.domain.common.exception;

public class PatientException {

    private PatientException() {throw new IllegalStateException("Utility Class");}

    public static final String PATIENT_ALREADY_EXIST = "Olusturmaya calistiginiz danisan kaydi mevcut.";
    public static final String PHONE_NUMBER_ALREADY_EXIST = "Bu numara ile kayitli baska bir danisan mevcut.";
    public static final String INVALID_PHONE_NUMBER = "Telefon numarasi gecersiz.";
    public static final String INVALID_EMAIL_ADDRESS = "Mail adresi gecersiz.";
    public static final String PATIENT_NOT_EXIST = "Aramaya calistiginiz danisan mevcut degildir.";

}
