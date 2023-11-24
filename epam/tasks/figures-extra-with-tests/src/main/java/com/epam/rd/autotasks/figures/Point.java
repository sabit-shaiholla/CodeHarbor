package com.epam.rd.autotasks.figures;

class Point {
    private final double x;
    private final double y;

    public Point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public boolean equalsWithPrecision(Point other, double epsilon) {
        return Math.abs(this.x - other.x) < epsilon
                && Math.abs(this.y - other.y) < epsilon;
    }
}
