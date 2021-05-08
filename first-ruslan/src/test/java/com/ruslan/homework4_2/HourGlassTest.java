package com.ruslan.homework4_2;

import com.ruslan.GenerateArrayUtils;
import com.ruslan.lesson3.Hourglass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class HourGlassTest {

    @Test
    public void hourglass_should_work_only_with_massive_six_by_six() {

        int[][] arrayNullable = null;
        int inputNullable = Hourglass.hourglass(arrayNullable);
        Assertions.assertEquals(-65, inputNullable);

        int[] genMoM = GenerateArrayUtils.sortedArray(1, 15);
        for (int i = 0; i < genMoM.length; i++) {
            for (int j = 0; j < genMoM.length; j++) {
                if (i == 6 || j == 6) {
                    i++;
                    j++;
                }
                int[][] arrayIJ = new int[i][j];
                int inputNotSixBySixArr = Hourglass.hourglass(arrayIJ);
                Assertions.assertEquals(-65, inputNotSixBySixArr);

            }
        }
    }

    @Test
    public void hourglass_works_with_elements_from_minus_nine_to_nine_only_and_works_correctly() {

        int[][] arrayPlusOver = new int[6][6];
        int[][] arrayMinusOver = new int[6][6];
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                arrayPlusOver[i][j] = 10 + random.nextInt(5);
                arrayMinusOver[i][j] = -10 - random.nextInt(5);

                int inputPlusOver = Hourglass.hourglass(arrayPlusOver);
                Assertions.assertEquals(-65, inputPlusOver);
                int inputMinusOver = Hourglass.hourglass(arrayMinusOver);
                Assertions.assertEquals(-65, inputMinusOver);

            }

        }

        int[] right = GenerateArrayUtils.sortedArray(-9, 9);
        int[][] rightSixToSix = new int[][]{{-1, -1, 0, -9, -2, -2}, {-2, -1, -6, -8, -2, -5}, {-1, -1, -1, -2, -3, -4}, {-1, -9, -2, -4, -4, -5}, {-7, -3, -3, -2, -9, -9}, {-1, -3, -1, -2, -4, -5}};
        int inputRight = Hourglass.hourglass(rightSixToSix);
        Assertions.assertEquals(-6, inputRight);

    }

}
