package com.ruslan.lesson1.homework.selectionsort;

import java.util.Arrays;

public class SelectionSortMain {

    public static void main(String[] args) {

        int[] array = new int[]{22, 21, 11, 7, 5, 10, 15, 4};

        SelectionSort.sort(array);

        System.out.println(Arrays.toString(array));

    }
}
