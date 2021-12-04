package ua.com.alevel.format;

import ua.com.alevel.date.Month;
import ua.com.alevel.date.MyDate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class OutputFormat {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public void showDate(MyDate myDate) {
        showExample();
        try {
            String position = inputUser();
                showChoiceUser(position, myDate);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showExample() {
        System.out.println("Please output date one of the formats:");
        System.out.println("1: dd/mm/yy - 01/12/21");
        System.out.println("2: m/d/yyyy - 3/4/2021");
        System.out.println("3: mmm-d-yy - March 4 21");
        System.out.println("4: dd-mmm-yyyy 00:00 - 09 April 789 23:45");
        System.out.println("0: EXIT(With default date)");
    }

    private String inputUser() throws IOException {
        String userInput = bufferedReader.readLine();
        if (userInput == null || userInput.isBlank()) {
            System.out.println("Try again!!");
            inputUser();
        }
        while (!userInput.matches("[1-4]")) {
            System.out.println("Try again!!");
            inputUser();
        }
        return userInput;
    }

    private void showChoiceUser(String position, MyDate myDate) {
        switch (position) {
            case "1" -> System.out.println(myDate.getDate().getDay() + "/" + myDate.getDate().getMonth() + "/"
                    + myDate.getDate().getYear() + " " + myDate.getTime().getHour() + ":" + myDate.getTime().getMinute() + ":"
                    + myDate.getTime().getSecond() + ":" + myDate.getTime().getMillisecond());
            case "2" -> System.out.println(myDate.getDate().getMonth() + "/" + myDate.getDate().getDay() + "/"
                    + myDate.getDate().getYear() + " " + myDate.getTime().getHour() + ":" + myDate.getTime().getMinute() + ":"
                    + myDate.getTime().getSecond() + ":" + myDate.getTime().getMillisecond());
            case "3" -> {
                int month = myDate.getDate().getMonth();
                String searchMonth = Month.JANUARY.toString();
                for (Month month1 : Month.values()) {
                    if (month1.ordinal() == month - 1) {
                        searchMonth = month1.toString();
                    }
                }
                System.out.println(searchMonth + "-" + myDate.getDate().getDay() + "-"
                        + myDate.getDate().getYear() + " " + myDate.getTime().getHour() + ":" + myDate.getTime().getMinute() + ":"
                        + myDate.getTime().getSecond() + ":" + myDate.getTime().getMillisecond());
            }
            case "4" -> {
                int month = myDate.getDate().getMonth();
                String searchMonth = Month.JANUARY.toString();
                for (Month month1 : Month.values()) {
                    if (month1.ordinal() == month - 1) {
                        searchMonth = month1.toString();
                    }
                }
                System.out.println( myDate.getDate().getDay() + "-" + searchMonth + "-"
                        + myDate.getDate().getYear() + " " + myDate.getTime().getHour() + ":" + myDate.getTime().getMinute() + ":"
                        + myDate.getTime().getSecond() + ":" + myDate.getTime().getMillisecond());
            }
        }
    }

    public void showList(List<MyDate> myDates) throws IOException {
        for (MyDate myDate : myDates) {
            showExample();
            System.out.println("Make your choice");
            String position = inputUser();
            showChoiceUser(position, myDate);
        }
    }
}
