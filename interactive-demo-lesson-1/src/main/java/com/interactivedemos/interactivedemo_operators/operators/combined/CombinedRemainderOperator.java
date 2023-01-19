package com.interactivedemos.interactivedemo_operators.operators.combined;

public class CombinedRemainderOperator implements CombinedOperator{
    @Override
    public String getSign() {
        return "%=";
    }

    @Override
    public Integer calculate(Integer a, Integer b) {
        a %= b;
        return a;
    }
}
