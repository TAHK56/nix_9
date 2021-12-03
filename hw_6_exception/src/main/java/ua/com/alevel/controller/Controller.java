package ua.com.alevel.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {

    private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private final DifferenceController differenceController = new DifferenceController();
    private final ArithmeticController arithmeticController = new ArithmeticController();
    private final SortedController sortedController = new SortedController();

    public void run() {
        System.out.println("Choose one of the options: ");
        String position;

        try {
            runNavigation();
            while (!(position = inputUser()).equals("0")) {
                doChoiceUser(position);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void runNavigation() {
        System.out.println("1-Difference between dates");
        System.out.println("2-Addition");
        System.out.println("3-Subtraction");
        System.out.println("4-Sorting");
        System.out.println("0-Exit");
        System.out.println();
    }

    private String inputUser() throws IOException {
        String userInput = bufferedReader.readLine();
        if (userInput == null || userInput.isBlank()) {
            System.out.println("Try again!!");
            inputUser();
        }
        while (!userInput.matches("[0-4]")) {
            System.out.println("Try again!!");
            inputUser();
        }
        return userInput;
    }

    private void doChoiceUser(String position) {
        switch (position) {
            case "1" -> differenceController.run();
            case "2", "3" -> arithmeticController.run(position);
            case "4" -> sortedController.run();
            default -> System.out.println("Something wrong");
        }
    }
}
