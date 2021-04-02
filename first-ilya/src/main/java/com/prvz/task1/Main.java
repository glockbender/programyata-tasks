package com.prvz.task1;

import com.prvz.utils.IOUtils;

public class Main {

    public static void main(String[] args) {

        String arrayIn = IOUtils.readLineFromConsole(
            "Enter a sorted array to search and press \"Enter\" key.\nNote numbers must be divided by ','"
        );
        String findIn = IOUtils.readLineFromConsole(
            "Enter the desired number and press \"Enter\" key"
        );

        int[] arrayTransformed = IOUtils.readStringAsIntArray(arrayIn, ",");

        int findTransformed;
        try {
            findTransformed = Integer.parseInt(findIn);
        } catch (NumberFormatException nfe) {
            System.err.println("Illegal desired value: " + findIn);
            return;
        }

        BinarySearchJava binSearch = new BinarySearchJava();

        boolean foundBinary = binSearch.search(arrayTransformed, findTransformed);

        // Сокращенная форма if. Почитать про тернарный оператор
        String resultMessage = foundBinary ? "WAS FOUND" : "WAS NOT FOUND";

        System.out.println("Number: " + findIn + " " + resultMessage + " in the entered array");
    }
}
