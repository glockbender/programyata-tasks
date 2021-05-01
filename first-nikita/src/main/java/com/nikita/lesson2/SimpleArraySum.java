package com.nikita.lesson2;

public class SimpleArraySum {

    public static int simpleArraySum(int[] ar) {
        if (ar == null || ar.length==0) {
            return 0;
        }
        int sum = 0;
        for (int j : ar) {
            sum = sum + j;
        }
        return sum;
    }
}
