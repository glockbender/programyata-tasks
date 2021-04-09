package com.nikita.lesson1.homework.selectionsort;

public class SelectionSort {
    public void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = min+1; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            swap(array, i, min);
        }
    }

    public void swap(int[] array, int from, int last) {
        int temp = array[from];
        array[from] = array[last];
        array[last] = temp;
    }


}
