package com.epam.rd.autotasks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class QuadraticEquationTwoRootsCasesTesting {
    @Parameters(name = "{index}: a={0}, b={1}, c={2}, expected={3}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 2, 5, -3, "0.5 -3.0" },
                { 1, -3, 1, "2.618033988749895 0.3819660112501051" },
                { 2, -38, 156, "13.0 6.0" },
                { 2, -6, 4, "2.0 1.0" }
        });
    }
    private double a;
    private double b;
    private double c;
    private String expected;
    protected QuadraticEquation quadraticEquation;

    public QuadraticEquationTwoRootsCasesTesting(double a, double b, double c, String expected) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.expected = expected;
        this.quadraticEquation = new QuadraticEquation();
    }

    @Test
    public void testTwoRootsCase() {
        quadraticEquation.setSortAscending(expected.contains("-") || expected.equals("no roots"));
        assertRootsMatch(expected, quadraticEquation.solve(a, b, c));
    }

    private void assertRootsMatch(String expected, String actual) {
        List<Double> expectedRoots = parseAndSortRoots(expected);
        List<Double> actualRoots = parseAndSortRoots(actual);
        if (expectedRoots.isEmpty() && actualRoots.isEmpty()) {
            return;
        }
        assertEquals(expectedRoots, actualRoots);
    }

    private List<Double> parseAndSortRoots(String roots) {
        if ("no roots".equals(roots)) {
            return Collections.emptyList();
        }
        return Arrays.stream(roots.split(" "))
                .map(s -> {
                    try {
                        return Double.parseDouble(s);
                    } catch (NumberFormatException e) {
                        return Double.NaN;
                    }
                })
                .sorted()
                .collect(Collectors.toList());
    }
}
