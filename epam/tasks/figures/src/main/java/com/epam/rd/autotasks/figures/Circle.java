package com.epam.rd.autotasks.figures;

class Circle extends Figure {
    private final Point center;
    private final double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public double area(){
        return Math.PI * radius * radius;
    }

    @Override
    public String pointsToString(){
        return center.toString();
    }

    @Override
    public Point leftmostPoint() {
        return new Point(center.getX() - radius, center.getY());
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[" + pointsToString() + radius + "]";
    }
}
