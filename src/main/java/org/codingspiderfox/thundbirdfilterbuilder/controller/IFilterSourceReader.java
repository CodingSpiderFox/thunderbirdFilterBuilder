package org.codingspiderfox.thundbirdfilterbuilder.controller;

import org.codingspiderfox.thundbirdfilterbuilder.controller.config.FilterConfig;
import org.codingspiderfox.thundbirdfilterbuilder.controller.config.FilterSourceConfig;

public interface IFilterSourceReader {

    public FilterConfig processParameters(FilterSourceConfig filterSourceConfig);
}
