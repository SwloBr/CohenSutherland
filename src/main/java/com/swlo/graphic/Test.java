package com.swlo.graphic;

import com.swlo.graphic.utils.calcules.CohenController;

public class Test {

    public static void main(String[] args) {

        ScreenSize screenSize = new ScreenSize(20, 20, 0, 0);
        CohenController cohenController = new CohenController(screenSize);


        double[] firstPoint = new double[]{-13, 5};
        double[] secondPoint = new double[]{25, 3};

        double[][] ll = cohenController.execute(firstPoint, secondPoint);
        if (ll == null) {
            System.out.println("DEU NULL");
        } else {

            System.out.printf("First:\n X: %.2f\n Y: %.2f\n\nSecond:\n X: %.2f\n Y: %.2f", ll[0][0], ll[0][1], ll[1][0], ll[1][1]);
        }


    }
}
