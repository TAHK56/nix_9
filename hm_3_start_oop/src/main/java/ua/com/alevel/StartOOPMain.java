package ua.com.alevel;

import ua.com.alevel.controller.BookController;

public class StartOOPMain {
    public static void main(String[] args)  {
        try {
            new BookController().run();
        } catch (Exception e) {
            System.err.println("You have made a mistake");
        }
    }
}
