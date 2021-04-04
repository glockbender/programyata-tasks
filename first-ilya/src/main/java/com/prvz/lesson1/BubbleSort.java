package com.prvz.lesson1;

// (3)(5)(4)
//
public class BubbleSort {

    public void sort(int[] array) {

        for (int i = 0; i < array.length; i++) {

            for (int j = i + 1; j < array.length; j++) {

                if (array[i] > array[j]) {
                    swap(array, i, j);
                }

            }

        }

    }

    private void swap(int[] array, int from, int to) {

        int temp = array[from];
        array[from] = array[to];
        array[to] = temp;

    }

}
