package com.interactivedemos.interactivedemo_operators.operators.standard;

/** Represents a simple arithmetic operator which performs a single operation on the provided operands */
public interface Operator {
    String getSign();

    Integer calculate(Integer a, Integer b);
}
