package ua.com.alevel.service;

import ua.com.alevel.entity.Course;
import ua.com.alevel.entity.Student;

public interface CourseService extends BaseService<Course> {

    Student[] addStudent(Course course, String studentId);

    Student[] deleteStudent(Course course, String studentId);
}
