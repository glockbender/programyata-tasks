package com.nikita.lesson3_6.lesson4;

import com.nikita.ArrayTestUtils;
import com.nikita.lesson2.SimpleArraySum;
import org.junit.jupiter.api.Test;

public class SimpleArraySumTest {
    SimpleArraySum sAs = new SimpleArraySum();

    @Test
    public void simpleArraySum_works_correctly() {
        int[] array = ArrayTestUtils.generate(1, 15);
        sAs.simpleArraySum(array);
    }

    @Test
    public void simpleArraySum_does_not_work_with_null() {
        int[] array=null;
        sAs.simpleArraySum(array);
    }
}
