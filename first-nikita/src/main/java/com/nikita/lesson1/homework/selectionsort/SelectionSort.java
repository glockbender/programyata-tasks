package com.nikita.lesson1.homework.selectionsort;

public class SelectionSort {
    public void sort(int[] array) {
        if (array == null) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = min + 1; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }

            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }
}
