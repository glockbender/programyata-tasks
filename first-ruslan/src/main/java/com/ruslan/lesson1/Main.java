package com.ruslan.lesson1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] array = new int[] {22, 44, 23, 51, 49, 100, 2};

        new BubbleSort().sort(array);

        System.out.println(Arrays.toString(array));

    }
}
