package ua.com.alevel.controller;

import ua.com.alevel.date.CalendarDate;
import ua.com.alevel.date.MyDate;
import ua.com.alevel.date.Time;
import ua.com.alevel.format.InputFormat;
import ua.com.alevel.format.OutputFormat;
import ua.com.alevel.util.ConvertMillisecondsInTimeAndDate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class ArithmeticController {

    private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private final InputFormat inputFormat = new InputFormat();
    private final OutputFormat outputFormat = new OutputFormat();

    public void run(String answer) {
        String position;
        try {
            if (answer.equals("2")) {
                System.out.println("Add operation: ");
                runNavigation();
                position = inputUser();
                addChoiceUser(position);
            } else {
                System.out.println("Subtract operation: ");
                runNavigation();
                position = inputUser();
                subtractChoiceUser(position);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void runNavigation() {
        System.out.println("1-Milliseconds");
        System.out.println("2-Seconds");
        System.out.println("3-Minutes");
        System.out.println("4-Hours");
        System.out.println("5-Days");
        System.out.println("6-Years");
        System.out.println("0-Exit");
        System.out.println();
    }

    private String inputUser() throws IOException {
        String userInput = bufferedReader.readLine();
        if (userInput == null || userInput.isBlank()) {
            System.out.println("Try again!!");
            inputUser();
        }
        while (!userInput.matches("[0-6]")) {
            System.out.println("Try again!!");
            inputUser();
        }
        return userInput;
    }

    private void addChoiceUser(String position) throws IOException {
        System.out.println("Input date: ");
        MyDate first = inputFormat.getUserDate();
        System.out.println("Input the number");
        String numberString = bufferedReader.readLine();
        while (numberString == null || numberString.isBlank() || !numberString.matches("\\d+")) {
            numberString = bufferedReader.readLine();
        }
        int number = Integer.parseInt(numberString);
        MyDate result = new MyDate(new Time(), new CalendarDate());

        switch (position) {
            case "1" -> {
                System.out.print("Add milliseconds: ");
                result = ConvertMillisecondsInTimeAndDate.addMilliseconds(BigInteger.valueOf(number), first);
                System.out.println(result);
                outputFormat.showDate(result);

            }
            case "2" -> {
                System.out.print("Add seconds: ");
                result = ConvertMillisecondsInTimeAndDate.addSeconds(number, first);
                System.out.println(result);
                outputFormat.showDate(result);
            }
            case "3" -> {
                System.out.print("Add minutes: ");
                result = ConvertMillisecondsInTimeAndDate.addMinutes(number, first);
                System.out.println(result);
                outputFormat.showDate(result);
            }
            case "4" -> {
                System.out.print("Add hours: ");
                result = ConvertMillisecondsInTimeAndDate.addHours(number, first);
                System.out.println(result);
                outputFormat.showDate(result);
            }
            case "5" -> {
                System.out.print("Add days: ");
                result = ConvertMillisecondsInTimeAndDate.addDays(number, first);
                System.out.println(result);
                outputFormat.showDate(result);
            }
            case "6" -> {
                System.out.print("Add years: ");
                result = ConvertMillisecondsInTimeAndDate.addYears(number, first);
                System.out.println(result);
                outputFormat.showDate(result);
            }
        }
        System.out.println("Do you want finish?(0)");
    }

    private void subtractChoiceUser(String position) throws IOException {
        System.out.println("Input date: ");
        MyDate first = inputFormat.getUserDate();
        System.out.println("Input the number");
        String numberString = bufferedReader.readLine();
        while (numberString == null || numberString.isBlank() || !numberString.matches("\\d+")) {
            numberString = bufferedReader.readLine();
        }
        int number = Integer.parseInt(numberString);
        MyDate result = new MyDate(new Time(), new CalendarDate());

        switch (position) {
            case "1" -> {
                System.out.print("Subtract milliseconds: ");
                result = ConvertMillisecondsInTimeAndDate.subtractMilliseconds(BigInteger.valueOf(number), first);
                System.out.println(result);
                outputFormat.showDate(result);

            }
            case "2" -> {
                System.out.print("Subtract seconds: ");
                result = ConvertMillisecondsInTimeAndDate.subtractSeconds(number, first);
                System.out.println(result);
                outputFormat.showDate(result);
            }
            case "3" -> {
                System.out.print("Subtract minutes: ");
                result = ConvertMillisecondsInTimeAndDate.subtractMinutes(number, first);
                System.out.println(result);
                outputFormat.showDate(result);
            }
            case "4" -> {
                System.out.print("Subtract hours: ");
                result = ConvertMillisecondsInTimeAndDate.subtractHours(number, first);
                System.out.println(result);
                outputFormat.showDate(result);
            }
            case "5" -> {
                System.out.print("Subtract days: ");
                result = ConvertMillisecondsInTimeAndDate.subtractDays(number, first);
                System.out.println(result);
                outputFormat.showDate(result);
            }
            case "6" -> {
                System.out.print("Subtract years: ");
                result = ConvertMillisecondsInTimeAndDate.subtractYears(number, first);
                System.out.println(result);
                outputFormat.showDate(result);
            }
        }
        System.out.println("Do you want finish?(0)");
    }
}
