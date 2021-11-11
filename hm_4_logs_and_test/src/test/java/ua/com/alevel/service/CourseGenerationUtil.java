package ua.com.alevel.service;

import ua.com.alevel.entity.Course;

public class CourseGenerationUtil {

    public static final String NAME = "TEST";

    public static Course generateCourse() {
        Course course = new Course();
        course.setNameCourse(NAME);
        return course;
    }

    public static Course generateCourse(String name) {
        Course course = new Course();
        course.setNameCourse(name);
        return course;
    }

}
