package ua.com.alevel.db;

import ua.com.alevel.entity.Course;
import ua.com.alevel.entity.Student;

public interface CourseDB extends BaseDB<Course> {

    Student[] addStudent(Course course, String studentId);

    Student[] deleteStudent(Course course, String studentId);
}
