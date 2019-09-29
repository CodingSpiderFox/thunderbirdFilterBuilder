package org.codingspiderfox.thundbirdfilterbuilder.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FilterRule {

    private String filterExpressionString;


    public String[] getFilterExpressionString() {
        return null;
    }
}
