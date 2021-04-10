package com.prvz.lesson3;

public class StringUtils {

    private StringUtils() {}

    //"     "
    public static boolean isBlank(String s) {
        return s.trim().isEmpty();
    }

}
