package com.epam.rd.autotasks.triangle;

class Triangle {
    private final Point a;
    private final Point b;
    private final Point c;

    public Triangle(Point a, Point b, Point c) {
        if (a == null || b == null || c == null) {
            throw new RuntimeException("Triangle has null points");
        }
        this.a = a;
        this.b = b;
        this.c = c;
        if (!isNonDegenerative()) {
            throw new RuntimeException("Triangle is degenerative");
        }
    }

    public double area() {
        return Math.abs((a.getX() - c.getX()) * (b.getY() - c.getY())
                - (b.getX() - c.getX()) * (a.getY() - c.getY())) / 2;
    }

    public Point centroid(){
        double x = (a.getX() + b.getX() + c.getX()) / 3;
        double y = (a.getY() + b.getY() + c.getY()) / 3;
        return new Point(x, y);
    }

    public Boolean isNonDegenerative(){
        double ab = lengthBetweenPoints(a, b);
        double bc = lengthBetweenPoints(b, c);
        double ac = lengthBetweenPoints(a, c);
        return ((ab + bc > ac) && (ab + ac > bc) && (bc + ac > ab));
    }

    private double lengthBetweenPoints(Point a, Point b){
        return Math.sqrt(Math.pow((a.getX() - b.getX()), 2)
                + Math.pow((a.getY() - b.getY()), 2));
    }

}
