package com.prvz.lesson3;

public class Main {

    public static void main(String[] args) {

        byte age = (byte) 29;

        int i = Integer.MAX_VALUE;

        if (User.MINIMUM_AGE > age) {
            System.out.println("NO YOU'RE SO YOUNG. DON't see the porn");
        }

        byte age2 = (byte) -1;

        if (age2 < 0) {
            age2 = User.MINIMUM_AGE;
        }


        User user = new User("Ruslan", "Bychkov", age);

        User user1 = new User("Nikita", "Maltsev", age2);

        user.getFirstname();

        user1.getFirstname();

        User user2 = new User();

        System.out.println(user2.getAge());
        System.out.println(user2.getFirstname());
        System.out.println(user2.getLastname());

        String s = "     ";

        System.out.println(StringUtils.isBlank(s));

        int[] ints = ArrayUtils.parseStringToIntArray("1 2 3 4 5 6", " ");

        System.out.println();


    }

}
