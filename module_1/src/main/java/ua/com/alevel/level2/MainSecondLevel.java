package ua.com.alevel.level2;

import ua.com.alevel.TaskHelper;
import ua.com.alevel.level1.validinput.InputUser;
import ua.com.alevel.level2.bracket.BalancedBrackets;
import ua.com.alevel.level2.helper.UserBuilderBinaryTree;

public class MainSecondLevel implements TaskHelper {

    @Override
    public  void run() {
        runNavigation();
        String userInput = InputUser.checkInput();

        switch (checkNumber(userInput)) {
            case "1":
                System.out.println("Input the string for testing brackets: ");
                String userBrackets = InputUser.checkInput();

                if (BalancedBrackets.isBracketBalanced(userBrackets)) {
                    System.out.println("The string is balanced");
                } else {
                    System.out.println("The string is not balanced");
                }
                break;
            case "2":
                System.out.println("Binary tree");
                UserBuilderBinaryTree.run();
                break;
            default:
                System.out.println("____________");
                break;
        }
        System.out.println("Do you want to go on? Input Y/N(or another symbol)");
        String answer = InputUser.checkInput();
        if (answer.equalsIgnoreCase("Y")) {
            run();
        }
    }

    private static void runNavigation() {
        System.out.println("Hello. This is level 2 of the first module.\n" +
                "Please, choose something from my preview.\n" +
                "1-Define balanced string\n" +
                "2-Find depth  in binary tree\n" +
                "0-Exit");
    }

    private static String checkNumber(String userInput) {
        while (!userInput.matches("[0-2]")) {
            System.out.println("Unfortunately you have chosen the incorrect symbol\n" +
                    "Try again");
            userInput = InputUser.checkInput();
        }
        return userInput;
    }
}
