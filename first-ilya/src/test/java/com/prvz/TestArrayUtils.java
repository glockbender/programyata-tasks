package com.prvz;

import java.util.Arrays;
import java.util.Random;

public class TestArrayUtils {

    /**
     * Создать упорядоченный массив с from до to элемента
     *
     * @param from первый элемент в массиве
     * @param to   последний элемент в массиве
     * @return созданный упорядоченный массив
     */
    public static int[] generateArray(int from, int to) {

        int length = Math.abs(to - from) + 1;

        int[] result = new int[length];

        boolean plusOrMinus = from - to < 0;

        int value = from; // 20
        for (int i = 0; i < result.length; i++) {
            if (plusOrMinus) {
                result[i] = value++;
            } else {
                result[i] = value--;
            }
        }

        return result;

    }

    public static int[] generateRandomArray(int from, int to, int length) {

        Random rnd = new Random();

        if (from > to) {
            throw new IllegalArgumentException("'from' must be more than 'to'");
        }

        int mod = to - from + 1;

        int[] result = new int[length];

        for (int i = 0; i < result.length; i++) {
            //bound = 100 -> 0..99
            //bound = 11 -> 0..10
            // 10 + 0..10
            result[i] = from + rnd.nextInt(mod);
        }

        return result;

    }

    public static int[] copyAndShuffle(int[] array) {

        // 1. скопировать array в отдельный массив
        // 2. Перемешать значения внутри скопированного массива

        // array.length = 100
        //

        int length = array.length; // 100
        int[] result = Arrays.copyOf(array, length);

        Random random = new Random();

        for (int i = 0; i < length / 2; i++) {

            int idx1 = random.nextInt(length); // 0..99
            int idx2 = random.nextInt(length); // 0..99

            int temp = result[idx1];
            result[idx1] = result[idx2];
            result[idx2] = temp;

        }

        return result;

        //** 1. Создать новый пустой массив размером с array
        //** 2. Добавить все элементы array в случайном порядке

    }

}
