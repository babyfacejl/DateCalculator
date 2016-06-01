package com.tools.utils;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class DateCalculatorTest {
    private DateCalculator dateCalculator;

    @Test
    public void shouldReturnNumberOfFullDaysBetweenFromAndEndDate() throws Exception {
        MyCalendar fromDate = new MyCalendar(1901, 1, 1);
        MyCalendar endDate = new MyCalendar(1901, 1, 1);
        assertThat(dateCalculator.calculateFullDays(fromDate, endDate), CoreMatchers.is(0));

        fromDate = new MyCalendar(1983, 6, 2);
        endDate = new MyCalendar(1983, 6, 22);
        assertThat(dateCalculator.calculateFullDays(fromDate, endDate), CoreMatchers.is(19));

        fromDate = new MyCalendar(1984, 7, 4);
        endDate = new MyCalendar(1984, 12, 25);
        assertThat(dateCalculator.calculateFullDays(fromDate, endDate), CoreMatchers.is(173));

        fromDate = new MyCalendar(1989, 1, 3);
        endDate = new MyCalendar(1983, 8, 3);
        assertThat(dateCalculator.calculateFullDays(fromDate, endDate), CoreMatchers.is(1979));

        fromDate = new MyCalendar(1972, 11, 7);
        endDate = new MyCalendar(1972, 11, 8);
        assertThat(dateCalculator.calculateFullDays(fromDate, endDate), CoreMatchers.is(0));

        fromDate = new MyCalendar(2000, 1, 1);
        endDate = new MyCalendar(2000, 1, 3);
        assertThat(dateCalculator.calculateFullDays(fromDate, endDate), CoreMatchers.is(1));

        fromDate = new MyCalendar(2000, 1, 1);
        endDate = new MyCalendar(2000, 12, 31);
        assertThat(dateCalculator.calculateFullDays(fromDate, endDate), CoreMatchers.is(364));

    }
}