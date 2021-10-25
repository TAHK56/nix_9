package ua.com.alevel;

import ua.com.alevel.geomfigure.Triangle;
import ua.com.alevel.uniquenumber.UniqueNumberArray;
import ua.com.alevel.validinput.InputArray;
import ua.com.alevel.validinput.InputUser;

public class Main {

    public static void main(String[] args) {
        runNavigation();

        String userInput = InputUser.checkInput();

        switch (checkNumber(userInput)) {
            case "1" :
                System.out.println("The unique number in array is "
                        + UniqueNumberArray.countUniqueElements(InputArray.create()));
                break;
            case "2" :
                System.out.println("Input coordinate for all tops using enter(Every top will be mark ****) ");
                System.out.println("The area of a triangle is " + new Triangle().computeArea());
                break;
            case "3" :
                break;
            default:
                System.out.println("Maybe next time... Goodbye");
                break;
        }

    }

    private static void runNavigation() {
        System.out.println("Hello. This is level 1 of the first module.\n" +
                "Please, choose something from my preview.\n" +
                "1-Unique numbers in an array\n" +
                "2-Triangle area\n" +
                "3-Horse on the chessboard\n" +
                "0-If you do not continue\n");
    }

    private static String checkNumber(String userInput) {
        while (!userInput.matches("[0-3]")) {
            System.out.println("Unfortunately you have chosen the incorrect symbol\n" +
                    "Try again");
            userInput = InputUser.checkInput();
        }
        return userInput;
    }

}
