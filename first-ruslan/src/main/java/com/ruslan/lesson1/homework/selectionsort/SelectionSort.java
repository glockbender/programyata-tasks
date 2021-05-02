package com.ruslan.lesson1.homework.selectionsort;

public class SelectionSort {

    public static void sort(int[] array) {

        if(array == null) {
            return;
        }

        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    minIndex = j;
                }
            }

            int temp = array[i];
            array[i] = min;
            array[minIndex] = temp;

        }

    }

}
