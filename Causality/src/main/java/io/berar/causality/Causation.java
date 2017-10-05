package io.berar.causality;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.berar.causality.exception.MissingValueForCondition;
import io.berar.causality.exception.ParsingException;
import io.berar.causality.predicate.Predicate;
import io.berar.causality.predicate.basic.Condition;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by aleks_000 on 31/7/2016.
 */
public class Causation<T> {

    private Map<String, Object> valueMap;

    private Predicate superCause;
    private List<Causality<T>> causalities;
    private T otherwise;

    @JsonCreator
    private Causation(@JsonProperty("superCause") Predicate superCause,
                      @JsonProperty("causalities") List<Causality<T>> causalities,
                      @JsonProperty("otherwise") T otherwise) {
        this.superCause = superCause;
        this.causalities = causalities;
        this.otherwise = otherwise;
        valueMap = new HashMap<>();
    }

    public Causation<T> copy() {
        return new Causation<>(this.superCause, this.causalities, this.otherwise);
    }

    public static <T> Causation<T> create(File in, Class<T> typeParameterClass) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JavaType topMost = mapper.getTypeFactory().constructParametricType(Causation.class, typeParameterClass);
            return mapper.readValue(in, topMost);
        } catch (Exception ex) {
            throw new ParsingException(ex.getMessage(), ex.getCause());
        }
    }

    public static <T> Causation<T> create(InputStream in, Class<T> typeParameterClass) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JavaType topMost = mapper.getTypeFactory().constructParametricType(Causation.class, typeParameterClass);
            return mapper.readValue(in, topMost);
        } catch (Exception ex) {
            throw new ParsingException(ex.getMessage(), ex.getCause());
        }
    }

    public static <T> Causation<T> create(String in, Class<T> typeParameterClass) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JavaType topMost = mapper.getTypeFactory().constructParametricType(Causation.class, typeParameterClass);
            return mapper.readValue(in, topMost);
        } catch (Exception ex) {
            throw new ParsingException(ex.getMessage(), ex.getCause());
        }
    }

    public void put(String key, Object value) {
        valueMap.put(key, value);
    }

    public T getEffect() {
        injectValues();
        throwIfAnyNulledValueInConditions();
        if (!superCause.test())
            return otherwise;
        return causalities.stream().filter(c->c.getCause().test()).findFirst()
                .orElse(new Causality<>(otherwise)).getEffect();
    }

    private void injectValues() {
        superCause.flattened().flatMap(Predicate::flattened)
                .filter(x-> x instanceof Condition).map(Condition.class::cast).forEach(c-> c.setV1(valueMap.get(c.getKey())));
        filterConditions().forEach(c-> c.setV1(valueMap.get(c.getKey())));
    }

    public boolean anyMatch() {
        injectValues();
        throwIfAnyNulledValueInConditions();
        return superCause.test() && causalities.stream().map(Causality::getCause).anyMatch(Predicate::test);
    }

    private void throwIfAnyNulledValueInConditions() {
        filterConditions().filter(c -> !c.valuePresent()).findFirst()
                .ifPresent(s -> { throw new MissingValueForCondition(s.getKey()); });
    }

    private Stream<Condition> filterConditions() {
        return causalities.stream().map(Causality::getCause).flatMap(Predicate::flattened)
                .filter(x-> x instanceof Condition).map(Condition.class::cast);
    }
}
