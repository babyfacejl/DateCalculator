package com.tools.utils;

import com.tools.utils.Exception.DateCalculatorException;

import java.util.Objects;

public class MyCalendar {
    private static final MyCalendar BASE_DATE = new MyCalendar(1901, 1, 1); // base date set to 1901-1-1
    private static final int NUMBER_OF_DAYS_IN_LEAP_YEAR = 366;
    private static final int NUMBER_OF_DAYS_IN_YEAR = 365;

    private int year;
    private int month;
    private int day;

    public MyCalendar(int baseYear, int baseMonth, int baseDay) {
        this.year = baseYear;
        this.month = baseMonth;
        this.day = baseDay;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyCalendar myDate = (MyCalendar) o;
        return year == myDate.year &&
                month == myDate.month &&
                day == myDate.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }

    public int daysFromBaseDate() {
        // e.g 1901/1/7 should return 6
        int dayCounter = 0;
        dayCounter += daysInYears();
        dayCounter += daysInMonths();
        dayCounter += this.day - BASE_DATE.getDay();

        return dayCounter;
    }

    public int daysInYears() {
        int dayCounter = 0;
        for (int year = BASE_DATE.getYear(); year < this.year; year++) {
            dayCounter += LeapYear.isLeapYear(year) ? NUMBER_OF_DAYS_IN_LEAP_YEAR : NUMBER_OF_DAYS_IN_YEAR;
        }
        return dayCounter;
    }

    public int daysInMonths() {
        int dayCounter = 0;
        for (int month = BASE_DATE.getMonth(); month < this.month; month++) {
            dayCounter += DaysInMonth.fromMonth(month, LeapYear.isLeapYear(year)).getDays();
        }
        return dayCounter;
    }

    public static MyCalendar parseDateString(String dateString) throws DateCalculatorException {

        if (DateValidator.isValidDateFormat(dateString)) {
            String trimString = dateString.trim();
            String[] result = trimString.split("-");
            int year = Integer.parseInt(result[0]);
            int month = Integer.parseInt(result[1]);
            int day = Integer.parseInt(result[2]);

            if (DateValidator.isValidDateInput(year, month, day)) {
                return new MyCalendar(year, month, day);
            }
            throw new DateCalculatorException(String.format("Illegal date argument %s. Valid date range between 1901-01-01 and 2999-12-31", dateString));
        }
        throw new DateCalculatorException(String.format("Invalid date format %s. Valid format yyyy-mm-dd", dateString));

    }
}
