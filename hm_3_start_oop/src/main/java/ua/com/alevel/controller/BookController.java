package ua.com.alevel.controller;

import ua.com.alevel.entity.Book;
import ua.com.alevel.service.BookService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BookController {
    private final BookService bookService = new BookService();

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("select your option");
        String position;
        try {
            runNavigation();
            while ((position = reader.readLine()) != null) {
                crud(position, reader);
                position = reader.readLine();
                if (position.equals("0")) {
                    System.exit(0);
                }
                crud(position, reader);
            }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void runNavigation() {
        System.out.println();
        System.out.println("if you want create book, please enter 1");
        System.out.println("if you want update book, please enter 2");
        System.out.println("if you want delete book, please enter 3");
        System.out.println("if you want findById book, please enter 4");
        System.out.println("if you want findAll books, please enter 5");
        System.out.println("if you want exit, please enter 0");
        System.out.println();
    }

    private void crud(String position, BufferedReader reader) {
        switch (position) {
            case "1" : create(reader); break;
            case "2" : update(reader); break;
            case "3" : delete(reader); break;
            case "4" : findById(reader); break;
            case "5" : findAll(reader); break;
        }
        runNavigation();
    }

    private void create(BufferedReader reader) {
        System.out.println("BookController.create");
        try {
            System.out.println("Please, enter title");
            String title = reader.readLine();
            System.out.println("Please, enter author");
            String author = reader.readLine();
            Book book = new Book();
            book.setTitle(title);
            book.setAuthor(author);
            bookService.create(book);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void update(BufferedReader reader) {
        System.out.println("BookController.update");
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();
            System.out.println("Please, enter title");
            String title = reader.readLine();
            System.out.println("Please, enter author");
            String author = reader.readLine();
            Book book = new Book();
            book.setId(id);
            book.setTitle(title);
            book.setAuthor(author);
            bookService.update(book);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void delete(BufferedReader reader) {
        System.out.println("BookController.delete");
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();
            bookService.delete(id);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findById(BufferedReader reader) {
        System.out.println("BookController.findById");
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();
            Book book = bookService.findById(id);
            System.out.println("book = " + book);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findAll(BufferedReader reader) {
        System.out.println("BookController.findAll");
        Book[] books = bookService.findAll();
        if (books != null && books.length != 0) {
            for (Book book : books) {
                if (book != null) {
                    System.out.println("book = " + book);
                }
            }
        } else {
            System.out.println("books empty");
        }
    }
}
