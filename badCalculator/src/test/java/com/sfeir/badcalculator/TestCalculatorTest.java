package com.sfeir.badcalculator;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.*;



public class TestCalculatorTest {


    private Calculator calculator;

    @Before
    public void init(){
        calculator=new Calculator();
    }

    @Test
    public void testComputePlus() {
        assertThat(calculator.compute("3   plus 4")).isEqualTo(7);
        assertThat(calculator.compute("3  moins 4")).isEqualTo(-1);
        assertThat(calculator.compute("3 fois 4")).isEqualTo(12);
        assertThat(calculator.compute("3  divisé  4")).isEqualTo(0);
    }


}
