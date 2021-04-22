package com.prvz.lesson3_6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParserTest {

    @Test
    public void parseIntPostfixAtString_should_parse_string_and_return_123() {

        String s = "abc_123";

        int result = Parser.parseIntPostfixAtString(s);

        Assertions.assertEquals(123, result);

    }

    @Test
    public void parseIntPostfixAtString_should_throw_ParseException_when_string_is_null() {

        String s = null;
        Assertions.assertThrows(ParsingException.class, () -> Parser.parseIntPostfixAtString(s));

    }

    @Test
    public void parseIntPostfixAtString_should_throw_ParseException_when_string_is_blank() {

        String s = "   ";
        Assertions.assertThrows(ParsingException.class, () -> Parser.parseIntPostfixAtString(s));

    }

    @Test
    public void parseIntPostfixAtString_should_throw_ParseException_when_string_dhave_splitter() {

        String s = "asb123";
        Assertions.assertThrows(ParsingException.class, () -> Parser.parseIntPostfixAtString(s));

    }

    @Test
    public void parseIntPostfixAtString_should_throw_ParseException_when_string_has_incorrect_format() {

        String s = "asb_123_asdasd";
        Assertions.assertThrows(ParsingException.class, () -> Parser.parseIntPostfixAtString(s));

    }

    @Test
    public void parseIntPostfixAtString_should_throw_ParseException_when_string_prefix_isnt_number() {

        String s = "asb_abc";
        Assertions.assertThrows(ParsingException.class, () -> Parser.parseIntPostfixAtString(s));

    }

}
