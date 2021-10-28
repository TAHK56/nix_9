package ua.com.alevel.validinput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputUser {

    public static String checkInput() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String yourInput = null;

        try {
            yourInput = bufferedReader.readLine();
            while (yourInput == null || yourInput.isBlank()) {
                System.out.println("You have inputted the incorrect data\n" + "Try again");
                yourInput = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return yourInput;
    }
}
