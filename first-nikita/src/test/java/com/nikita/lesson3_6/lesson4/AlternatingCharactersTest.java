package com.nikita.lesson3_6.lesson4;

import com.nikita.lesson3.homework.AlternatingCharacters;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AlternatingCharactersTest {

    @Test
    public void AltenAlternatingCharacters_does_not_work_with_null_or_empty_line(){
        String s=null;
        Assertions.assertEquals(0, AlternatingCharacters.alternatingCharacters(s));

        String newS="";
        Assertions.assertEquals(0, AlternatingCharacters.alternatingCharacters(newS));
    }
}
