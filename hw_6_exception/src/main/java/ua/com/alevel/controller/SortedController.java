package ua.com.alevel.controller;

import ua.com.alevel.date.MyDate;
import ua.com.alevel.format.InputFormat;
import ua.com.alevel.format.OutputFormat;
import ua.com.alevel.util.SortDates;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SortedController {

    private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private final InputFormat inputFormat = new InputFormat();
    private final OutputFormat outputFormat = new OutputFormat();

    public void run() {
        System.out.println("Sorted dates: ");
        String position;

        try {
            runNavigation();
            while (!(position = inputUser()).equals("0")) {
                runNavigation();
                doChoiceUser(position);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void runNavigation() {
        System.out.println("1-Ascending order: ");
        System.out.println("2-Descending order: ");
        System.out.println("0-Exit");
        System.out.println();
    }

    private String inputUser() throws IOException {
        String userInput = bufferedReader.readLine();
        if (userInput == null || userInput.isBlank()) {
            System.out.println("Try again!!");
            inputUser();
        }
        while (!userInput.matches("[0-2]")) {
            System.out.println("Try again!!");
            inputUser();
        }
        return userInput;
    }

    private void doChoiceUser(String position) throws IOException {
        System.out.println("Input dates: ");
        List<MyDate> myDates = new ArrayList<>();
        System.out.println("How many dates do you want to sort? ");
        String answer = bufferedReader.readLine();
        if (answer == null || answer.isBlank() || !answer.matches("\\d+")) {
            doChoiceUser(position);
        }
        int numberDates = Integer.parseInt(answer);

        while (numberDates > 0) {
            myDates.add(inputFormat.getUserDate());
            numberDates--;
        }

        switch (position) {
            case "1" -> outputFormat.showList(SortDates.sort(myDates, true));
            case "2" -> outputFormat.showList(SortDates.sort(myDates, false));
        }
    }
}
