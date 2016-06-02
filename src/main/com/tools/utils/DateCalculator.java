package com.tools.utils;

public class DateCalculator {

    public static int calculateFullDays(final MyCalendar startDate, final MyCalendar endDate) {
        int daysFromBaseDateForStartDate = startDate.daysFromBaseDate();
        int daysFromBaseDateForEndDate = endDate.daysFromBaseDate();

        int difference = daysFromBaseDateForEndDate - daysFromBaseDateForStartDate;
        if (difference == 0) {
            return 0;
        }
        return difference > 0 ? difference -1 : difference * (-1) - 1;
    }
}
