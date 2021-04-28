package com.ruslan.lesson1;

public class BubbleSort {

    public void sort(int[] array) {

        if(array == null) {
            return;
        }

        for (int i = 0; i < array.length; i++) {

           for (int j = 0; j < array.length; j++) {

                if (array[i]<array[j]) {
                    swap(array, i, j);
                }

            }

        }

    }

    public static void swap(int[] array, int from, int to) {

        int temp = array[from];
        array[from] = array[to];
        array[to] = temp;

    }

}
