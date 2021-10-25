package ua.com.alevel.geomfigure;

import ua.com.alevel.validinput.InputCoordinate;

import java.math.BigDecimal;

public class Triangle extends Figure {

    public static final int NUMBER_SIDE = 3;
    private static final Point[] tops = new Point[NUMBER_SIDE];

    public Triangle() {
        initializeTops();
    }

    @Override
    public  BigDecimal computeArea() {
        //Use this formula s = |(x2 - x1)(y3 - y1) - (x3 - x1)(y2 - y1)| / 2

        final BigDecimal coefficient = new BigDecimal("2");

        BigDecimal factorFirst = new BigDecimal(tops[1].getX() - tops[0].getX());
        BigDecimal factorSecond = new BigDecimal(tops[2].getY() - tops[0].getY());
        BigDecimal factorThird = new BigDecimal(tops[2].getX() - tops[0].getX());
        BigDecimal factorFourth = new BigDecimal(tops[1].getY() - tops[0].getY());

        BigDecimal insideAbsValue = factorFirst.multiply(factorSecond).subtract(factorThird.multiply(factorFourth));
        BigDecimal res = insideAbsValue.abs().divide(coefficient);
        if (res.equals(BigDecimal.ZERO)) {
            System.out.println("All points are one line!!!");
        }
        return res;
    }

    private static void initializeTops() {
        for (int i = 0; i < NUMBER_SIDE; i++) {
            tops[i] = InputCoordinate.initializePoint();
        }
    }


}
