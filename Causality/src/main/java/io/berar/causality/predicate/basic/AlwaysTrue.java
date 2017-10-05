package io.berar.causality.predicate.basic;

import io.berar.causality.predicate.Predicate;

/**
 * Created by aleks_000 on 31/7/2016.
 */
public class AlwaysTrue implements Predicate {
    @Override
    public boolean test() {
        return true;
    }
}
