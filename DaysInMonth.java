package com.tools.utils;

public enum DaysInMonth {
    JAN(1, 31),
    FEB(2, 28),
    FEB_LEAP(2, 29),
    MAR(3, 31),
    APR(4, 30),
    MAY(5, 31),
    JUN(6, 30),
    JUL(7, 31),
    AUG(8, 31),
    SEP(9, 30),
    OCT(10, 31),
    NOV(11, 30),
    DEC(12, 31);

    private int month;
    private int days;

    DaysInMonth(int month, int days) {
        this.month = month;
        this.days = days;
    }

    public int getDays() {
        return days;
    }

    public int getMonth() {
        return month;
    }

    public static DaysInMonth fromMonth(int month, boolean isLeapYear) {
        if (month == 2) {
            if (isLeapYear) {
                return FEB_LEAP;
            } else {
                return FEB;
            }
        }
        for (DaysInMonth months : DaysInMonth.values()) {
            if (months.getMonth() == month) {
                return months;
            }
        }
        return null;
    }
}