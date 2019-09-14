package org.codingspiderfox.thundbirdfilterbuilder.controller;

import org.codingspiderfox.thundbirdfilterbuilder.controller.FilterCreationPipeline;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FilterCreationPipelineTest {


    @Test
    public void pipelineProcessesCompletely() {

        FilterCreationPipeline uut = new FilterCreationPipeline();

        IFilterModelWriter filterModelWriterMock = Mockito.mock(FilterModelWriter.class);

        uut.filterModelWriter =filterModelWriterMock;

        when(filterModelWriterMock.writeModel(any(FilterConfig.class))).thenReturn(new FilterModel());
        verify(filterModelWriterMock).writeModel(any(FilterConfig.class));
        uut.processPipeline();
    }
}
