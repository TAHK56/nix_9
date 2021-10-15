package ua.com.alevel.secondtask;

import java.util.Scanner;

class UserConsole {
     public int inputLesson() {
         Scanner scanner = new Scanner(System.in);
         System.out.println("Please input number a lesson from 1 to 10");

         //User input correct number(from homework)
         int numberLesson = scanner.nextInt();
         return numberLesson;
     }
}
