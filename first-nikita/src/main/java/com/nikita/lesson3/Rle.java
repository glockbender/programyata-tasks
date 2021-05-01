package com.nikita.lesson3;

import java.time.LocalDate;

public class Rle {
    public static String zip(String unzipped) {

        if (unzipped==null || unzipped.isEmpty()){
            return "";
        }
        if (unzipped.length() == 1) {
            return unzipped;
        }

        char[] chars = unzipped.toCharArray();
        StringBuilder result = new StringBuilder();
        char pivot = chars[0];
        int count = 1;

        for (int i = 1; i < chars.length; i++) {
            char current = chars[i];

            if (current == pivot) {
                count++;
            } else {
                result.append(pivot);
                if (count > 1) {
                    result.append(count);
                }
                pivot = current;
                count = 1;
            }
        }
        result.append(pivot);
        if (count > 1) {
            result.append(count);
        }
        return result.toString();
    }

    // EXTRA RLE!!!!!!!!!!!!!!!!!!!!!!!!!!
    public static String unzipped(String zip) {
        char[] chars = zip.toCharArray();
        StringBuilder resultzip = new StringBuilder();
        char pivotzip = chars[0];
        int count = 1;

        for (int i = 1; i < chars.length; i++) {
            char current = chars[i];

            if (Character.isDigit(current)) {
                int counterChar = Character.getNumericValue(current);
                for (int j = 1; j < counterChar; j++) {
                    resultzip.append(pivotzip);
                }
            } else {
                resultzip.append(pivotzip);
                pivotzip = current;
            }
        }
        resultzip.append(pivotzip);
        return resultzip.toString();
    }

    public static void main(String[] args) {
        String stroka = "AAAABBBRRAKADDABBBRANNNNAAAAAX";
        Rle rle = new Rle();
        System.out.println(stroka);
        System.out.println(rle.zip(stroka));
        System.out.println(rle.unzipped(stroka));

    }

}
