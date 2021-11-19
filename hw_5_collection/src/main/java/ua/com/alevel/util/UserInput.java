package ua.com.alevel.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UserInput {

    private static final String PATTERN_POSITIVE_INTEGER = "\\d+";
    private static final String PATTERN_NUMBERS = "((-|\\+)?\\d+(\\.\\d+)?)+";
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static int getIntegerRange() {
        String capacityInput;
        int capacity = 0;
        try {
            capacityInput = reader.readLine();
            if (capacityInput.matches(PATTERN_POSITIVE_INTEGER)) {
                capacity = Integer.parseInt(capacityInput);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return capacity;
    }

    public static String checkOnNullAndEmpty() {
        String input = null;
        try {
            input = reader.readLine();
            while (input == null || input.isBlank()) {
                input = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }

    public static Number[] getArrayFromUser() {
        System.out.println("Please input array of numbers in one string with space (or we return array of length 0)");
        String userArray = checkOnNullAndEmpty();
        String[] numbersArray = userArray.split(" ");
        Number[] numbers = new Number[numbersArray.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = checkInput(numbersArray[i]);
        }
        return numbers;
    }

    public static String chooseUser() {
        String numberUser = checkOnNullAndEmpty();
        if (!numberUser.matches("[0-6]")) {
            System.out.println("You have inputted incorect number, and we use default choice 1");
            numberUser = "1";
        }
        return numberUser;
    }

    public static Number checkInput(String number) {
        Number num = null;
        if (number.matches(PATTERN_NUMBERS)) {
            if (number.contains(".")) {
                num = Double.parseDouble(number);
            } else {
                num = Long.parseLong(number);
            }
        } else {
            System.out.println("We have missed no numbers");
        }
        return num;
    }


}
