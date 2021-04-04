package com.prvz.lesson1;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] array = new int[] {5,3,4,6,2,1};

        new BubbleSort().sort(array);

        System.out.println(Arrays.toString(array));

    }

}
