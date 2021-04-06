package com.nikita.homework.selectionsort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{1, 4, 3, 6, 5, 9, 7, 8, 2};
        new SelectionSort().sort(array);
        System.out.println(Arrays.toString(array));
    }

}
