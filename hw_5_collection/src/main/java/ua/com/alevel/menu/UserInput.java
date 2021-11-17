package ua.com.alevel.menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInput {

    private static BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));

    private static final String PATTERN_POSITIVE_INTEGER = "//d+";
    private static final String PATTERN_ARRAY_NUMBERS = "^[-|+]?//d+(//.)?//d+$";

    public static int getCapacity() {
        System.out.println("Input capacity of MathSet(or we create with 0 capacity) ");
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

    public static Number[] getArray() {
        return new Number[0];
    }
}
