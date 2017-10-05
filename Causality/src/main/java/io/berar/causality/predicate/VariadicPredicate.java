package io.berar.causality.predicate;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by aleks_000 on 31/7/2016.
 */
public abstract class VariadicPredicate implements Predicate {
    @JsonProperty
    private List<Predicate> predicates = new ArrayList<>();

    public List<Predicate> getPredicates() {
        return predicates;
    }

    @Override
    public Stream<Predicate> flattened() {
        return Stream.concat(Stream.of(this), predicates.stream().flatMap(Predicate::flattened));
    }
}

