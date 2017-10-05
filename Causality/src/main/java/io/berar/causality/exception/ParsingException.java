package io.berar.causality.exception;

/**
 * Created by aleks_000 on 1/8/2016.
 */
public class ParsingException extends RuntimeException {

    public ParsingException(String m, Throwable t) {
        super(m, t);
    }
}
