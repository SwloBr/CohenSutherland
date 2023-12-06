package com.swlo.graphic.utils.calcules;

public class CohenInclination {


    public double calc(double x1, double x2, double y1, double y2) {
        return (y2 - y1) / (x2 - x1);
    }
}
