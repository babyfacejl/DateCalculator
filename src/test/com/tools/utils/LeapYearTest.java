package com.tools.utils;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LeapYearTest {
    @Test
    public void shouldReturnTrueIfLeapYear() throws Exception {
        Integer[] leapYearArray = new Integer[]{2000, 2400, 2004};
        for (Integer year : leapYearArray) {
            assertThat(LeapYear.isLeapYear(year), is(true));
        }
    }

    @Test
    public void shouldReturnFalseIfNotLeapYear() throws Exception {
        Integer[] leapYearArray = new Integer[]{1800, 1900, 2100, 2200, 2300, 2500};
        for (Integer year : leapYearArray) {
            assertThat(LeapYear.isLeapYear(year), is(false));
        }
    }
}