package org.codingspiderfox.thundbirdfilterbuilder.controller;

import org.codehaus.commons.compiler.CompileException;
import org.codehaus.janino.ExpressionEvaluator;
import org.codingspiderfox.thundbirdfilterbuilder.bo.FilterRule;
import org.codingspiderfox.thundbirdfilterbuilder.bo.Message;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.logging.Filter;

public class FilterRuleApplier<T extends Message> {

    ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();

    public FilterRuleApplier() {
        expressionEvaluator.setExpressionType(String.class);
    }

    public T apply(T input, List<FilterRule> filterRules) throws CompileException, InvocationTargetException {

        for(FilterRule filterRule : filterRules) {
            input = apply(input, filterRule);
        }

        return input;
    }

    public T apply(T input, FilterRule filterRule) throws CompileException, InvocationTargetException {

        expressionEvaluator.cook(filterRule.getFilterExpressionString());
        return (T) expressionEvaluator.evaluate(new String[]{input.getBody()});
    }



}
