package com.batuhancopur.nutritioncontrolmanagementmicro.domain.common.exception;

public class DietListException {

    private DietListException() {throw new IllegalStateException("Utility Class");}

    public static final String DIET_LIST_ALREADY_EXIST = "Bu tarih icin diyet listesi zaten mevcut.";

    public static final String DIET_LIST_NOT_EXIST = "Aramaya calistiginiz diyet listesi mevcut degildir.";

}
