package ua.com.alevel;

import ua.com.alevel.level1.MainFirstLevel;
import ua.com.alevel.level1.validinput.InputUser;
import ua.com.alevel.level2.MainSecondLevel;
import ua.com.alevel.level3.MainThirdLevel;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<TaskHelper> levels = new ArrayList<>();
        levels.add(new MainFirstLevel());
        levels.add(new MainSecondLevel());
        levels.add(new MainThirdLevel());

        System.out.println("Please choose one of the three levels or 0-exit");
        String userChoice = checkNumber(InputUser.checkInput());
        switch (userChoice) {
            case "1":
                levels.get(0).run();
                break;
            case "2":
                levels.get(1).run();
                break;
            case "3":
                levels.get(2).run();
                break;
            default:
                System.out.println("**********");
                break;
        }
        System.out.println("\nIf you want to repeat you should input Y");
        String answer = InputUser.checkInput();
        if (answer.equalsIgnoreCase("Y")) {
            main(args);
        }
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
