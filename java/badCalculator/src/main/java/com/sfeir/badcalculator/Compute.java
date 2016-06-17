package com.sfeir.badcalculator;

public interface Compute {

    default String compute(String op) {
        return null;
    }
}
