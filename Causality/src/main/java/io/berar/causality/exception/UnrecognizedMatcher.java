package io.berar.causality.exception;

/**
 * Created by aleks_000 on 1/8/2016.
 */
public class UnrecognizedMatcher extends RuntimeException {

    public UnrecognizedMatcher(String message) {
        super("Unrecognized matcher: " + message);
    }
}
