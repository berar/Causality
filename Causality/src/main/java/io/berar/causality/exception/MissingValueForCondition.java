package io.berar.causality.exception;

/**
 * Created by aleks_000 on 1/8/2016.
 */
public class MissingValueForCondition extends RuntimeException {

    public MissingValueForCondition(String m) {
        super("Missing value for key: " + m);
    }
}
