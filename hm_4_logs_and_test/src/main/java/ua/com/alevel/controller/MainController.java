package ua.com.alevel.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainController {

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Select your option");
        String position;
        try {
            runNavigation();
            while ((position = reader.readLine()) != null) {
                crud(position);
                position = reader.readLine();
                if (position.equals("0")) {
                    System.exit(0);
                }
                crud(position);
            }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void runNavigation() {
        System.out.println();
        System.out.println("StudentController - 1");
        System.out.println("CourseController - 2");
        System.out.println("EXIT - 0");
        System.out.println();
    }

    private void crud(String position) {
        switch (position) {
            case "1" -> new StudentController().run();
            case "2" -> new CourseController().run();
            case "0" -> System.exit(0);
        }
        runNavigation();
    }
}
