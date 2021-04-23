package com.nikita.lesson3.homework3;

import java.time.LocalDate;

public class HackerRankDateAndTime {
    public static String findDay(int month, int day, int year) {
        LocalDate date = LocalDate.of(year, month, day);
        return date.getDayOfWeek().toString();
    }

    public static void main(String[] args) {

        System.out.println(findDay(6, 11, 2020));
    }
}

