package com.ruslan.homework4_2;

import com.ruslan.lesson3.CloudsGame;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CloudsGameTest {

    @Test
    public void CloudsGame_should_not_work_with_null_and_arrays_with_zero_and_one_length() {

        int[] arrNullable = null;
        int[] arrEmpty = new int[0];
        int[] arrOne = new int[1];

        int resultNullable = CloudsGame.jumps(arrNullable);
        int resultEmpty = CloudsGame.jumps(arrEmpty);
        int resultOne = CloudsGame.jumps(arrEmpty);

        Assertions.assertEquals(0,resultNullable);
        Assertions.assertEquals(0,resultEmpty);
        Assertions.assertEquals(0,resultOne);

    }

    @Test
    public void its_always_possible_to_win_the_CloudsGame(){

        int[] arrOne = new int[] {0,0};
        int[] arrTwo = new int[] {0,1,0};
        int[] arrThree = new int[]{0,1,1,0};
        int[] arrFour = new int[] {1,0,0,0};
        int[] arrFive = new int[] {0,1,0,1};
        int[] arrSix = new int[] {0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0};
        int[] arrSeven = new int[]{0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0};

        int resultOne = CloudsGame.jumps(arrOne);
        int resultTwo = CloudsGame.jumps(arrTwo);
        int resultThree = CloudsGame.jumps(arrThree);
        int resultFour = CloudsGame.jumps(arrFour);
        int resultFive = CloudsGame.jumps(arrFive);
        int resultSix = CloudsGame.jumps(arrSix);
        int resultSeven = CloudsGame.jumps(arrSeven);

        Assertions.assertEquals(1, resultOne);
        Assertions.assertEquals(1, resultTwo);
        Assertions.assertEquals(0, resultThree);
        Assertions.assertEquals(0, resultFour);
        Assertions.assertEquals(0, resultFive);
        Assertions.assertEquals(8, resultSix);
        Assertions.assertEquals(8, resultSeven);

    }

}
