package com.nikita.lesson3_6.lesson4;

import com.nikita.lesson3.homework2.JumpingClouds;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JumpingCloudsTest {
    @Test
    public void JumpingClouds_works_correctly() {
        int[] array = new int[]{};
        int jump = JumpingClouds.jumpingOnClouds(array);
        Assertions.assertEquals(-1, jump);
    }

    @Test
    public void JumpingClouds_works_correctly1() {
        int[] array = new int[]{0, 1, 0, 0, 0, 1, 0};
        int jump = JumpingClouds.jumpingOnClouds(array);
        Assertions.assertEquals(3, jump);
    }

    @Test
    public void JumpingClouds_does_not_work_with_null() {
        int[] array = null;
        int jump= JumpingClouds.jumpingOnClouds(array);
        Assertions.assertEquals(-1,jump);
    }
}
