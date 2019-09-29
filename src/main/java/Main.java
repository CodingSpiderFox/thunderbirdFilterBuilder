import java.io.*;

public class Main {

    public static void main( String[] args ) throws IOException
    {
        File input = new File( "input_shared" );

        String result = writeAllKeywordsToSingleFilterRule(input);
        System.out.println( result );
        result = writeAllKeywordsToSeparateFilterRules(input);
        System.out.println( result );
    }

    private static String writeAllKeywordsToSeparateFilterRules(File input) throws IOException {
        File resultFile = new File("result");
        String result = "";

        /**
         * version="9" logging="no" name="Subject contains: text" enabled="yes" type="17" action="Move to
         * folder" actionValue="mailbox://nobody@Feeds/Trash" condition="OR (subject,contains,text) OR
         * (body,contains,text)"
         */

        result = result + ("version=\"9\"\n") + ("logging=\"yes\"\r\n") ;


        try (BufferedReader br = new BufferedReader(new FileReader(input))) {
            String line;
            while( (line = br.readLine()) != null )
            {
                result += ("name=\"subject contains " + line + "\"\r\n")
                        + ("enabled=\"yes\"\n")
                        + ("type=\"17\"\n") + ("action=\"Move to folder\"\n")
                        + ("actionValue=\"mailbox://nobody@Feeds/Thrash\"\n") + ("condition=\"");
                result += ("AND (subject,contains,") + line + ")\"\r\n";
            }
        }
        return result;
    }

    private static String writeAllKeywordsToSingleFilterRule(File input) throws IOException {
        File resultFile = new File("result");
        String result = "";

        /**
         * version="9" logging="no" name="Subject contains: text" enabled="yes" type="17" action="Move to
         * folder" actionValue="mailbox://nobody@Feeds/Trash" condition="OR (subject,contains,text) OR
         * (body,contains,text)"
         */

        result = result + ("version=\"9\"\n") + ("logging=\"yes\"\r\n") + ("name=\"global\"\n")
                + ("enabled=\"yes\"\n")
                + ("type=\"17\"\n") + ("action=\"Move to folder\"\n")
                + ("actionValue=\"mailbox://nobody@Feeds/Thrash\"\n") + ("condition=\"");


        try (BufferedReader br = new BufferedReader(new FileReader(input))) {
            String line;
            while ((line = br.readLine()) != null) {
                result = result + ("OR (subject,contains,") + line + ") OR (body,contains," + line + ") ";
            }
            result += "\"";
        }
        return result;
    }

}
