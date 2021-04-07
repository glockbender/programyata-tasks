package com.nikita.lesson2;

public class FactorialSum {
    public static int factorialsum(int i) {
        int resultal = 1;
        for (int j = 1; j <= i; j++) {
            resultal = resultal * j;
        }
        return resultal;
    }

    public static void main(String[] args) {
        System.out.println(factorialsum(5));
    }
}
