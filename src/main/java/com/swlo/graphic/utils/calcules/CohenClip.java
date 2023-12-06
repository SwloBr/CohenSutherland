package com.swlo.graphic.utils.calcules;

import com.swlo.graphic.ScreenSize;
import com.swlo.graphic.utils.limits.Limits;

public class CohenClip {

    private double minLenght, maxLenght, minHeight, maxHeight;

    public CohenClip(ScreenSize screenSize) {
        this.minLenght = screenSize.minLenght;
        this.maxLenght = screenSize.maxLenght;
        this.minHeight = screenSize.minHeight;
        this.maxHeight = screenSize.maxHeight;
    }


    public double[] clipPoint(double[] point, Limits limits, double inclination) {

        if (limits == Limits.NONE) {
            return point;
        }

        switch (limits) {

            case TOP:
                return clipTop(point, inclination);

            case BOTTOM:
                return clipBottom(point, inclination);

            case LEFT:
                return clipLeft(point, inclination);

            case RIGHT:
                return clipRight(point, inclination);

            case TOPLEFT:
                return clipTopLeft(point, inclination);

            case BOTTOMLEFT:
                return clipBottomLeft(point, inclination);

            case TOPRIGHT:
                return clipTopRight(point, inclination);

            case BOTTOMRIGHT:
                return clipBottomRight(point, inclination);
        }

        return null;
    }


    private double[] clipTop(double[] point, double inclination) {

        double x = (point[0] + (1 / inclination) * (maxHeight - point[1]));

        return new double[]{x, point[1]};

    }

    private double[] clipBottom(double[] point, double inclination) {

        double x = (point[0] + (1 / inclination) * (minHeight - point[1]));
        double y = inclination * (maxLenght - x) + point[1];

        return new double[]{x, y};

    }

    private double[] clipLeft(double[] point, double inclination) {

        double y = inclination * (minLenght - point[0]) + point[1];

        return new double[]{point[0], y};

    }

    private double[] clipRight(double[] point, double inclination) {

        double y = inclination * (maxLenght - point[0]) + point[1];

        return new double[]{point[0], y};

    }

    private double[] clipBottomRight(double[] point, double inclination) {

        double x = (point[0] + (1 / inclination) * (maxHeight - point[1]));
        double y = inclination * (maxLenght - x) + point[1];

        return new double[]{x, y};

    }

    private double[] clipBottomLeft(double[] point, double inclination) {

        double x = (point[0] + (1 / inclination) * (minHeight - point[1]));
        double y = inclination * (minLenght - x) + point[1];

        return new double[]{x, y};

    }

    private double[] clipTopRight(double[] point, double inclination) {

        double x = (point[0] + (1 / inclination) * (maxHeight - point[1]));
        double y = inclination * (maxLenght - x) + point[1];

        return new double[]{x, y};

    }

    private double[] clipTopLeft(double[] point, double inclination) {

        double x = (point[0] + (1 / inclination) * (minHeight - point[1]));
        double y = inclination * (minLenght - x) + point[1];

        return new double[]{x, y};

    }


}
