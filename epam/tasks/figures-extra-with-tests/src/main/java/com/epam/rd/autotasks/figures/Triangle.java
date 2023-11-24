package com.epam.rd.autotasks.figures;

class Triangle extends Figure{
    private final Point a;
    private final Point b;
    private final Point c;

    public Triangle(Point a, Point b, Point c) {
        if (a == null || b == null || c == null) {
            throw new IllegalArgumentException();
        }
        this.a = a;
        this.b = b;
        this.c = c;
        if (!isNonDegenarate(a, b, c)) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Point centroid() {
        return new Point((a.getX() + b.getX() + c.getX()) / 3,
                (a.getY() + b.getY() + c.getY()) / 3);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (figure == null || figure.getClass() != Triangle.class) return false;
        Triangle triangle = (Triangle) figure;
        return triangle.a.equals(a) && triangle.b.equals(b)
                && triangle.c.equals(c);
    }

    private boolean isNonDegenarate(Point a, Point b, Point c) {
        double crossProduct = (b.getX() - a.getX()) * (c.getY() - a.getY())
                - (c.getX() - a.getX()) * (b.getY() - a.getY());
        return Math.abs(crossProduct) > EPSILON;
    }

}
