package com.prvz.draft;

public class FizzBuzz {

    /**
     * Write a program that prints out the numbers from 1 through 100, but…
     *
     * For numbers that are multiples of 3, print “Fizz” instead of the number.
     * For numbers that are multiples of 5, print “Buzz” instead of the number
     * For numbers that are multiples of both 3 and 5, print “FizzBuzz” instead of the number.
     * That’s it!
     */
    public static void fizzBuzz() {

        for (int i = 1; i <= 100; i++) {

            boolean fizz = i % 3 == 0;
            boolean buzz = i % 5 == 0;

            if (fizz && buzz) {
                System.out.println("FizzBuzz");
            } else if (buzz) {
                System.out.println("Buzz");
            } else if (fizz) {
                System.out.println("Fizz");
            } else {
                System.out.println(i);
            }

        }

    }

    public static void main(String[] args) {
        fizzBuzz();
    }

}
