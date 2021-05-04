package com.nikita.lesson3_6.lesson4;

import com.nikita.lesson3.homework2.Array2D;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Array2DTest {
    @Test
    public void Array2D_does_not_work_with_null(){
        int [][] array= null;
        int sum= Array2D.sumArray(array);
        Assertions.assertEquals(-1,sum);
    }
    @Test
    public void Array2D_works_correctly(){
        int[][] array= new int[][]{{},{}};
        int sum = Array2D.sumArray(array);
        Assertions.assertEquals(-1,sum);
    }
    @Test
    public void Array2D_works_correctly1(){
        int[][] array = new int[][]{
            {1, 2, 3, 4, 5, 6},
            {6, 5, 4, 3, 2, 1},
            {1, 3, 5, 2, 4, 1},
            {1, 6, 3, 2, 4, 5},
            {3, 5, 1, 2, 4, 6},
            {2, 4, 6, 1, 3, 5}};
        int sum = Array2D.sumArray(array);
        Assertions.assertEquals(28,sum);
    }

}
