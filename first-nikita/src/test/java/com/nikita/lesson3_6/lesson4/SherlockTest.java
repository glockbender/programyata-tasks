package com.nikita.lesson3_6.lesson4;

import com.nikita.lesson3.Sherlock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SherlockTest {
    @Test
    public void Sherlock_does_not_work_with_null_or_empty_line() {
        String string = "";
        String result = Sherlock.sherlock(string);
        Assertions.assertEquals("", result);
    }

    @Test
    public void Sherlock_works_correctly() {
        String[] currectChars = new String[]{"a", "aa", "aaa", "ab", "abc", "abb", "aabbc", "aaabccc", "aaabbbccc"};
        for (int i = 0; i < currectChars.length - 1; i++) {
            String result = Sherlock.sherlock(currectChars[i]);
            Assertions.assertEquals("YES", result);

        }
    }

    @Test
    public void Sherlock_works_correctly1() {
        String[] currectChars = new String[]{"abccc", "aaabbbcc", "aaabbcccdddd"};
        for (int i = 0; i < currectChars.length - 1; i++) {
            String result = Sherlock.sherlock(currectChars[i]);
            Assertions.assertEquals("NO", result);
        }

    }
}
