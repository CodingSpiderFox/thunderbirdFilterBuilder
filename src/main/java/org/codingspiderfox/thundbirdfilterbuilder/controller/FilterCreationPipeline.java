package org.codingspiderfox.thundbirdfilterbuilder.controller;

public class FilterCreationPipeline implements IFilterCreationPipeline {

    FilterSourceReader filterSourceReader;

    FilterModelWriter filterModelWriter;

    FilterOutputWriter filterOutputWriter;

    private FilterSourceConfig filterSourceConfig;

    public void processPipeline(FilterSourceConfig filterSourceConfig) {
        FilterConfig filterConfig = filterSourceReader.processParameters(filterSourceConfig);
        FilterModel filterModel = filterModelWriter.writeModel(filterConfig);
        FilterSink filterSink = filterOutputWriter.writeOutput(filterModel);
    }

    public void processPipeline() {
        FilterConfig filterConfig = filterSourceReader.processParameters(filterSourceConfig);
        FilterModel filterModel = filterModelWriter.writeModel(filterConfig);
        FilterSink filterSink = filterOutputWriter.writeOutput(filterModel);

    }
}
