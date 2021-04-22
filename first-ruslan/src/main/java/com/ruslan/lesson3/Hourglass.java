package com.ruslan.lesson3;

public class Hourglass {

    public static int hourglass(int[][] array) {


        int resultSum = -65;

        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 4; j++) {

                int innerSum = 0;

                innerSum = array[i][j] + array[i][j + 1] + array[i][j + 2] + array[i + 1][j + 1] + array[i + 2][j] + array[i + 2][j + 1] + array[i + 2][j + 2];
                if (innerSum > resultSum) {
                    resultSum = innerSum;
                }
            }

        }

        return resultSum;

    }

    public static void main(String[] args) {

        int[][] sixTimesSix = new int[][]{{-1, -1, 0, -9, -2, -2}, {-2, -1, -6, -8, -2, -5}, {-1, -1, -1, -2, -3, -4}, {-1, -9, -2, -4, -4, -5}, {-7, -3, -3, -2, -9, -9}, {-1, -3, -1, -2, -4, -5}};

        System.out.println(Hourglass.hourglass(sixTimesSix));

    }

}
