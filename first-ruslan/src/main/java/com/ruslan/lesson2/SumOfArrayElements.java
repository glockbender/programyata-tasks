package com.ruslan.lesson2;

public class SumOfArrayElements {

    public static int simpleArraySum(int[] ar) {

        if(ar == null) {
            return 0;
        }

        int sum = 0;

        for (int i = 0; i < ar.length; i++) {

            sum = sum + ar[i];

        }
        return sum;


    }


}
