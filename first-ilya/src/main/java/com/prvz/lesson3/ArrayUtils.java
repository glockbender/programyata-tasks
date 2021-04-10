package com.prvz.lesson3;

public class ArrayUtils {

    public static int[] parseStringToIntArray(String str, String splitter) {

        String[] split = str.split(splitter);

        int[] result = new int[split.length];

        for (int i = 0; i < split.length; i++) {
            result[i] = Integer.parseInt(split[i].trim());
        }

        return result;

    }

}
