package com.prvz.lesson1.homework.selectionsort;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] array = new int[]{6, 5, 7, 8, 3, 1, 2, 0, 4};
        new SelectionSort().sort(array);
        System.out.println(Arrays.toString(array));

    }

    public void sort(int[] array) {

        for (int i = 0; i < array.length; i++) {

            for (int j = i + 1; j < array.length; j++) {

                int minIdx = i;

                if (array[j] < array[minIdx]) {
                    minIdx = j;
                }

                int temp = array[i];
                array[i] = array[minIdx];
                array[minIdx] = temp;

            }

        }

    }


}
