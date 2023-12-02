package com.epam.rd.autotasks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class QuadraticEquationZeroACasesTesting {
    @Parameters(name = "{index}: a={0}, b={1}, c={2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 0, 2, 3 }, { 0, 1, 2 },
                { 0, 3, 4 }, { 0, 5, 2 }
        });
    }
    private double a;
    private double b;
    private double c;
    protected QuadraticEquation quadraticEquation = new QuadraticEquation();

    public QuadraticEquationZeroACasesTesting(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroACase() {
        quadraticEquation.solve(a, b, c);
    }

}
