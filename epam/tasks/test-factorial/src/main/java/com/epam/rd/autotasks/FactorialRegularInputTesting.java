package com.epam.rd.autotasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FactorialRegularInputTesting {

    Factorial factorial = new Factorial();

    @Test
    void testFactorialOfZero() {
        assertEquals("1", factorial.factorial("0"));
    }

    @Test
    void testFactorialOfOne() {
        assertEquals("1", factorial.factorial("1"));
    }

    @Test
    void testFactorialOfSmallNumber() {
        assertEquals("120", factorial.factorial("5"));
    }

    @Test
    void testFactorialOfLargeNumber() {
        assertEquals("2432902008176640000", factorial.factorial("20"));
    }

    @Test
    void testFactorialOfLargeNumber2() {
        assertEquals("815915283247897734345611269596115894272000000000", factorial.factorial("40"));
    }
}
