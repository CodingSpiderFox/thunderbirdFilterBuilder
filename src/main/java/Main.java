import org.codingspiderfox.thundbirdfilterbuilder.controller.FilterStringWriterThunderbirdImpl;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class Main {

    public static void main( String[] args ) throws IOException
    {
        File input = new File( "input_shared" );

        Collection<String> filterStrings = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(input))) {
            String line;
            while ((line = br.readLine()) != null) {
                filterStrings.add(line);
            }
        }

        String result = FilterStringWriterThunderbirdImpl.writeAllKeywordsToSingleFilterRule(filterStrings);
        System.out.println( result );
        result = FilterStringWriterThunderbirdImpl.writeAllKeywordsToSeparateFilterRules(filterStrings);
        System.out.println( result );
    }

}
