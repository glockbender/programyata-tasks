package com.nikita.lesson3.homework;

public class AlternatingCharacters {
    public static int alternatingCharacters(String s) {
        if (s == null || s.isEmpty ()) {
            return -1;

        }
        char[] chars = s.toCharArray();
        int result = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            int current = chars[i];
            int nextCurrent = chars[i + 1];
            if (current == nextCurrent) {
                result++;
            }
        }
        if (s.length() == 1)
            return 0;
        return result;
    }

    public static void main(String[] args) {
        String stroka = "ADDDDD";
        System.out.println(alternatingCharacters(stroka));
    }
}
