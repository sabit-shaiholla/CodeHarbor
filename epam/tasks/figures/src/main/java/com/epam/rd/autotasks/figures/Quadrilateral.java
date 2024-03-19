package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure {
    private final Point a;
    private final Point b;
    private final Point c;
    private final Point d;

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public double area(){
        double crossProduct1 = (a.getX() * b.getY()) + (b.getX() * c.getY())
                + (c.getX() * d.getY()) + (d.getX() * a.getY());
        double crossProduct2 = (a.getY() * b.getX()) + (b.getY() * c.getX())
                + (c.getY() * d.getX()) + (d.getY() * a.getX());
        return (Math.abs(crossProduct1 - crossProduct2))/2;
    }

    @Override
    public String pointsToString(){
        return a.toString() + b.toString() + c.toString() + d.toString();
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
        if (d.getX() < leftmost.getX()) {
            leftmost = d;
        }
        return leftmost;
    }

}
