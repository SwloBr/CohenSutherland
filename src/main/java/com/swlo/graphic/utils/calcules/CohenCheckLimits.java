package com.swlo.graphic.utils.calcules;

import com.swlo.graphic.ScreenSize;
import com.swlo.graphic.utils.limits.Limits;

public class CohenCheckLimits {

    double minLenght, maxLenght, minHeight, maxHeight;


    public CohenCheckLimits(ScreenSize screenSize) {
        this.minLenght = screenSize.minLenght;
        this.maxLenght = screenSize.maxLenght;
        this.minHeight = screenSize.minHeight;
        this.maxHeight = screenSize.maxHeight;
    }

    public Limits checkLimit(double[] main, double[] auxiliary) {
        double x = main[0];
        double y = main[1];

        double xAuxiliary = auxiliary[0];
        double yAuxiliary = auxiliary[1];


        if (x <= maxLenght && x >= minLenght && y <= maxHeight && y >= minHeight) {
            return Limits.NONE;
        }

        if (x < minLenght) {
            if (y >= minHeight && y <= maxHeight) {
                return Limits.LEFT;
            }
            if (y < minHeight) {
                return Limits.BOTTOMLEFT;
            }
            if (y > maxHeight) {
                return Limits.TOPLEFT;
            }
        }

        if (x > maxLenght) {
            if (y >= minHeight && y <= maxHeight) {
                return Limits.RIGHT;
            }
            if (y < minHeight) {
                return Limits.BOTTOMRIGHT;
            }
            if (y > maxHeight) {
                return Limits.TOPRIGHT;
            }
        }

        if (y > maxHeight) {
            return Limits.TOP;
        }
        if (y < minHeight) {
            return Limits.BOTTOM;
        }

        if (x < minLenght && xAuxiliary < minLenght) {
            return Limits.OUT;
        }

        if (x > maxLenght && xAuxiliary > maxLenght) {
            return Limits.OUT;
        }

        if (y < minHeight && yAuxiliary < minHeight) {
            return Limits.OUT;
        }

        if (y > maxHeight && yAuxiliary > maxHeight) {
            return Limits.OUT;
        }

        return Limits.ERROR;
    }

}
