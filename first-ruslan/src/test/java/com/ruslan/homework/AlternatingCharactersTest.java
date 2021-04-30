package com.ruslan.homework;

import com.ruslan.GenerateStringUtils;
import com.ruslan.lesson2.homework.rle.AlternatingCharacters;
import com.ruslan.lesson2.homework.rle.Rle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AlternatingCharactersTest {


    @Test
    public void AlternatingCharacters_must_not_work_with_null_and_empty() {

        String s = null;
        int input = AlternatingCharacters.alternatingCharacters(s);
        Assertions.assertEquals(-1, input);

        String f = "";
        int inputEmpty = AlternatingCharacters.alternatingCharacters(f);
        Assertions.assertEquals(-1, inputEmpty);

    }

    @Test
    public void AlternatingCharacters_must_work_correctly() {

        String caseOne = "AABBABCDDDRTT";
        String caseTwo = "ABCCCBA";
        int inputOne = AlternatingCharacters.alternatingCharacters(caseOne);
        int inputTwo = AlternatingCharacters.alternatingCharacters(caseTwo);
        Assertions.assertEquals(5,inputOne);
        Assertions.assertEquals(2,inputTwo);

    }

}
