package com.epam.rd.autotasks;

import java.util.Arrays;
import java.util.stream.Collectors;

import static java.lang.Math.sqrt;

public class QuadraticEquation {
    private boolean sortAscending;

    public QuadraticEquation() {
        this.sortAscending = true;
    }
    public String solve(double a, double b, double c) {

        if (a == 0) {
            throw new IllegalArgumentException("Coefficient 'a' must be non-zero");
        }
        double discriminant = b * b - 4 * a * c;

        if (discriminant < 0) {
            return "no roots";
        }

        double x1 = (-b - sqrt(discriminant)) / (2 * a);
        double x2 = (-b + sqrt(discriminant)) / (2 * a);

        if (x1 == x2){
            return String.valueOf(x1);
        }
        double[] roots = { x1, x2 };
        if (!sortAscending) {
            Arrays.sort(roots);
        }

        return Arrays.stream(roots)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
    }

    public void setSortAscending(boolean sortAscending) {
        this.sortAscending = sortAscending;
    }
}