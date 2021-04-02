package com.prvz.task3;

import com.prvz.utils.IOUtils;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        String arrayIn = IOUtils.readLineFromConsole(
            "Enter a integer array to search and press \"Enter\" key.\nNote numbers must be divided by ','"
        );

        Integer[] arrayTransformed = IOUtils.readStringAsIntegerArray(arrayIn, ",");

        Integer[] result = new QuickSortJava().quickSortRecursive(arrayTransformed, QuickSortJava.Sort.ASC);

        System.out.println("Sorted array:");
        System.out.println(Arrays.stream(result).map(String::valueOf).collect(Collectors.joining(",")));

    }

}
