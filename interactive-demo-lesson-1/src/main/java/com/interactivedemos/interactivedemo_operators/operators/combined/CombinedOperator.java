package com.interactivedemos.interactivedemo_operators.operators.combined;

/** Represents a combined operator - one which performs a calculation and assigns the answer to a variable. */
public interface CombinedOperator {
    String getSign();
    Integer calculate(Integer a, Integer b);
}
