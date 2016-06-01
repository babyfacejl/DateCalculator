package com.tools.utils;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DateValidatorTest {
    @Test
    public void shouldValidateDateInputFormat() throws Exception {
        assertFalse(DateValidator.isValidDateFormat(null));
        assertFalse(DateValidator.isValidDateFormat(""));
        assertFalse(DateValidator.isValidDateFormat("2001/12/30"));
        assertTrue(DateValidator.isValidDateFormat("2001-01-01"));
        assertTrue(DateValidator.isValidDateFormat("2001-12-30"));
    }

    @Test
    public void shouldValidateDateInput() throws Exception {
        assertTrue(DateValidator.isValidDateInput(1901, 1, 1));
        assertTrue(DateValidator.isValidDateInput(2999, 12, 31));
        assertTrue(DateValidator.isValidDateInput(2999, 5, 1));
        assertTrue(DateValidator.isValidDateInput(2000, 2, 29));
        assertTrue(DateValidator.isValidDateInput(2000, 2, 28));

        assertFalse(DateValidator.isValidDateInput(2000, 2, 30));
        assertFalse(DateValidator.isValidDateInput(1900, 12, 31));
        assertFalse(DateValidator.isValidDateInput(1999, 2, 29));
        assertFalse(DateValidator.isValidDateInput(3000, 1, 1));
        assertFalse(DateValidator.isValidDateInput(1999, 1, 32));
        assertFalse(DateValidator.isValidDateInput(1998, 3, 32));
    }
}