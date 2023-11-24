package com.epam.rd.autotasks.figures;

abstract class Figure{
    public static final double EPSILON = 1e-10;

    public abstract Point centroid();
    public abstract boolean isTheSame(Figure figure);

}
