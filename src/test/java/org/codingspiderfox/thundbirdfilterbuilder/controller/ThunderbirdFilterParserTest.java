package org.codingspiderfox.thundbirdfilterbuilder.controller;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThunderbirdFilterParserTest {

    private ThunderbirdFilterParser thunderbirdFilterParser = new ThunderbirdFilterParser();

    @Test
    public void testParsesSingleContainsFilterCorrectly()  {
        String inputData = "name=\"Subject contains: abc\"\n" +
                "enabled=\"yes\"\n" +
                "type=\"17\"\n" +
                "action=\"Move to folder\"\n" +
                "actionValue=\"mailbox://nobody@Feeds/Trash\"\n" +
                "condition=\"OR (subject,contains,abc) OR (body,contains,abc)\"\n";

        Collection<String> result = ThunderbirdFilterParser
        assertEquals(1, result.size());
        assertEquals("abc")
    }
}
