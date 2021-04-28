package com.nikita.lesson1;

public class BubbleSort  {
    public static void sort(int[] array) {
        if (array == null) {
            return;
        }
            for (int i = 0; i < array.length; i++) {
                for (int j = i + 1; j < array.length; j++) {
                    if (array[i] > array[j]) {
                        swap(array, i, j);
                    }
                }
            }
    }

    private static void swap(int[] array, int from, int to) {
        int temp = array[from];
        array[from] = array[to];
        array[to] = temp;

    }
}


