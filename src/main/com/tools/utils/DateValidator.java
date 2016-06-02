package com.tools.utils;

public class DateValidator {

    public static boolean isValidDateFormat(final String dateInput) {
        return dateInput != null && dateInput.trim().matches("^\\d+\\-\\d+\\-\\d+");
    }

    public static boolean isValidDateInput(final int year, final int month, final int day) {
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