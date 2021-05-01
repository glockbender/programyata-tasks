package com.nikita.lesson3_6.lesson4;

import com.nikita.ArrayTestUtils;
import com.nikita.lesson2.SimpleArraySum;
import org.junit.jupiter.api.Test;

public class SimpleArraySumTest {


    @Test
    public void simpleArraySum_works_correctly() {
        int[] array = ArrayTestUtils.generate(1, 15);
        SimpleArraySum.simpleArraySum(array);

        int[] newArray= new int[]{};
        SimpleArraySum.simpleArraySum(newArray);
    }

    @Test
    public void simpleArraySum_does_not_work_with_null() {
        int[] array=null;
        SimpleArraySum.simpleArraySum(array);
    }
}
