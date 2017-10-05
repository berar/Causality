package io.berar.causality.predicate.basic;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.berar.causality.matcher.Matcher;
import io.berar.causality.predicate.Predicate;

/**
 * Created by aleks_000 on 31/7/2016.
 */
public class Condition<T> implements Predicate {

    private String key;
    private Matcher<T> matcher;
    private T v1, v2;

    @JsonCreator
    public Condition(@JsonProperty("key") String key,
                     @JsonProperty("matcher") Matcher<T> matcher,
                     @JsonProperty("value") T val) {
        this.key = key;
        this.matcher = matcher;
        this.v2 = val;
    }

    @Override
    public boolean test() {
        return matcher.compare(v1, v2);
    }

    public String getKey() {
        return key;
    }

    @SuppressWarnings("unchecked")
    public void setV1(Object v1) {
        this.v1 = (T) v1;
    }

    public boolean valuePresent() {
        return v1 != null;
    }
}
