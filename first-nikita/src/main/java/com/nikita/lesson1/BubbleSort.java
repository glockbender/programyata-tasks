package com.nikita.lesson1;

public class BubbleSort {
    public void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if( array[i]>array[j]) {
                    swap(array, i, j);
                }


            }
        }
    }

    private void swap(int[] array, int from, int last) {
        int temp = array[from];
        array[from] = array[last];
        array[last] = temp;

    }
}


