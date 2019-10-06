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
        assertEquals("", result);
    }
}
