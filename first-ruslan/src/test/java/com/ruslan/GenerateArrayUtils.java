package com.ruslan;

import java.util.Arrays;
import java.util.Random;

public class GenerateArrayUtils {

    // from 10 to 90
    public static int[] sortedArray(int from, int to) {

        int length = Math.abs(to - from) + 1;

        int[] array = new int[length];

        int start = from;

        for (int i = 0; i < array.length; i++) {
            array[i] = start;
            if (from > to) {
                start--;
            } else {
                start++;
            }
        }
        return array;
    }

    // from 10 to 30 length 50
    public static int[] randomElementsArray(int from, int to, int length) {

        if (from > to) {
            throw new IllegalArgumentException("'from' must be less than 'to'");
        }

        int[] array = new int[length];

        Random rnd = new Random();

        int mod = to - from + 1;

        for (int i = 0; i < array.length; i++) {

            array[i] = from + rnd.nextInt(mod);

        }

        return array;

    }

    public static int[] copyAndShuffleArray(int[] array) {

        int[] resultArray = Arrays.copyOf(array, array.length);

        Random random = new Random();

        for (int i = 0; i < resultArray.length / 2; i++) {

            int rIdx1 = random.nextInt(resultArray.length);
            int rIdx2 = random.nextInt(resultArray.length);

            int temp = resultArray[rIdx1];
            resultArray[rIdx1] = resultArray[rIdx2];
            resultArray[rIdx2] = temp;

        }

        return resultArray;

    }

}
