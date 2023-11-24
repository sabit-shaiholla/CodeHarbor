package com.epam.rd.autotasks.figures;

class Circle extends Figure{
    private final Point center;
    private final double radius;

    public Circle(Point center, double radius) {
        if (center == null || radius <= 0) {
            throw new IllegalArgumentException();
        }
        this.center = center;
        this.radius = radius;
    }

    @Override
    public Point centroid() {
        return center;
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (figure == null || figure.getClass() != Circle.class) return false;
        Circle circle = (Circle) figure;
        return Math.abs(circle.radius - radius) < EPSILON
                && circle.center.equalsWithPrecision(center, EPSILON);
    }

}
