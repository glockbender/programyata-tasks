package com.prvz.lesson2;

public class Rle {

    /*
     AABBBBCCCCCCDDDEELVCNNNN
     A2B4C6D3E2LVCN4
     */
    public String zip(String unzipped) {

        String result = "";

        char[] chars = unzipped.toCharArray();

        for (int i = 0; i < chars.length; i++) {

            int counter = 0;

            // проверка последнего символа

            char element = chars[i];
            char nextElement = chars[i + 1];

            if (element == nextElement) {
                counter++;
            } else {
                String add = "" + element + counter;
                result = result + add;
                counter = 0;

            }
        }

        return result;

    }

    public static void main(String[] args) {

        String unzipped = "AABBBBCCCCCCDDDEELVCNNNN";

        System.out.println(new Rle().zip(unzipped));
    }

}
