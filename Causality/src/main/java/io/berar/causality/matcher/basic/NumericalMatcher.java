package io.berar.causality.matcher.basic;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.berar.causality.matcher.AbstractMatcher;

/**
 * Created by aleks_000 on 31/7/2016.
 */
public class NumericalMatcher extends AbstractMatcher<Double> {

    private static final double EPS = 0.000001;

    @JsonCreator
    public NumericalMatcher(@JsonProperty("impl") String impl) {
        super(impl);
    }

    @Override
    public void addMatchers() {
        put(">", (v1, v2) -> v1 > v2);
        put(">=", (v1, v2) -> v1 >= v2);
        put("<", (v1, v2) -> v1 < v2);
        put("<=", (v1, v2) -> v1 <= v2);
        put("==", (v1, v2) -> Math.abs(v1 - v2) < EPS);
    }
}
