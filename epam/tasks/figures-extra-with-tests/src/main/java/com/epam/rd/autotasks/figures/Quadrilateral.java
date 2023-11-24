package com.epam.rd.autotasks.figures;

import java.util.Arrays;
import java.util.Comparator;

class Quadrilateral extends Figure{
    private static final int QUADRILATERAL_VERTICE_COUNT = 4;
    private final Point a;
    private final Point b;
    private final Point c;
    private final Point d;

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        if (a == null || b == null || c == null || d == null) {
            throw new IllegalArgumentException();
        }
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        if (!isNonDegenarate(a, b, c, d) || !isConvex(a, b, c, d)) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Point centroid() {
        double cx = 0.0, cy = 0.0, area = 0.0;

        Point[] vertices = {a, b, c, d};

        for (int i = 0; i < QUADRILATERAL_VERTICE_COUNT; i++) {
            int next = (i + 1) % QUADRILATERAL_VERTICE_COUNT;

            double term = vertices[i].getX() * vertices[next].getY() - vertices[next].getX() * vertices[i].getY();
            area += term;

            cx += (vertices[i].getX() + vertices[next].getX()) * term;
            cy += (vertices[i].getY() + vertices[next].getY()) * term;
        }

        area *= 0.5;
        cx /= 6.0 * area;
        cy /= 6.0 * area;

        return new Point(cx, cy);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (!(figure instanceof Quadrilateral)) return false;
        Quadrilateral other = (Quadrilateral) figure;

        Point[] theseVertices = {this.a, this.b, this.c, this.d};
        Point[] otherVertices = {other.a, other.b, other.c, other.d};

        // Sort the vertices for both quadrilaterals
        Arrays.sort(theseVertices, Comparator.comparing(Point::getX).thenComparing(Point::getY));
        Arrays.sort(otherVertices, Comparator.comparing(Point::getX).thenComparing(Point::getY));

        // Check if the figures coincide within the given error delta
        for (int i = 0; i < 4; i++) {
            if (areVerticesEqualWithPrecision(theseVertices, otherVertices)) {
                return true;
            }
            // Rotate the vertices for the next permutation
            otherVertices = rotateVertices(otherVertices);
        }

        return false;
    }

    private Point[] rotateVertices(Point[] vertices) {
        Point temp = vertices[0];
        for (int i = 0; i < 3; i++) {
            vertices[i] = vertices[i + 1];
        }
        vertices[3] = temp;
        return vertices;
    }

    private boolean areVerticesEqualWithPrecision(Point[] vertices1, Point[] vertices2) {
        for (int i = 0; i < vertices1.length; i++) {
            if (!vertices1[i].equalsWithPrecision(vertices2[i], EPSILON)) {
                return false;
            }
        }
        return true;
    }

    private boolean isNonDegenarate(Point a, Point b, Point c, Point d) {
        return Math.abs(crossProduct(a, b, c)) > EPSILON
                && Math.abs(crossProduct(b, c, d)) > EPSILON;
    }

    private boolean isConvex(Point a, Point b, Point c, Point d) {
        return crossProduct(a, b, c) * crossProduct(b, c, d) >= 0 &&
                crossProduct(b, c, d) * crossProduct(c, d, a) >= 0 &&
                crossProduct(c, d, a) * crossProduct(d, a, b) >= 0 &&
                crossProduct(d, a, b) * crossProduct(a, b, c) >= 0;
    }

    private double crossProduct(Point a, Point b, Point c) {
        return (b.getX() - a.getX()) * (c.getY() - a.getY())
                - (c.getX() - a.getX()) * (b.getY() - a.getY());
    }
}
