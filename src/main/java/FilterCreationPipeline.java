public class FilterCreationPipeline implements IFilterCreationPipeline {

    FilterSourceReader filterSourceReader;

    FilterModelWriter filterModelWriter;

    FilterOutputWriter filterOutputWriter;

    public void processPipeline(FilterSourceConfig filterSourceConfig) {
        FilterConfig filterConfig = filterSourceReader.processParameters(filterSourceConfig);
        FilterModel filterModel = filterModelWriter.writeModel(filterConfig);
        FilterSink filterSink = filterOutputWriter.writeOutput(filterModel);
    }

    public void processPipeline() {

    }
}
