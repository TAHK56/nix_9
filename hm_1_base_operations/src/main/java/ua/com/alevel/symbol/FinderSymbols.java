package ua.com.alevel.symbol;

import ua.com.alevel.TaskHelper;
import ua.com.alevel.UserInput;

import java.util.HashMap;
import java.util.Map;

public class FinderSymbols implements TaskHelper
{
    @Override
    public void run()  {
        UserInput userInput = new UserInput();
        System.out.println("Input a string for finding numbers and letters ");
        String rightInput = userInput.checkInput();

        showCountedLetters(rightInput);
        showSumUpNumbersInString(rightInput);
    }

   private void showSumUpNumbersInString(String search) {
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

   private void showCountedLetters(String search) {
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
