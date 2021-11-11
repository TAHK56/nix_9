package ua.com.alevel.controller;

import ua.com.alevel.entity.Course;
import ua.com.alevel.service.impl.CourseServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

public class CourseController {

    private static final CourseServiceImpl courseService = new CourseServiceImpl();

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
                    return;
                }
                crud(position, reader);
            }
        } catch (IOException | NoSuchElementException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void runNavigation() {
        System.out.println();
        System.out.println("if you want create course, please enter 1");
        System.out.println("if you want update course, please enter 2");
        System.out.println("if you want delete course, please enter 3");
        System.out.println("if you want findById course, please enter 4");
        System.out.println("if you want findAll courses, please enter 5");
        System.out.println("if you want  deleteStudentInCourse, please enter 6");
        System.out.println("if you want exit, please enter 0");
        System.out.println();
    }

    private void crud(String position, BufferedReader reader) {
        switch (position) {
            case "1" -> create(reader);
            case "2" -> update(reader);
            case "3" -> delete(reader);
            case "4" -> findById(reader);
            case "5" -> findAll(reader);
            case "6" -> deleteStudent(reader);
        }
        runNavigation();
    }

    private void create(BufferedReader reader) {
        System.out.println("CourseController.create");
        try {
            Course course = new Course();
            System.out.println("Please, enter nameCourse");
            String nameCourse = reader.readLine();
            course.setNameCourse(nameCourse);
            courseService.create(course);
            System.out.println("Id course: " + course.getId());
            System.out.println("Do you want to enroll student(s).Enter 1");
            System.out.println("if you do not - 0");
            String answer = reader.readLine();
            switch (answer) {
                case "1" -> {
                    while (true) {
                        System.out.println("ID: ");
                        String studentId = reader.readLine();
                        if (studentId == null) {
                            break;
                        }
                        courseService.addStudent(course, studentId);
                    }
                }
                default -> System.out.println("You have made a mistake");

            }
        } catch (IOException | NoSuchElementException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void update(BufferedReader reader) {
        System.out.println("CourseController.update");
        try {
            System.out.println("Please, enter nameCourse");
            String nameCourse = reader.readLine();
            Course course = new Course();
            course.setNameCourse(nameCourse);
            courseService.update(course);
            System.out.println("Do you want to enroll student(s).Enter 1");
            System.out.println("if you do not - 0");
            String answer = reader.readLine();
            switch (answer) {
                case "1" -> {
                    while (true) {
                        System.out.println("ID: ");
                        String studentId = reader.readLine();
                        if (studentId == null) {
                            break;
                        }
                        courseService.addStudent(course, studentId);
                    }
                }
                default -> System.out.println("You have made a mistake");
            }
        } catch (IOException | NoSuchElementException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void delete(BufferedReader reader) {
        System.out.println("CourseController.delete");
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();
            courseService.delete(id);
        } catch (IOException | NoSuchElementException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findById(BufferedReader reader) {
        System.out.println("CourseController.findById");
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();
            Course course = courseService.findById(id);
            System.out.println("course = " + course);
        } catch (IOException | NoSuchElementException e) {
            System.out.println("problem: = " + e.getMessage());
        }

    }

    private void findAll(BufferedReader reader) {
        System.out.println("CourseController.findAll");
        Course[] courses = courseService.findAll();
        if (courses != null && courses.length != 0) {
            for (Course course : courses) {
                if (course != null) {
                    System.out.println("course = " + course);
                }
            }
        } else {
            System.out.println("courses empty");
        }
    }

    private void deleteStudent(BufferedReader reader) {
        System.out.println("DeleteStudent");
        try{
            System.out.print("ID Course: ");
            String idCourse = reader.readLine();
            Course course = courseService.findById(idCourse);
            System.out.println("Enter id of the student to delete");
            String studentId = reader.readLine();
            courseService.deleteStudent(course, studentId);
        }catch (IOException | NoSuchElementException e){
            System.out.println("problem: = " + e.getMessage());
        }
    }

}
