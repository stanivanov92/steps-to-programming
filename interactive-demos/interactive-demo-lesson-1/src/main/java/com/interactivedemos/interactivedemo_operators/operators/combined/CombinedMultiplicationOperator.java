package com.interactivedemos.interactivedemo_operators.operators.combined;

public class CombinedMultiplicationOperator implements CombinedOperator{
    @Override
    public String getSign() {
        return "*=";
    }

    @Override
    public Integer calculate(Integer a, Integer b) {
        a *= b;
        return a;
    }
}
