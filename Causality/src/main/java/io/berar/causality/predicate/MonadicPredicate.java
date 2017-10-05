package io.berar.causality.predicate;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.stream.Stream;

/**
 * Created by aleks_000 on 31/7/2016.
 */
public abstract class MonadicPredicate implements Predicate {

    @JsonProperty
    private Predicate predicate;

    public Predicate getPredicate() {
        return predicate;
    }

    @Override
    public Stream<Predicate> flattened() {
        return Stream.concat(Stream.of(this), predicate.flattened());
    }
}
