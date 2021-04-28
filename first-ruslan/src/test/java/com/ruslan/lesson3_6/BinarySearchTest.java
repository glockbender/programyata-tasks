package com.ruslan.lesson3_6;

import com.ruslan.GenerateArrayUtils;
import com.ruslan.lesson1.homework.binarysearch.BinarySearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTest {

    @Test
    public void BinarySearch_should_return_zero_when_array_is_null() {

        int[] array = null;
        int result = new BinarySearch().search(array, 0, 0, 0);
        Assertions.assertEquals(-1, result);

    }

    @Test
    public void BinarySearch_should_work_correctly() {

        BinarySearch bs = new BinarySearch();

        int[] array1 = new int[]{1};
        int item1 = 1;
        int result1 = bs.search(array1, item1, 0, 0);
        Assertions.assertEquals(0, result1);

        int[] array2 = GenerateArrayUtils.sortedArray(-99, 99);
        int item2 = 0;
        int result2 = bs.search(array2, item2, 0, 198);
        Assertions.assertEquals(99, result2);

        int[] array3 = GenerateArrayUtils.sortedArray(-99, 99);
        int item3 = 100;
        int result3 = bs.search(array3, item3, 0, 198);
        Assertions.assertEquals(-1, result3);

    }

}
