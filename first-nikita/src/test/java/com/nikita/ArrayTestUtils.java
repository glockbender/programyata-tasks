package com.nikita;

import java.util.Random;

public class ArrayTestUtils {
    // 10..20
    // 20..10

    public static int[] generate(int from, int to) {
        int length = Math.abs(from - to) + 1;
        int start = from;
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            if (from < to) {
                array[i] = start++;
            } else {
                array[i] = start--;
            }
        }
        return array;
    }


    // 10..20 , length 11
    public static int[] generateRandom(int from, int to, int length) {
        if (from > to) {
            throw new IllegalArgumentException("'from must be less than 'to");
        }
        Random random = new Random();
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(to - from + 1);
        }
        return array;
    }
}
