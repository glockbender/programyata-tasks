package com.ruslan.lesson2;

public class SumOfArrayElements {

    static int simpleArraySum(int[] ar) {

        int sum = 0;

        for (int i = 0; i < ar.length; i++) {

            sum = sum + ar[i];

        }
        return sum;


    }


}
