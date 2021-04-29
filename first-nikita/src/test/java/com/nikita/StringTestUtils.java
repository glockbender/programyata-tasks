package com.nikita;

import java.util.Random;

public class
StringTestUtils {


    public static String generateStringRandom(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        if (length <= 0) {
            throw new IllegalArgumentException("string length must be greater than zero");
        }
        Random random = new Random();
        StringBuilder strbuld = new StringBuilder();
        for (int i = 0; i < length; i++) {
            strbuld.append(characters.charAt(random.nextInt(characters.length())));
        }
        return strbuld.toString();
    }

    public static void main(String[] args) {
        String string = generateStringRandom(25);
        System.out.println(string);
    }
}
