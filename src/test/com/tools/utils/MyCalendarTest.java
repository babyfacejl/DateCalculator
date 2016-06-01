package com.tools.utils;

import com.tools.utils.Exception.DateCalculatorException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MyCalendarTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldCheckIsDateEquals() throws Exception {
        MyCalendar date1 = new MyCalendar(2000, 1, 1);
        MyCalendar date2 = new MyCalendar(2000, 1, 1);
        MyCalendar date3 = new MyCalendar(1999, 12, 31);

        assertTrue(date1.equals(date2));
        assertFalse(date1.equals(date3));
    }

    @Test
    public void shouldCalculateDaysInYears() throws Exception {
        MyCalendar date = new MyCalendar(1902, 1, 1);
        MyCalendar date1 = new MyCalendar(1905, 1, 1);

        assertThat(date.daysInYears(), is(365));
        assertThat(date1.daysInYears(), is(1461));
    }

    @Test
    public void shouldCalculateDaysInMonths() throws Exception {
        MyCalendar date = new MyCalendar(1902, 2, 1);
        MyCalendar date1 = new MyCalendar(1902, 3, 1);

        assertThat(date.daysInMonths(), is(31));
        assertThat(date1.daysInMonths(), is(59));
    }

    @Test
    public void shouldCalculateDaysFromBaseDate() {
        MyCalendar date1 = new MyCalendar(1901, 1, 1);
        MyCalendar date2 = new MyCalendar(1901, 1, 2);
        MyCalendar date3 = new MyCalendar(1901, 1, 31);
        MyCalendar date4 = new MyCalendar(1901, 2, 1);
        MyCalendar date5 = new MyCalendar(1901, 2, 2);
        MyCalendar date6 = new MyCalendar(1902, 1, 1);

        assertThat(date1.daysFromBaseDate(), is(0));
        assertThat(date2.daysFromBaseDate(), is(1));
        assertThat(date3.daysFromBaseDate(), is(30));
        assertThat(date4.daysFromBaseDate(), is(31));
        assertThat(date5.daysFromBaseDate(), is(32));
        assertThat(date6.daysFromBaseDate(), is(365));
    }

    @Test
    public void shouldParseValidDateString() throws Exception {
        MyCalendar date = MyCalendar.parseDateString("2000-01-08");

        assertThat(date.getDay(), is(8));
        assertThat(date.getMonth(), is(1));
        assertThat(date.getYear(), is(2000));
    }

    @Test
    public void shouldThrowExceptionForInvalidDateString() throws Exception {
        expectedException.expect(DateCalculatorException.class);
        MyCalendar.parseDateString("2000/1/15");
    }

    @Test
    public void shouldThrowExceptionForIllegalDateArguments() throws Exception {
        expectedException.expect(DateCalculatorException.class);
        MyCalendar.parseDateString("1999-2-29");
    }
}