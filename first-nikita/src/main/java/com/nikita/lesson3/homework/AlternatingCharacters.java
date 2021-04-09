package com.nikita.lesson3.homework;

public class AlternatingCharacters {
    static int alternatingCharacters(String s) {
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
