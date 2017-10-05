package io.berar.causality.predicate;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.berar.causality.predicate.basic.*;

import java.util.stream.Stream;

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
        @JsonSubTypes.Type(value = AlwaysTrue.class, name = "alwaysTrue"),
        @JsonSubTypes.Type(value = AndPredicate.class, name = "and"),
        @JsonSubTypes.Type(value = OrPredicate.class, name = "or"),
        @JsonSubTypes.Type(value = NotPredicate.class, name = "not"),
        @JsonSubTypes.Type(value = Condition.class, name = "cond")})
public interface Predicate {

    boolean test();

    default Stream<Predicate> flattened() {
        return Stream.of(this);
    }
}
