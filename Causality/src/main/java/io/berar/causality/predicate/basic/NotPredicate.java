package io.berar.causality.predicate.basic;

import io.berar.causality.predicate.MonadicPredicate;

/**
 * Created by aleks_000 on 31/7/2016.
 */
public class NotPredicate extends MonadicPredicate {

    @Override
    public boolean test() {
        return !getPredicate().test();
    }
}
