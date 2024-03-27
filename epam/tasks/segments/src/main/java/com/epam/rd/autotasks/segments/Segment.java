package com.epam.rd.autotasks.segments;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Segment {

    private final Point start;
    private final Point end;

    public Segment(Point start, Point end) {
        if ((start == null) || (end == null) || start.equals(end)) {
            throw new RuntimeException("Start and end points must not be null");
        }
        this.start = start;
        this.end = end;
    }

    double length() {
        return sqrt(pow(abs(start.getX() - end.getX()), 2)
                + pow(abs(start.getY() - end.getY()), 2));
    }

    Point middle() {
        return new Point((start.getX() + end.getX()) / 2,
                (start.getY() + end.getY()) / 2);
    }

    Point intersection(Segment another) {
        validateInputSegment(another);

        double x1 = start.getX();
        double y1 = start.getY();
        double x2 = end.getX();
        double y2 = end.getY();
        double x3 = another.start.getX();
        double y3 = another.start.getY();
        double x4 = another.end.getX();
        double y4 = another.end.getY();
        double denominator = calculateDenominator(x1, y1, x2, y2, x3, y3, x4, y4);

        if (denominator == 0) {
            return null;
        }

        double x = calculateCoordinate(x1, y1, x2, y2, x3, y3, x4, y4, denominator, true);
        double y = calculateCoordinate(x1, y1, x2, y2, x3, y3, x4, y4, denominator, false);
        if (areCoordinatesInRange(x, Math.min(x1, x2), Math.max(x1, x2))
                && areCoordinatesInRange(x, Math.min(x3, x4), Math.max(x3, x4))
                && areCoordinatesInRange(y, Math.min(y1, y2), Math.max(y1, y2))
                && areCoordinatesInRange(y, Math.min(y3, y4), Math.max(y3, y4))) {
            return new Point(x, y);
        } else {
            return null;
        }
    }

    private boolean areCoordinatesInRange(Double coordinate, double minValue, double maxValue) {
        return coordinate != null && coordinate >= minValue && coordinate <= maxValue;
    }

    private void validateInputSegment(Segment another) {
        if (another == null) {
            throw new RuntimeException("Input segment cannot be null");
        }
    }

    private double calculateDenominator(double x1, double y1,
                                        double x2, double y2,
                                        double x3, double y3,
                                        double x4, double y4) {
        return (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
    }
    private double calculateCoordinate(double x1, double y1,
                                       double x2, double y2,
                                       double x3, double y3,
                                       double x4, double y4,
                                       double denominator, boolean isXCoordinate) {
        double numerator;
        if (isXCoordinate) {
            numerator = (x1 * y2 - y1 * x2) * (x3 - x4) - (x1 - x2) * (x3 * y4 - y3 * x4);
        } else {
            numerator = (x1 * y2 - y1 * x2) * (y3 - y4) - (y1 - y2) * (x3 * y4 - y3 * x4);
        }
        return numerator / denominator;
    }
}
