package io.berar.causality.predicate.basic;

import io.berar.causality.predicate.Predicate;
import io.berar.causality.predicate.VariadicPredicate;

/**
 * Created by aleks_000 on 31/7/2016.
 */
public class OrPredicate extends VariadicPredicate {

    @Override
    public boolean test() {
        return getPredicates().stream().anyMatch(Predicate::test);
    }
}
