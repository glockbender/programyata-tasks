package com.prvz.lesson1.homework.selectionsort;

import com.prvz.utils.ArrayUtils;

import java.util.Arrays;

public class SelectionSort {

    public void sort(int[] array) {

        for (int i = 0; i < array.length; i++) {

            for (int j = i + 1; j < array.length; j++) {

                int minIdx = i;

                if (array[j] < array[minIdx]) {
                    minIdx = j;
                }

                ArrayUtils.swap(i, minIdx, array);

            }

        }

    }

    public static void main(String[] args) {
        int[] array = new int[] { 6,5,7,8,3,1,2,0,4 };
        new SelectionSort().sort(array);
        System.out.println(Arrays.toString(array));

    }


}