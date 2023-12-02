package com.epam.rd.autotasks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class QuadraticEquationSingleRootCasesTesting {

    @Parameters(name = "{index}: a={0}, b={1}, c={2}, expected={3}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 1, -2, 1, 1.0 }, { 2, 4, 2, -1.0 },
                { 4, -12, 9, 1.5 }, { 3, -6, 3, 1.0 }
        });
    }

    private double a;
    private double b;
    private double c;
    private double expected;
    protected QuadraticEquation quadraticEquation = new QuadraticEquation();

    public QuadraticEquationSingleRootCasesTesting(double a, double b,
                                                   double c, double expected) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.expected = expected;
    }

    @Test
    public void testSingleRootCase() {
        assertEquals(String.valueOf(expected), quadraticEquation.solve(a, b, c));
    }
}