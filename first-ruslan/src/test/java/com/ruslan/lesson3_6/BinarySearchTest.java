package com.ruslan.lesson3_6;


import com.ruslan.lesson1.homework.binarysearch.BinarySearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTest {

    @Test
    public void BinarySearch_should_return_zero_when_array_is_null() {

        int[] array = null;
        int result = new BinarySearch().search(array, 0, 0, 0);
        Assertions.assertEquals(0, result);

    }

    @Test
    public void BinarySearch_should_work_correctly() {

        int[] array1 = new int[]{1, 2, 3, 4, 5};
        int item1 = 3;
        int result1 = new BinarySearch().search(array1, item1, 0, 4);
        Assertions.assertEquals(2, result1);

        int[] array2 = new int[]{1};
        int item2 = 1;
        int result2 = new BinarySearch().search(array2, item2, 0, 0);
        Assertions.assertEquals(0, result2);

        int[] array3 = new int[]{-5,-4,-3,-2,-1};
        int item3 = -3;
        int result3 = new BinarySearch().search(array3, item3, 0, 4);
        Assertions.assertEquals(2, result3);

        int[] array4 = new int[1000];
        int value = 0;

        for (int i = 0; i < 1000; i++) {

            value++;
            array4[i] = value;

        }

        int item4 = 500;
        int result4 = new BinarySearch().search(array4, item4, 0, 999);
        Assertions.assertEquals(499, result4);



    }



}
