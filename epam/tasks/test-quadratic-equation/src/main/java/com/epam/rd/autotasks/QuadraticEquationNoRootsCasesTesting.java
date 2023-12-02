package com.epam.rd.autotasks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class QuadraticEquationNoRootsCasesTesting {

    @Parameters(name = "{index}: a={0}, b={1}, c={2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 1, 2, 3 }, { 1, 1, 2 },
                { 1, 3, 4 }, { 5, 4, 2 }
        });
    }

    private double a;
    private double b;
    private double c;

    protected QuadraticEquation quadraticEquation = new QuadraticEquation();


    public QuadraticEquationNoRootsCasesTesting(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Test
    public void testNoRootsCase() {
        assertEquals("no roots", quadraticEquation.solve(a, b, c));
    }

}
