package com.nikita.lesson2;

public class SimpleArraySum {
  
    static int simpleArraySum(int[] ar) {
        int sum=0;
        for (int j : ar) {
            sum = sum + j;
        }
        return sum;
    }
}
