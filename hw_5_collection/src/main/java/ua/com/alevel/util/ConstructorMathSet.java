package ua.com.alevel.util;

import ua.com.alevel.MathSet;

import java.util.List;

public class ConstructorMathSet {

    private static List<MathSet<Number>> list;

    public static void creator() {
        runNavigation();

    }

    public static List<MathSet<Number>> getList() {
        return list;
    }

    private static void runNavigation() {
        System.out.println("Create object MathSet: ");
        System.out.println("By default  - 1");
        System.out.println("Give capacity - 2");
        System.out.println("Give an array of numbers - 3");
        System.out.println("Give arrays of numbers - 4");
        System.out.println("Give created MathSet(or using default) - 5");
        System.out.println("Give created MathSets - 6");
        System.out.println("EXIT - 0");
        System.out.println();
    }
}
