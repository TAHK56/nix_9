package ua.com.alevel.firsttask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class UserInput {
    public String checkInput() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println((char) 27 + "[01;32m" + "Input a string for finding numbers and letters ");

        String userInput = bufferedReader.readLine();

        while (userInput == null || userInput.isEmpty()) {
            System.out.println("Unfortunately you have inputted the incorrect string!!\nPlease input again!!");
            userInput = bufferedReader.readLine();
        }
        return userInput;
    }
}
