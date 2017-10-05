package io.berar.causality.matcher.basic;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.berar.causality.matcher.AbstractMatcher;

/**
 * Created by aleks_000 on 1/8/2016.
 */
public class StringMatcher extends AbstractMatcher<String> {

    @JsonCreator
    public StringMatcher(@JsonProperty("impl") String impl) {
        super(impl);
    }

    @Override
    public void addMatchers() {
        put("equals", ((v1, v2) -> v1.equals(v2)));
        put("startsWith", ((v1, v2) -> v1.startsWith(v2)));
        put("endsWith", ((v1, v2) -> v1.endsWith(v2)));
    }
}
