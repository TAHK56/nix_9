package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInput {
    public String checkInput() {
        String userInputString = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            userInputString = bufferedReader.readLine();

            while (userInputString == null || userInputString.isEmpty()) {
                System.out.println("Unfortunately you have inputted the incorrect string!!\nPlease input again!!");
                userInputString = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userInputString;
    }
}
