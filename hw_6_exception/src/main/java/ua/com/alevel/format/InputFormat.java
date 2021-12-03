package ua.com.alevel.format;

import ua.com.alevel.date.CalendarDate;
import ua.com.alevel.date.Month;
import ua.com.alevel.date.MyDate;
import ua.com.alevel.date.Time;
import ua.com.alevel.exception.MyDateException;
import ua.com.alevel.util.DateInMilliseconds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputFormat {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public MyDate getUserDate() {
        String format = null;
        MyDate myDate = new MyDate(new Time(), new CalendarDate());
        try {
            showExample();
            format = inputUser();
            myDate = checkFormat(format);
            if (format.equals("0")) {
                return myDate;
            }

        } catch (IOException | MyDateException e) {
            System.err.println("You have made a mistake! Try again!!");
            getUserDate();
        }
        return myDate;
    }

    private void showExample() {
        System.out.println("Please input date one of the formats:");
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
        while (!userInput.matches("[0-4]")) {
            System.out.println("Try again!!");
            inputUser();
        }
        return userInput;
    }

    private MyDate checkFormat(String position) throws IOException {
        String date = bufferedReader.readLine();
        Time time = new Time();
        CalendarDate calendarDate = new CalendarDate();
        if (date == null || date.isBlank()) {
            checkFormat(position);
        }

        MyDate myDate = new MyDate(time, calendarDate);

        switch (position) {
            case "1" -> {
                if (date.contains("/")) {
                    String[] currentDate = date.split("[/ ]");
                    if (currentDate.length >= 3) {
                        if (checkYear(currentDate[2], true)) {
                            calendarDate.setYear(Integer.parseInt(currentDate[2]));
                            if (checkMonth(currentDate[1], true)) {
                                calendarDate.setMonth(Integer.parseInt(currentDate[1]));
                                if (checkDateNumber(currentDate[0], calendarDate.getMonth(), calendarDate.getYear())) {
                                    calendarDate.setDay(Integer.parseInt(currentDate[0]));
                                }
                            }
                        }
                    }
                    if (currentDate.length == 4) {
                        if (checkTime(currentDate[3])) {
                            time = create(currentDate[3]);
                        }
                    }
                } else {
                    throw new MyDateException();
                }
                myDate = new MyDate(time, calendarDate);
            }
            case "2" -> {
                if (date.contains("/")) {
                    String[] currentDate = date.split("[/ ]");
                    if (currentDate.length >= 3) {
                        if (checkYear(currentDate[2], false)) {
                            calendarDate.setYear(Integer.parseInt(currentDate[2]));
                            if (checkMonth(currentDate[0], true)) {
                                calendarDate.setMonth(Integer.parseInt(currentDate[0]));
                                if (checkDateNumber(currentDate[1], calendarDate.getMonth(), calendarDate.getYear())) {
                                    calendarDate.setDay(Integer.parseInt(currentDate[1]));
                                }
                            }
                        }
                    }
                    if (currentDate.length == 4) {
                        if (checkTime(currentDate[3])) {
                            time = create(currentDate[3]);
                        }
                    }
                } else {
                    throw new MyDateException();
                }
                myDate = new MyDate(time, calendarDate);
            }
            case "3" -> {
                if (date.contains("-")) {
                    String[] currentDate = date.split("[- ]");
                    if (currentDate.length >= 3) {
                        if (checkYear(currentDate[2], true)) {
                            calendarDate.setYear(Integer.parseInt(currentDate[2]));
                            if (checkMonth(currentDate[0], false)) {
                                int monthUser = Month.valueOf(currentDate[0].toUpperCase()).ordinal() + 1;
                                calendarDate.setMonth(monthUser);
                                if (checkDateNumber(currentDate[1], calendarDate.getMonth(), calendarDate.getYear())) {
                                    calendarDate.setDay(Integer.parseInt(currentDate[1]));
                                }
                            }
                        }
                    }
                    if (currentDate.length == 4) {
                        if (checkTime(currentDate[3])) {
                            time = create(currentDate[3]);
                        }
                    }
                } else {
                    throw new MyDateException();

                }
                myDate = new MyDate(time, calendarDate);
            }
            case "4" -> {
                if (date.contains("-")) {
                    String[] currentDate = date.split("[- ]");
                    if (currentDate.length >= 3) {
                        if (checkYear(currentDate[2], false)) {
                            calendarDate.setYear(Integer.parseInt(currentDate[2]));
                            if (checkMonth(currentDate[1], false)) {
                                int monthUser = Month.valueOf(currentDate[1].toUpperCase()).ordinal() + 1;
                                calendarDate.setMonth(monthUser);
                                if (checkDateNumber(currentDate[0], calendarDate.getMonth(), calendarDate.getYear())) {
                                    calendarDate.setDay(Integer.parseInt(currentDate[0]));
                                }
                            }
                        }
                    }
                    if (currentDate.length == 4) {
                        if (checkTime(currentDate[3])) {
                            time = create(currentDate[3]);
                        }
                    }

                } else {
                    throw new MyDateException();
                }
                myDate = new MyDate(time, calendarDate);
            }

        }
        return myDate;
    }

    private boolean checkTime(String time) {
        return time.matches("([01]?[0-9]|2[0-3]):[0-5]?[0-9](:[0-5][0-9]:[0-9]{0,3})?");
    }

    private boolean checkYear(String yearFormat, boolean twoDigits) {
        boolean result = false;
        if (twoDigits) {
            result = yearFormat.matches("\\d{2}");
        } else {
            result = yearFormat.matches("\\d{1,4}");
        }
        return result;
    }

    private boolean checkMonth(String monthFormat, boolean digitFormat) {
        boolean result = false;
        if (digitFormat) {
            result = monthFormat.matches("[1-9]|1[0-2]");
        } else {
            for (Month month : Month.values()) {
                result = month.name().equalsIgnoreCase(monthFormat);
                if (result) {
                    return true;
                }
            }
        }
        return result;
    }

    private boolean checkDateNumber(String numberFormat, int month, int year) {
        boolean result = switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> numberFormat.matches("[0-2]?[1-9]|3[01]");
            case 2 -> DateInMilliseconds.isLeapYear(year) ? numberFormat.matches("[0-2]?[1-9]") : numberFormat.matches("[0-1]?[1-9]|2[1-8]");
            case 4, 6, 9, 11 -> numberFormat.matches("[0-2]?[1-9]|30");
            default -> false;
        };
        return result;
    }

    private Time create(String times) throws MyDateException {
        Time time = new Time();
        String[] patternTime = times.split(":");
        int count = patternTime.length;
        while (count > 0) {
            switch (count) {
                case 4 -> time.setMillisecond(Integer.parseInt(patternTime[count - 1]));
                case 3 -> time.setSecond(Integer.parseInt(patternTime[count - 1]));
                case 2 -> time.setMinute(Integer.parseInt(patternTime[count - 1]));
                case 1 -> time.setHour(Integer.parseInt(patternTime[count - 1]));
            }
            count--;
        }
        return time;
    }
}
