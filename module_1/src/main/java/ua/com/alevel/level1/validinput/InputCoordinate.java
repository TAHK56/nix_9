package ua.com.alevel.level1.validinput;

import ua.com.alevel.level1.geomfigure.Point;

public class InputCoordinate {

    private static int initializeFiledPoint() {
        String coordinate = InputUser.checkInput();

        while (!coordinate.matches("[-+]?\\d+")) {
            System.out.println("Please input correct an integer number");
            coordinate = InputUser.checkInput();
        }

        return Integer.parseInt(coordinate);
    }

    public static Point initializePoint() {
        Point point = new Point(initializeFiledPoint(), initializeFiledPoint());
        System.out.println("**********");

        return point;
    }

}
