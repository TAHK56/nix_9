package ua.com.alevel.service;

import ua.com.alevel.entity.Student;

public class StudentGenerationUtil {

    public static final String  FIRST_NAME = "JOHN";
    public static final String LAST_NAME = "SMITH";

    public static Student generateStudent() {
        Student student = new Student();
        student.setFirstName(FIRST_NAME);
        student.setLastName(LAST_NAME);
        return student;
    }

    public static Student generateStudent(String firstName, String lastName) {
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        return student;
    }

}
