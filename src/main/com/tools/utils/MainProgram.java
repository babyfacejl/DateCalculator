package com.tools.utils;

import com.tools.utils.Exception.DateCalculatorException;

import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter start date: ");
        String startDateString = reader.nextLine();

        System.out.println("Enter end date: ");
        String endDateString = reader.nextLine();

        try {
            MyCalendar startDate = MyCalendar.parseDateString(startDateString);
            MyCalendar endDate =  MyCalendar.parseDateString(endDateString);

            System.out.println(String.format("%s - %s: %d days", startDateString.trim(), endDateString.trim(), DateCalculator.calculateFullDays(startDate, endDate)));
            System.exit(0);
            
        } catch (DateCalculatorException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
}
