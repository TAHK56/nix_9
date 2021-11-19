package ua.com.alevel;

import ua.com.alevel.util.ConstructorMathSet;
import ua.com.alevel.util.MethodsMathSet;
import ua.com.alevel.util.UserInput;

public class Main {

    private static MathSet<Number> mathSet = new MathSet<>();

    public static MathSet<Number> getMathSet() {
        return mathSet;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to MathSet class");
        System.out.println("Please choose some options");
        runNavigation();
        String answer = UserInput.checkOnNullAndEmpty();
        while (!answer.equals("0")) {
            workWithMathSet(answer);
            runNavigation();
            answer = UserInput.checkOnNullAndEmpty();
        }

    }

    private static void runNavigation() {
        System.out.println();
        System.out.println("Create object MathSet:  - 1");
        System.out.println("Work with methods: - 2");
        System.out.println("EXIT - 0");
        System.out.println();
    }

    private static void workWithMathSet(String answer) {
        switch (answer) {
            case "1" -> {
                ConstructorMathSet.creator();
                ConstructorMathSet.showCreatedConstructors();
                System.out.println("Please choose index MathSet we want to work");
                mathSet = ConstructorMathSet.getMathSets().get(UserInput.getIntegerRange());
            }
            case "2" -> {
                MethodsMathSet.workWithMethods();
            }
        }
    }
}
