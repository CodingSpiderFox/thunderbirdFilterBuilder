package org.codingspiderfox.thundbirdfilterbuilder.controller;

import org.codingspiderfox.thundbirdfilterbuilder.controller.config.FilterConfig;

public interface IFilterModelWriter {

    FilterModel writeModel(FilterConfig filterConfig);
}
