package com.ruslan.lesson2.homework.rle;

public class AlternatingCharacters {

    static int alternatingCharacters(String s) {

        char[] chars = s.toCharArray();

        int counter = 0;

        if (chars.length > 1) {
            for (int i = 0; i < chars.length-1; i++) {
                if (chars[i] == chars[i + 1]) {
                    counter++;
                }
            }
        } else {
            counter = 0;
        }

        return counter;

    }

    public static void main(String[] args) {
        String input = "AABBAB";
        System.out.println(AlternatingCharacters.alternatingCharacters(input));
    }

}


