package com.ruslan.lesson3;

public class CloudsGame {

    public static int jumps(int[] array) {

        if (array == null || array.length == 0 || array.length == 1 || array[0] == 1 || array[array.length - 1] == 1) {
            return 0;
        }
        if(array.length == 2) {
            return 1;
        }
        for (int j = 0; j < array.length-1; j++) {
            if(array[j] == array[j+1] & array[j] == 1){
                return 0;
            }
        }

        int jumpsValue = 1;

        for (int i = 2; i < array.length - 1; i = i + 2) {

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
