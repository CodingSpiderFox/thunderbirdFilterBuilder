package org.codingspiderfox.thundbirdfilterbuilder.controller;

import java.io.IOException;
import java.util.Collection;

public class FilterStringWriterThunderbirdImpl implements IFilterStringWriter {

    public static String writeAllKeywordsToSeparateFilterRules(Collection<String> inputStrings) throws IOException {
        String result = ("version=\"9\"\n") + ("logging=\"yes\"\r\n");

        for (String inputString : inputStrings) {
            result += ("name=\"subject contains " + inputString + "\"\r\n")
                    + ("enabled=\"yes\"\n")
                    + ("type=\"17\"\n") + ("action=\"Move to folder\"\n")
                    + ("actionValue=\"mailbox://nobody@Feeds/Thrash\"\n") + ("condition=\"");
            result += ("AND (subject,contains,") + inputString + ")\"\r\n";
        }

        return result;
    }

    public static String writeAllKeywordsToSingleFilterRule(Collection<String> inputStrings) throws IOException {
        /**
         * version="9" logging="no" name="Subject contains: text" enabled="yes" type="17" action="Move to
         * folder" actionValue="mailbox://nobody@Feeds/Trash" condition="OR (subject,contains,text) OR
         * (body,contains,text)"
         */

        String result = ("version=\"9\"\n") + ("logging=\"yes\"\r\n") + ("name=\"global\"\n")
                + ("enabled=\"yes\"\n")
                + ("type=\"17\"\n") + ("action=\"Move to folder\"\n")
                + ("actionValue=\"mailbox://nobody@Feeds/Thrash\"\n") + ("condition=\"");

        for (String inputString : inputStrings) {
            result += ("OR (subject,contains,") + inputString + ") OR (body,contains," + inputString + ") ";
        }

        return result;
    }

    @Override
    public String writeDefault(Collection<String> inputStrings) {
        try {
            return writeAllKeywordsToSeparateFilterRules(inputStrings);
        } catch (IOException e) {
            e.printStackTrace();
            //TODO add proper exception handling
        }
        return "";
    }
}
