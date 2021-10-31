package ua.com.alevel.level1.geomfigure;

import ua.com.alevel.level1.validinput.InputCoordinate;
import java.math.BigDecimal;

public class Triangle extends Shape {

    public static final int NUMBER_TOPS = 3;
    private static final Point[] TOPS = new Point[NUMBER_TOPS];

    public Triangle() {
        initializeTops();

    }

    @Override
    public  BigDecimal computeArea() {
        //Use this formula s = |(x2 - x1)(y3 - y1) - (x3 - x1)(y2 - y1)| / 2
        BigDecimal coefficient = new BigDecimal("2");
        final int FIRST_TOP = 0;
        final int SECOND_TOP = 1;
        final int THIRD_TOP = 2;

        BigDecimal factorFirst = new BigDecimal(TOPS[SECOND_TOP].getX() - TOPS[FIRST_TOP].getX());
        BigDecimal factorSecond = new BigDecimal(TOPS[THIRD_TOP].getY() - TOPS[FIRST_TOP].getY());
        BigDecimal factorThird = new BigDecimal(TOPS[THIRD_TOP].getX() - TOPS[FIRST_TOP].getX());
        BigDecimal factorFourth = new BigDecimal(TOPS[SECOND_TOP].getY() - TOPS[FIRST_TOP].getY());

        BigDecimal insideAbsValue = factorFirst.multiply(factorSecond).subtract(factorThird.multiply(factorFourth));
        BigDecimal area = insideAbsValue.abs().divide(coefficient);
        if (area.equals(BigDecimal.ZERO)) {
            System.out.println("All points are one line!!!");
        }

        return area;
    }

    private static void initializeTops() {
        for (int i = 0; i < NUMBER_TOPS; i++) {
            TOPS[i] = InputCoordinate.initializePoint();
        }
    }
}
