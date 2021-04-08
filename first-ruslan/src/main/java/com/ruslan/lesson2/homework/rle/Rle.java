package com.ruslan.lesson2.homework.rle;

public class Rle {

    /*
    AABBBBCCCCCCDDDEELVCNNNN
    A2B4C6D3E2LVCN4
    */
    public String zip(String unzipped) {

        String result = "";


        char[] chars = unzipped.toCharArray();

        for (int i = 0; i < chars.length - 1; i++) {

            int counter = 1;

            char element = chars[i];

            char nextElement = chars[i + 1];


            if (element == nextElement && i < chars.length - 1) {

                counter++;
                

            } else if (counter > 1) {
                String add = element + Integer.toString(counter);
                result = result + add;
                counter = 1;
            }


        }

        return result;

    }

    public static void main(String[] args) {

        String unzipped = "AABBBBCCCCCCDDDEELVCNNNN";

        System.out.println(new Rle().zip(unzipped));
    }

}
