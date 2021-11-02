package ua.com.alevel.level3.console;

import ua.com.alevel.level1.validinput.InputUser;

public class InputSizeBoard {

    public static int setSizeBoard() {
        System.out.println("Please input size of our board:");
        String userNumber = checkCorrectSize(InputUser.checkInput());
        return Integer.parseInt(userNumber);
    }

    private static String checkCorrectSize(String userInput) {
        String patternNumber = "^[^0]\\d*$";
        if (!userInput.matches(patternNumber)) {
            System.out.println("Try again");
            userInput = InputUser.checkInput();
        }
        return userInput;
    }
}
