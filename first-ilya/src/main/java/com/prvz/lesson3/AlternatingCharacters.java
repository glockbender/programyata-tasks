package com.prvz.lesson3;

public class AlternatingCharacters {

    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {

        if (s.length() == 1) {
            return 0;
        }

        if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return 0;
            } else {
                return 1;
            }
        }

        char[] toChars = s.toCharArray();

        int result = 0;

        for (int i = 0; i < toChars.length - 1; i++) {

            int current = toChars[i];
            int next = toChars[i + 1];

            if (current == next)
                result ++;

        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(alternatingCharacters("AAABBABAAABAAABBBA"));
    }

}
