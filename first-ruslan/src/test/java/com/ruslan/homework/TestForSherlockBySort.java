package com.ruslan.homework;

import com.ruslan.lesson3.Sherlock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestForSherlockBySort {

    @Test
    public void sherlock_should_not_work_with_empty() {

        String strEmpty = "";
        String result = Sherlock.sherlock(strEmpty);
        Assertions.assertEquals("string is Empty", result);

    }

    @Test
    public void sherlock_should_work_correctly(){

        String[] charsTrue = new String[] {"aa", "ab", "abb", "aab", "abbbccc", "aaabbbcccc"};

        for (int i = 0; i < charsTrue.length - 1; i++) {
            String resultTrue = Sherlock.sherlock(charsTrue[i]);
            Assertions.assertEquals("YES", resultTrue);
        }

        String[] charsFalse = new String[] {"abbbb", "abccc", "aabbcccddd", "ffaaccdddd", "aarrdddcccc"};

        for (int j = 0; j < charsFalse.length - 1; j++) {
            String resultFalse = Sherlock.sherlock(charsFalse[j]);
            Assertions.assertEquals("NO", resultFalse);
        }

    }


}
