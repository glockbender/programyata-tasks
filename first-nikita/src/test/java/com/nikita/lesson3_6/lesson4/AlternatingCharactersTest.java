package com.nikita.lesson3_6.lesson4;

import com.nikita.lesson3.homework.AlternatingCharacters;
import org.junit.jupiter.api.Test;

public class AlternatingCharactersTest {
    AlternatingCharacters altChar= new AlternatingCharacters();
    @Test
    public void AltenAlternatingCharacters_does_not_work_with_null_or_empty_line(){
        String s=null;
        altChar.alternatingCharacters(s);

        String newS="";
        altChar.alternatingCharacters(s);
    }
}
