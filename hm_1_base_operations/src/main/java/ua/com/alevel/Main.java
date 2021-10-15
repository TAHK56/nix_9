package ua.com.alevel;

import ua.com.alevel.firsttask.First;
import ua.com.alevel.secondtask.Lesson;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Our first task: ");
        First first = new First();
        first.start();

        System.out.println("Our second task: ");
        Lesson lesson = new Lesson();
        lesson.begin();
    }
}
