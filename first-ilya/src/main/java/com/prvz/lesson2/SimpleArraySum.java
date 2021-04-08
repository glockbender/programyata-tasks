package com.prvz.lesson2;

public class SimpleArraySum {

    /*
     * Complete the simpleArraySum function below.
     */
    static int simpleArraySum(int[] ar) {
        /*
         * Write your code here.
         */

        int result = 0;

        for (int j : ar) {
            result = result + j;
        }

        return result;

    }

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 4, 5};

        System.out.println(simpleArraySum(arr));

    }

}
