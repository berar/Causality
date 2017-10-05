package io.berar.causality;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.berar.causality.predicate.Predicate;

/**
 * Created by aleks_000 on 31/7/2016.
 */
public class Causality<T> {

    private Predicate cause;
    private T effect;

    @JsonCreator
    public Causality(@JsonProperty("cause") Predicate cause,
                     @JsonProperty("effect") T effect) {
        this.cause = cause;
        this.effect = effect;
    }

    public Causality(T effect) {
        this.effect = effect;
    }

    public Predicate getCause() {
        return cause;
    }

    public T getEffect() {
        return effect;
    }
}
