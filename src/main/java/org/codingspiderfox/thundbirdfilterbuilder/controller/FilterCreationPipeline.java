package org.codingspiderfox.thundbirdfilterbuilder.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class FilterCreationPipeline implements IFilterCreationPipeline {

    protected IFilterSourceReader filterSourceReader;

    protected IFilterModelWriter filterModelWriter;

    protected IFilterOutputWriter filterOutputWriter;

    private FilterSourceConfig filterSourceConfig;

    public void processPipeline(FilterSourceConfig filterSourceConfig) {
        FilterConfig filterConfig;
        filterConfig = filterSourceReader.processParameters(filterSourceConfig);
        FilterModel filterModel = filterModelWriter.writeModel(filterConfig);
        FilterSink filterSink = filterOutputWriter.writeOutput(filterModel);
    }

    public void processPipeline() throws IOException {
        FilterConfig filterConfig = filterSourceReader.processParameters(filterSourceConfig);
        FilterModel filterModel = filterModelWriter.writeModel(filterConfig);
        FilterSink filterSink = filterOutputWriter.writeOutput(filterModel);

        URL url = new URL("as");
        InputStream in = url.openStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));

    }
}
