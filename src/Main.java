import java.io.*;

public class Main {

    public static void main( String[] args ) throws IOException
    {
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

        File input = new File( "input_shared" );

        try (BufferedReader br = new BufferedReader(new FileReader(input))) {
            String line;
            while( (line = br.readLine()) != null )
            {
                result = result + ("OR (subject,contains,") + line + ") OR (body,contains," + line + ") ";
            }
            result += "\"";
        }

        System.out.println( result );
    }
    
}
