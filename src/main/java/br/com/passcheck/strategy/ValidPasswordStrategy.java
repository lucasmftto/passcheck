package br.com.passcheck.strategy;

import java.util.function.IntPredicate;

public interface ValidPasswordStrategy {
    boolean isValid(String password);

    default  boolean contains(String value, IntPredicate predicate) {
        return value.chars().anyMatch(predicate);
    }
}
