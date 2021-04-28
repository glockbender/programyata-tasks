package com.nikita.lesson3_6;

import com.nikita.ArrayTestUtils;
import com.nikita.lesson1.homework.selectionsort.SelectionSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SelectionSortTest {
    SelectionSort sSort= new SelectionSort();
    @Test
    public void SelectionSorting_works_correctly() {
        int[] array = new int[]{9, 8, 6, 4, 2, 1};
        int[] correctArray = new int[]{1, 2, 4, 6, 8, 9};
        sSort.sort(array);
        Assertions.assertArrayEquals(correctArray, array);

        int[] newArray= ArrayTestUtils.generate(1,50);
        int[] newCorrectArray=ArrayTestUtils.copyAndShuffle(newArray);
        sSort.sort(newCorrectArray);
        Assertions.assertArrayEquals(newArray,newCorrectArray);
    }

    @Test
    public void SelectionSorting_does_not_work_with_NULL() {
        int[] array = null;
        new SelectionSort().sort(array);
    }
}
