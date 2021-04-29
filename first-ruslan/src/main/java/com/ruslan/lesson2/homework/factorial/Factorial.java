package com.ruslan.lesson2.homework.factorial;

public class Factorial {

    public static int factorial(int n) {

        if (n<0) {
            return -1;
        }

        int start = 1;
        int result = 1;

        while (start < n) {
            start = start + 1;
            result = result * start;
        }

        return result;

    }

    public static void main(String[] args) {

        int n = 9;

        System.out.println(Factorial.factorial(n));

    }


}
