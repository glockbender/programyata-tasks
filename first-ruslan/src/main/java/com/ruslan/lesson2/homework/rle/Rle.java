package com.ruslan.lesson2.homework.rle;

public class Rle {

    public static String zip(String unzipped) {

        if (unzipped == null || unzipped.isEmpty()) {
            return "";
        }


        char[] chars = unzipped.toCharArray();

        StringBuilder result = new StringBuilder();

        char pivot = chars[0];

        int counter = 1;

        for (int i = 1; i < chars.length; i++) {

            char current = chars[i];

            if (current == pivot) {

                counter++;

            } else {
                result.append(pivot);
                if (counter > 1) {
                    result.append(counter);
                    counter = 1;
                }

            }
            pivot = current;

            if (i == chars.length - 1) {

                result.append(pivot);
                if (counter > 1) {
                    result.append(counter);
                    counter = 1;
                }
            }

        }

        return result.toString();

    }

    public static String unzip(String zipped) {

        if (zipped == null || zipped.isEmpty()) {
            return "";
        }

        char[] chars = zipped.toCharArray();

        StringBuilder result = new StringBuilder();

        StringBuilder multiplier = new StringBuilder();

        char pivot = chars[0];

        for (int i = 1; i < chars.length; i++) {

            char current = chars[i];



            if (Character.isDigit(chars[i])) {

                while (Character.isDigit(chars[i])) {

                    multiplier.append(chars[i]);
                    i++;


                    if (i == chars.length)
                        break;

                }

                int k = Integer.parseInt(multiplier.toString());

                for (int j = 0; j < k - 1; j++) {

                    result.append(pivot);

                }

                multiplier.delete(0, multiplier.length());


            } result.append(pivot);

            if (i < chars.length) {

                pivot = chars[i];

            }


        }

        if (Character.isLetter(chars[chars.length-1])) {
            result.append(chars[chars.length-1]);
        }

        return result.toString();

    }

    public static void main(String[] args) {

        String unzipped = "AABBBBCCCCCCCCCCDDDEELVCNNNN";
        String zipped = new Rle().zip(unzipped);

        System.out.println(new Rle().zip(unzipped));
        System.out.println(new Rle().unzip(zipped));
    }

}
