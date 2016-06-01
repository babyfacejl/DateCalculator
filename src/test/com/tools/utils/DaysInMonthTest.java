package com.tools.utils;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DaysInMonthTest {
    @Test
    public void shouldReturnDaysForOtherMonth() throws Exception {
        assertThat(DaysInMonth.fromMonth(1, true), is(DaysInMonth.JAN));
        assertThat(DaysInMonth.fromMonth(2, true), is(DaysInMonth.FEB_LEAP));
        assertThat(DaysInMonth.fromMonth(2, false), is(DaysInMonth.FEB));
        assertThat(DaysInMonth.fromMonth(3, true), is(DaysInMonth.MAR));
        assertThat(DaysInMonth.fromMonth(4, true), is(DaysInMonth.APR));
        assertThat(DaysInMonth.fromMonth(5, true), is(DaysInMonth.MAY));
        assertThat(DaysInMonth.fromMonth(6, true), is(DaysInMonth.JUN));
        assertThat(DaysInMonth.fromMonth(7, true), is(DaysInMonth.JUL));
        assertThat(DaysInMonth.fromMonth(8, true), is(DaysInMonth.AUG));
        assertThat(DaysInMonth.fromMonth(9, true), is(DaysInMonth.SEP));
        assertThat(DaysInMonth.fromMonth(10, true), is(DaysInMonth.OCT));
        assertThat(DaysInMonth.fromMonth(11, true), is(DaysInMonth.NOV));
        assertThat(DaysInMonth.fromMonth(12, true), is(DaysInMonth.DEC));
    }
}