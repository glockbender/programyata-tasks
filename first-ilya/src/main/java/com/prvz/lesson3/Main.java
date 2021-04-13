package com.prvz.lesson3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

//        byte age = (byte) 29;
//
//        int i = Integer.MAX_VALUE;
//
//        if (User.MINIMUM_AGE > age) {
//            System.out.println("NO YOU'RE SO YOUNG. DON't see the porn");
//        }
//
//        byte age2 = (byte) -1;
//
//        if (age2 < 0) {
//            age2 = User.MINIMUM_AGE;
//        }
//
//
//        User user = new User("Ruslan", "Bychkov", age);
//
//        User user1 = new User("Nikita", "Maltsev", age2);
//
//        user.getFirstname();
//
//        user1.getFirstname();
//
//        User user2 = new User();
//
//        System.out.println(user2.getAge());
//        System.out.println(user2.getFirstname());
//        System.out.println(user2.getLastname());
//
//        String s = "     ";
//
//        System.out.println(StringUtils.isBlank(s));
//
//        int[] ints = ArrayUtils.parseStringToIntArray("1 2 3 4 5 6", " ");
//
//        System.out.println();


        String s1 = "aaabbbbaaaaccc"; // 7a 4b 3c

        Map<Character, Integer> dictionary = new HashMap<>();

        for (Character ch: s1.toCharArray()) {

            Integer counter = dictionary.get(ch);

            if (counter == null) {
                dictionary.put(ch, 1);
            } else {
                dictionary.put(ch, counter + 1);
            }

        }

        List<Integer> list;
        // 1, 2, 3, 2, 1, 3...

        Set<Integer> set;

        // 1, 2, 3, 2, 1, 3, 4, 4, 5
        // 1, 2, 3, 4, 5

        // entry = key->value
        for (Map.Entry<Character, Integer> entry: dictionary.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }


    }

}
