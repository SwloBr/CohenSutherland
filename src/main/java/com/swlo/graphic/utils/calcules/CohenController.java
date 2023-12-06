package com.swlo.graphic.utils.calcules;


import com.swlo.graphic.ScreenSize;
import com.swlo.graphic.utils.limits.Limits;

public class CohenController {

    private double[] firstPoint, secondPoint;
    private ScreenSize screenSize;
    private CohenInclination cohenInclination = new CohenInclination();
    private CohenCheckLimits cohenCheckLimits;
    private CohenClip cohenClip;


    public CohenController(ScreenSize screenSize) {
        this.screenSize = screenSize;
        this.cohenCheckLimits = new CohenCheckLimits(screenSize);
        this.cohenClip = new CohenClip(screenSize);
    }

    public double[][] execute(double[] firstPoint, double[] secondPoint) {

        double inclination = cohenInclination.calc(firstPoint[0], firstPoint[1], secondPoint[0], secondPoint[1]);

        Limits fisrtLimits = cohenCheckLimits.checkLimit(firstPoint, secondPoint);
        Limits secondLimits = cohenCheckLimits.checkLimit(secondPoint, firstPoint);

        System.out.println("INCLINAÇÃO: " + inclination);

        if (fisrtLimits == Limits.OUT) {
            return null;
        }

        double[] clippedFirstPoint = cohenClip.clipPoint(firstPoint, fisrtLimits, inclination);
        double[] clippedSecondPoint = cohenClip.clipPoint(secondPoint, secondLimits, inclination);

        return new double[][] {clippedFirstPoint, clippedSecondPoint};
    }


}
