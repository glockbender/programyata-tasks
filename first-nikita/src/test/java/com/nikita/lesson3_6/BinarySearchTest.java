package com.nikita.lesson3_6;

import com.nikita.ArrayTestUtils;
import com.nikita.lesson1.homework.binarysearch.BinarySearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTest {
    @Test
    public void BinarySearch_works_correctly() {
        int[] array= ArrayTestUtils.generate(1,7);
        int item=4;
        new BinarySearch().binary(array, item, 1, 7);
        Assertions.assertEquals(item,4);
    }
   

    @Test
    public void BinarySearch_does_not_work_with_NULL() {
        int[] array = null;
        new BinarySearch().binary(array, 5, 1, 7);

    }
}
