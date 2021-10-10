package ua.com.alevel.firsttask;

import java.io.IOException;
import java.util.*;

public class First {
    public static void main(String[] args) throws IOException {
        UserInput userInput = new UserInput();
        String rightInput = userInput.checkInput();

        First first = new First();
        first.showSumUpNumbersInString(rightInput);
        first.showCountedLetters(rightInput);
    }

    void showSumUpNumbersInString(String search) {
        int sum = 0;


        for (int i = 0; i < search.length(); i++) {
            String tmp = search.substring(i, i + 1);
            if (tmp.matches("\\d")) {
                sum += Integer.parseInt(tmp);
            }
        }

        System.out.println("Inputted string: " + search);
        System.out.println("The sum of numbers in string is " + sum);
    }

    void showCountedLetters(String search) {
        Map<String, Integer> numberLetters = new HashMap<>();

        for (int i = 0; i < search.length(); i++) {
            String tmp = search.substring(i, i + 1);
            if (tmp.matches("[a-zA-Zа-яА-Я]")) {
                numberLetters.compute(tmp, (k, v) -> (v == null) ? 1 : ++v);
            }

        }

        numberLetters.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(System.out::println);

    }
}
