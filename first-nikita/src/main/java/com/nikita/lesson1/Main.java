package com.nikita.lesson1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 6, 4, 8, 5, 7, 9, 2};
        BubbleSort.sort(array);
        System.out.println(Arrays.toString(array));

    }
}
