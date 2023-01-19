package com.interactivedemos.interactivedemo_operators.operators.standard;

public class DivisionOperator implements Operator {
    @Override
    public String getSign() {
        return "/";
    }

    @Override
    public Integer calculate(Integer a, Integer b) {
        return a / b;
    }
}
