package com.ruslan.homework;

import com.ruslan.GenerateStringUtils;
import com.ruslan.lesson2.homework.rle.AlternatingCharacters;
import com.ruslan.lesson2.homework.rle.Rle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AlternatingCharactersTest {


    @Test
    public void AlternatingCharacters_must_not_work_with_null() {

        String s = null;
        int input = AlternatingCharacters.alternatingCharacters(s);
        Assertions.assertEquals(-1, input);

    }

    @Test
    public void AlternatingCharacters_must_work_correctly() {


        String s = GenerateStringUtils.genStrRandomRepeatableChars(1, 2, 10);
        int input = AlternatingCharacters.alternatingCharacters(s);
        String zippedS = Rle.zip(s);
        char[] arrZippedS = zippedS.toCharArray();
        int expected = 0;
        for (int i = 0; i < arrZippedS.length; i++) {
            if (Character.isDigit(arrZippedS[i])) {
                expected = expected + Character.getNumericValue(arrZippedS[i]) - 1;
            }
        }
        Assertions.assertEquals(expected, input);

    }

}
