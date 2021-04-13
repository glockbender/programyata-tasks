package com.ruslan.lesson3;

public class CloudsGame {

    public static int jumps(int[] array) {

        int jumpsValue = 1;

        for (int i = 2; i < array.length-1; i = i + 2) {

            if (array[i] == 1) {
                i--;

            }

            jumpsValue++;

        }

        return jumpsValue;
    }

    public static void main(String[] args) {

        int[] clouds = new int[]{0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0};

        System.out.println(CloudsGame.jumps(clouds));

    }

}
