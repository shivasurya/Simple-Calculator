package com.example.subramani_5647.simplecalculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by subramani-5647 on 15/09/17.
 */
public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator(6,4);
    }

    @After
    public void tearDown() throws Exception {
        calculator = null;
    }

    @Test
    public void add() throws Exception {
        assertTrue( calculator.add() == 10 );
    }

    @Test
    public void subtract() throws Exception {
        assertTrue( calculator.subtract() == 2 );
    }

    @Test
    public void multiply() throws Exception {
        assertTrue( calculator.multiply() == 24 );
    }

    @Test
    public void divide() throws Exception {
        assertTrue( calculator.divide() == 1.5 );
    }

}