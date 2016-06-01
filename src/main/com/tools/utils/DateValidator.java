package com.tools.utils;

public class DateValidator {

    public static boolean isValidDateFormat(String dateInput) {
        return dateInput != null && dateInput.trim().matches("^\\d+\\-\\d+\\-\\d+");
    }

    public static boolean isValidDateInput(int year, int month, int day) {
        if (year >= 1901 && year <= 2999) {
            if (month >= 1 && month <= 12) {
                DaysInMonth daysInMonth = DaysInMonth.fromMonth(month, LeapYear.isLeapYear(year));
                if (day >= 1 && day <= daysInMonth.getDays()) {
                    return true;
                }
            }
        }
        return false;
    }


}