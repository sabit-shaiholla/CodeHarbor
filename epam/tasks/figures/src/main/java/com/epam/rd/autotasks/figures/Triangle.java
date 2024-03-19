package com.epam.rd.autotasks.figures;

class Triangle extends Figure {
    private final Point a;
    private final Point b;
    private final Point c;
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double area(){
        return Math.abs((a.getX() - c.getX()) * (b.getY() - c.getY())
                - (b.getX() - c.getX()) * (a.getY() - c.getY())) / 2;
    }

    @Override
    public String pointsToString(){
        return a.toString() + b.toString() + c.toString();
    }

    @Override
    public Point leftmostPoint() {
        Point leftmost = a;
        if (b.getX() < leftmost.getX()) {
            leftmost = b;
        }
        if (c.getX() < leftmost.getX()) {
            leftmost = c;
        }
        return leftmost;
    }

}
