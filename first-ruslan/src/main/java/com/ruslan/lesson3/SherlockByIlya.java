package com.ruslan.lesson3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SherlockByIlya {

    public static String sherlock(String input) {

        Map<Character, Integer> dictionary = new HashMap<>();

        Integer max = 0;

        for (Character ch : input.toCharArray()) {

            Integer count = dictionary.get(ch);

            if (count == null) {
                dictionary.put(ch, 1);
            } else {
                dictionary.put(ch, ++count);
                if (count > max) {
                    max = count;

                }
            }

        }

        Integer min = max;
        Integer groupOfMax = 0;

        for (Integer j : dictionary.values()) {

            if (j.equals(max)) {
                groupOfMax++;
            }

            if (j < min) {
                min = j;
            }

        }

        // aaaabbbbc
        Integer totalMinLength = input.length() - max * groupOfMax;

        if (max - min > 1) {
            if (totalMinLength == 1) {
                return "YES";
            } else {
                return "NO";
            }
        } else if (max.equals(min)) {
            return "YES";
        } else if (max - min == 1 && groupOfMax.equals(1)) {
            return "YES";
        }

        return "NO";

    }

    public static void main(String[] args) {
        List<String> examples = new ArrayList<>();
        examples.add("aabbccc");
        examples.add("aaabbbcc");
        examples.add("aaabbbccdd");
        examples.add("aaabbbc");

        for (String s : examples) {
            System.out.println(SherlockByIlya.sherlock(s));
        }


    }

}

