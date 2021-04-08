package com.nikita.lesson2;

public class Rle {

    /*
     AABBBBCCCCCCDDDEELVCNNNN
     A2B4C6D3E2LVCN4
     */
    public String zip(String unzipped) {
        if (unzipped.length() == 1) {
            return unzipped;
        }
        StringBuilder result = new StringBuilder();
        char[] chars = unzipped.toCharArray();
        int counter = 1;
        for (int i = 0; i < chars.length - 1; i++) {
            // проверка последнего символа
            char element = chars[i];
            char nextElement = chars[i + 1];
            if (element == nextElement) {
                counter++;
            } else {
                result.append(element);
                if (counter > 1) {
                    result.append(counter);
                }
                counter = 1;
            }
        }
        result.append(chars[chars.length - 1]);
        if (counter > 1) {
            result.append(counter);
        }
        return result.toString();
    }

    public static void main(String[] args) {

        String unzipped = "AABBBBCCCCCCDDDEELVCNNNN";
        System.out.println(new Rle().zip(unzipped));
    }
}
