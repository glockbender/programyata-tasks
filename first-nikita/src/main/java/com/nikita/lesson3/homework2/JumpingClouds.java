package com.nikita.lesson3.homework2;

public class JumpingClouds {
    static int jumpingOnClouds(int[] array) {
        if (array.length == 1) {
            return 0;
        }
        if (array.length == 2) {
            return 1;
        }
        int count = 0;
        for (int i = 2; i < array.length - 1; ) {
            if (array[i] == 1) {
                i--;
            } else {
                i = i + 2;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] array = new int[]{0, 1, 0, 0, 0, 1, 0};
        System.out.println(jumpingOnClouds(array));
        int[] array1 = new int[]{0, 1, 0, 0};
        System.out.println(jumpingOnClouds(array1));
        int[] array2 = new int[]{0, 1, 0, 0, 1, 0, 0};
        System.out.println(jumpingOnClouds(array2));
        int[] array3 = new int[]{0, 1, 0, 0, 1, 0, 1, 0, 0};
        System.out.println(jumpingOnClouds(array3));

    }
}
/*int count = 0;
        for (int i = 0; i < array.length - 1; ) { //

            if (i >= array.length - 2) {
                count++;
                break;
            }
            int afterNext = array[i + 2];
            if (afterNext == 0) {
                i = i + 2;
                count++;
            } else {
                i = i + 1;
                count++;
            }
        }
        return count;*/

