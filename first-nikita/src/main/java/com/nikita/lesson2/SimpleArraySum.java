package com.nikita.lesson2;

public class SimpleArraySum {

    public static int simpleArraySum(int[] ar) {
        if (ar == null) {
            return 0;
        }
        int sum = 0;
        for (int j : ar) {
            sum = sum + j;
        }
        return sum;
    }
}
