package io.berar.causality.matcher;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.berar.causality.matcher.basic.NumericalMatcher;
import io.berar.causality.matcher.basic.StringMatcher;

/**
 * Created by aleks_000 on 31/7/2016.
 */
//@JsonTypeInfo(
//        use = JsonTypeInfo.Id.MINIMAL_CLASS,
//        include = JsonTypeInfo.As.PROPERTY,
//        property = "@class")
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = NumericalMatcher.class, name = "numerical"),
        @JsonSubTypes.Type(value = StringMatcher.class, name = "string")
})
public interface Matcher<T> {
    boolean compare(T v1, T v2);
}
