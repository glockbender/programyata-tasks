package com.nikita.lesson3.homework2;

public class Array2D {
    public static int sumArray(int[][] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int maxSum = -63;
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                int center = array[i][j];
                int top = array[i - 1][j];
                int bottom = array[i + 1][j];
                int topLeft = array[i - 1][j - 1];
                int topRight = array[i - 1][j + 1];
                int bottomLeft = array[i + 1][j - 1];
                int bottomRight = array[i + 1][j + 1];

                int sumAr = center + top + bottom + topLeft + topRight + bottomLeft + bottomRight;
                if (sumAr > maxSum) {
                    maxSum = sumAr;
                }
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{
            {1, 2, 3, 4, 5, 6},
            {6, 5, 4, 3, 2, 1},
            {1, 3, 5, 2, 4, 1},
            {1, 6, 3, 2, 4, 5},
            {3, 5, 1, 2, 4, 6},
            {2, 4, 6, 1, 3, 5}
        };
        System.out.println(sumArray(array));
    }
}
