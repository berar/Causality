package io.berar.causality.matcher;

import io.berar.causality.exception.UnrecognizedMatcher;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by aleks_000 on 1/8/2016.
 */
public abstract class AbstractMatcher<T> implements Matcher<T> {

    private ConcurrentHashMap<String, Matcher<T>> matchers = new ConcurrentHashMap<>();
    private String impl;

    public AbstractMatcher(String impl) {
        this.impl = impl;
        addMatchers();
    }

    @Override
    public boolean compare(T v1, T v2) {
        Matcher<T> i = Optional.ofNullable(matchers.get(impl))
                .orElseThrow(() -> new UnrecognizedMatcher(impl));
        return i.compare(v1, v2);
    }

    public void put(String key, Matcher<T> val) {
        matchers.put(key, val);
    }

    public abstract void addMatchers();
}
