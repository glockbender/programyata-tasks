package com.prvz.lesson2;

public class Fact {

    public int factorial(int num) {

        int result = 1;

        for (int i = 1; i <= num; i++) {
            result *= i;
        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(new Fact().factorial(5));

        System.out.println(new Fact().factorial(10));
    }

}
