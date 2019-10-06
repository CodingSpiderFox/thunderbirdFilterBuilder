package org.codingspiderfox.thundbirdfilterbuilder.controller;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilterStringWriterThunderbirdImplTest {

    @Test
    public void createsSingleSeparateFilterForSingleKeywordCorrectly() throws IOException {
        Collection<String> filterStrings = Arrays.asList("abc");
        String result = FilterStringWriterThunderbirdImpl.writeAllKeywordsToSeparateFilterRules(filterStrings);
        assertEquals("version=\"9\"\r\n" +
                "logging=\"yes\"\r\n" +
                "name=\"subject contains abc\"\r\n" +
                "enabled=\"yes\"\r\n" +
                "type=\"17\"\r\n" +
                "action=\"Move to folder\"\r\n" +
                "actionValue=\"mailbox://nobody@Feeds/Trash\"\r\n" +
                "condition=\"AND (subject,contains,abc)\"\r\n", result);
    }
}
