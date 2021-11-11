package ua.com.alevel.controller;

import ua.com.alevel.entity.Student;
import ua.com.alevel.service.impl.StudentServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

public class StudentController {

    private static final StudentServiceImpl studentService = new StudentServiceImpl();

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Select your option");
        String position;
        try {
            runNavigation();
            while ((position = reader.readLine()) != null) {
                crud(position, reader);
                position = reader.readLine();
                if (position.equals("0")) {
                    break;
                }
                crud(position, reader);
            }
        } catch (IOException | NoSuchElementException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void runNavigation() {
        System.out.println();
        System.out.println("if you want create student, please enter 1");
        System.out.println("if you want update student, please enter 2");
        System.out.println("if you want delete student, please enter 3");
        System.out.println("if you want findById student, please enter 4");
        System.out.println("if you want findAll students, please enter 5");
        System.out.println("if you want deleteCourse student, please enter 6");
        System.out.println("if you want exit from StudentController, please enter 0");
        System.out.println();
    }

    private void crud(String position, BufferedReader reader) {
        switch (position) {
            case "1" -> create(reader);
            case "2" -> update(reader);
            case "3" -> delete(reader);
            case "4" -> findById(reader);
            case "5" -> findAll(reader);
            case "6" -> deleteCourse(reader);
        }
        runNavigation();
    }

    private void create(BufferedReader reader) {
        System.out.println("StudentController.create");
        try {
            Student student = new Student();
            System.out.println("Please, enter firstName");
            String firstName = reader.readLine();
            System.out.println("Please, enter lastName");
            String lastName = reader.readLine();
            student.setFirstName(firstName);
            student.setLastName(lastName);
            studentService.create(student);
            System.out.println("Id student is " + student.getId());
            System.out.println("Do you want to enroll course(s).Enter 1");
            System.out.println("if you do not - 0");
            String answer = reader.readLine();
            switch (answer) {
                case "1" -> {
                    while (true) {
                        System.out.println("ID: ");
                        String courseId = reader.readLine();
                        if (courseId == null) {
                            break;
                        }
                        studentService.addCourse(student, courseId);
                    }
                }
                default -> System.out.println("You have made a mistake");

            }
        } catch (IOException | NoSuchElementException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void update(BufferedReader reader) {
        System.out.println("StudentController.update");
        try {
            Student student = new Student();
            System.out.println("Please, enter firstName");
            String firstName = reader.readLine();
            System.out.println("Please, enter lastName");
            String lastName = reader.readLine();
            student.setFirstName(firstName);
            student.setLastName(lastName);
            studentService.update(student);
            System.out.println("Do you want to enroll course(s).Enter 1");
            System.out.println("if you do not - 0");
            String answer = reader.readLine();
            switch (answer) {
                case "1" -> {
                    while (true) {
                        System.out.println("ID: ");
                        String courseId = reader.readLine();
                        if (courseId == null) {
                            break;
                        }
                        studentService.addCourse(student, courseId);
                    }
                }
                default -> System.out.println("You have made a mistake");

            }

        } catch (IOException | NoSuchElementException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void delete(BufferedReader reader) {
        System.out.println("StudentController.delete");
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();
            studentService.delete(id);
        } catch (IOException | NoSuchElementException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findById(BufferedReader reader) {
        System.out.println("StudentController.findById");
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();
            Student student = studentService.findById(id);
            System.out.println("student = " + student);
        } catch (IOException | NoSuchElementException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findAll(BufferedReader reader) {
        System.out.println("StudentController.findAll");
        Student[] students = studentService.findAll();
        if (students != null && students.length != 0) {
            for (Student student : students) {
                if (student != null) {
                    System.out.println("student = " + student);
                }
            }
        } else {
            System.out.println("students empty");
        }
    }

    private void deleteCourse(BufferedReader reader) {
        System.out.println("DeleteCourse");
        try{
            System.out.print("ID Student: ");
            String idStudent = reader.readLine();
            Student student = studentService.findById(idStudent);
            System.out.println("Enter id of the course to delete");
            String courseId = reader.readLine();
            studentService.deleteCourse(student, courseId);
        }catch (IOException | NoSuchElementException e){
            System.out.println("problem: = " + e.getMessage());
        }
    }

}
