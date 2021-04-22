package com.nikita.lesson3.homework3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class HackerRankDateAndTime {
    public static String findDay(int month, int day, int year) {
        LocalDate date = LocalDate.of(year, month, day);
        return ""+ date.getDayOfWeek();
    }

    public static void main(String[] args) {

        System.out.println(findDay(6,11,2020));
    }
}

