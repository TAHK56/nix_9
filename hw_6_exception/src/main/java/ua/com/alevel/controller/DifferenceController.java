package ua.com.alevel.controller;

import ua.com.alevel.date.CalendarDate;
import ua.com.alevel.date.MyDate;
import ua.com.alevel.date.Time;
import ua.com.alevel.format.InputFormat;
import ua.com.alevel.format.OutputFormat;
import ua.com.alevel.util.ConvertMillisecondsInTimeAndDate;
import ua.com.alevel.util.DateInMilliseconds;
import ua.com.alevel.util.DifferenceBetweenTwoDate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class DifferenceController {

    private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private final InputFormat inputFormat = new InputFormat();
    private final OutputFormat outputFormat = new OutputFormat();

    public void run() {
        System.out.println("Difference between dates in: ");
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
        System.out.println("1-Milliseconds");
        System.out.println("2-Seconds");
        System.out.println("3-Minutes");
        System.out.println("4-Hours");
        System.out.println("5-Days");
        System.out.println("6-Years");
        System.out.println("0-Exit");
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

    private void doChoiceUser(String position) {
        System.out.println("Input first date: ");
        MyDate first = inputFormat.getUserDate();
        System.out.println("Input second date: ");
        MyDate second = inputFormat.getUserDate();
        MyDate result = new MyDate(new Time(), new CalendarDate());
        BigInteger differenceResult = BigInteger.ZERO;

        switch (position) {
            case "1" -> {
                System.out.print("In milliseconds: ");
                differenceResult = DifferenceBetweenTwoDate.findDifferenceInMilliseconds(first, second);
                result = ConvertMillisecondsInTimeAndDate.convertMillisecondsInDate(differenceResult);
                System.out.println(differenceResult);
                outputFormat.showDate(result);

            }
            case "2" -> {
                System.out.print("In seconds: ");
                differenceResult = DifferenceBetweenTwoDate.findDifferenceInSeconds(first, second);
                result = ConvertMillisecondsInTimeAndDate.convertMillisecondsInDate(DateInMilliseconds.convertSeconds(differenceResult.intValue()));
                System.out.println(differenceResult);
                outputFormat.showDate(result);
            }
            case "3" -> {
                System.out.print("In minutes: ");
                differenceResult = DifferenceBetweenTwoDate.findDifferenceInMinutes(first, second);
                result = ConvertMillisecondsInTimeAndDate.convertMillisecondsInDate(DateInMilliseconds.convertMinutes(differenceResult.intValue()));
                System.out.println(differenceResult);
                outputFormat.showDate(result);
            }
            case "4" -> {
                System.out.print("In hours: ");
                differenceResult = DifferenceBetweenTwoDate.findDifferenceInHours(first, second);
                result = ConvertMillisecondsInTimeAndDate.convertMillisecondsInDate(DateInMilliseconds.convertHours(differenceResult.intValue()));
                System.out.println(differenceResult);
                outputFormat.showDate(result);
            }
            case "5" -> {
                System.out.print("In days: ");
                differenceResult = DifferenceBetweenTwoDate.findDifferenceInDays(first, second);
                result = ConvertMillisecondsInTimeAndDate.convertMillisecondsInDate(DateInMilliseconds.convertDays(differenceResult.intValue()));
                System.out.println(differenceResult);
                outputFormat.showDate(result);
            }
            case "6" -> {
                System.out.print("In years: ");
                differenceResult = DifferenceBetweenTwoDate.findDifferenceInYears(first, second);
                result = ConvertMillisecondsInTimeAndDate.convertMillisecondsInDate(DateInMilliseconds.convertYears(differenceResult.intValue()));
                System.out.println(differenceResult);
                outputFormat.showDate(result);
            }
        }
        System.out.println("Do you want finish?(0)");
    }
}
