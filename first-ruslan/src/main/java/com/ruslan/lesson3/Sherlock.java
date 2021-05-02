package com.ruslan.lesson3;

import java.util.Arrays;

public class Sherlock {

    public static String sort(String unsorted) {

        char[] chars = unsorted.toCharArray();

        StringBuilder sorted = new StringBuilder();

        Arrays.sort(chars);

        sorted.append(chars);

        return sorted.toString();

    }

    public static String zip(String unzipped) {

        char[] chars = unzipped.toCharArray();

        StringBuilder zipped = new StringBuilder();

        char pivot = chars[0];

        int counter = 1;

        if (chars.length == 1) {
            counter = 1;
            zipped.append(counter);
        }

        for (int i = 1; i < chars.length; i++) {

            char current = chars[i];

            if (current == pivot) {

                counter++;

            } else {
                zipped.append(counter);
                counter = 1;

            }
            pivot = current;

            if (i == chars.length - 1) {

                zipped.append(counter);

            }


        }

        return zipped.toString();
    }


    public static void main(String[] args) {
        String str = "abbac";
        String sorted = Sherlock.sort(str);
        String zipped = Sherlock.zip(sorted);
        String sortedZipped = Sherlock.sort(zipped);

        System.out.println(sorted);
        System.out.println(zipped);
        System.out.println(sortedZipped);

        char[] chars = sortedZipped.toCharArray();

        int counter = 0;
        int pivot = chars[0];


        for (int i = 0; i < chars.length; i++) {

            char current = chars[i];

            if (current != pivot) {

                counter++;

            }

            pivot = current;


            if (i == chars.length - 1) {

                System.out.println(counter);

            }

        }

        if (counter > 1) {
            System.out.println("NO");
        } else if (chars.length <= 1) {
            System.out.println("YES");
        } else if (counter == 0) {
            System.out.println("YES");
        } else if (chars[0] == chars[1] & chars[chars.length - 1] == chars[chars.length - 2] & counter > 0) {
            System.out.println("NO");
        } else if (chars[0] == '1' | chars[chars.length - 1] - chars[chars.length - 2] == 1) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

}
