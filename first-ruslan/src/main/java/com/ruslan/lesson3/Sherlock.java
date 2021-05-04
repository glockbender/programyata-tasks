package com.ruslan.lesson3;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Sherlock {

    public static String sort(String unsorted) {

        char[] chars = unsorted.toCharArray();

        StringBuilder sorted = new StringBuilder();

        Arrays.sort(chars);

        sorted.append(chars);

        return sorted.toString();

    }

    public static int uniqueChars(String sorted) {

        int uniqueElements = 1;

        char[] chars = sorted.toCharArray();

        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] != chars[i + 1]) {
                uniqueElements++;
            }
        }

        return uniqueElements;

    }

    public static int[] numbersOfUniqueChars(int uniqueElements, String sorted) {

        int[] repeatsOAE = new int[uniqueElements];

        char[] chars = sorted.toCharArray();

        int counter = 1;
        int indexOfIntArr = 0;

        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                counter++;
            } else {
                repeatsOAE[indexOfIntArr] = counter;
                indexOfIntArr++;
                counter = 1;
            }
        }

        repeatsOAE[indexOfIntArr] = counter;

        Arrays.sort(repeatsOAE);

        return repeatsOAE;

    }

    public static boolean stringValidator(int[] repeatsOAE) {

        boolean answer = false;

        if (repeatsOAE.length == 1) {
            return true;
        }
        if (repeatsOAE.length == 2) {
            return Math.abs(repeatsOAE[1] - repeatsOAE[0]) == 1 || Math.abs(repeatsOAE[1] - repeatsOAE[0]) == 0;
        }

        int counterOfDiffers = 0;

        for (int i = 0; i < repeatsOAE.length - 1; i++) {
            if (repeatsOAE[i] != repeatsOAE[i + 1]) {
                counterOfDiffers++;
            }
        }
        if (counterOfDiffers == 0) {
            return true;
        }
        if (counterOfDiffers > 1) {
            return false;
        }

        int counter = 1;

        for (int j = 0; j < repeatsOAE.length - 1; j++) {
            if (repeatsOAE[j] == repeatsOAE[j+1]) {
                counter++;
            } else
                break;
        }

        answer = (repeatsOAE.length - counter == 1 && repeatsOAE[repeatsOAE.length-1] - repeatsOAE[repeatsOAE.length-2] == 1) || (repeatsOAE[0] == 1 && counter == 1);

        return answer;

    }

    public static String sherlock(@NotNull String unsorted) {

        if(unsorted.isEmpty()){
            return "string is Empty";
        }

        String sorted = sort(unsorted);


        int uniqueElements = uniqueChars(sorted);


        int[] repeatsOAE = numbersOfUniqueChars(uniqueElements, sorted);

        if (stringValidator(repeatsOAE)) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public static void main(String[] args) {

        String unsorted = "null";
        System.out.println("Are this string valid? " + sherlock(unsorted));

    }

}

