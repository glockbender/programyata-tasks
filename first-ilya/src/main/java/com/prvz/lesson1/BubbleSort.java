package com.prvz.lesson1;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

// (3)(5)(4)
//
public class BubbleSort {

    public void sort(@Nullable int[] array) {

        if (array == null) {
            return;
        }

        for (int i = 0; i < array.length; i++) {

            for (int j = i + 1; j < array.length; j++) {

                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }

            }

        }
    }

    public static void main(String[] args) {

        int[] arr = null;

        new BubbleSort().sort(arr);

    }

}
