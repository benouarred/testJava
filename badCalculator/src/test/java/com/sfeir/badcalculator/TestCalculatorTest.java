package com.sfeir.badcalculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestCalculatorTest {
	
	
	private Calculator calculator;
	
	@Before
	public void init(){
		calculator=new Calculator();
	}

	@Test
	public void testComputePlus() {
		assertEquals(Integer.valueOf(7), calculator.compute("3   plus 4"));
        assertEquals(Integer.valueOf(-1),calculator.compute("3  moins 4"));
        assertEquals(Integer.valueOf(12),calculator.compute("3 fois 4"));
        assertEquals(Integer.valueOf(0),calculator.compute("3  divisé  4"));
	}

}
