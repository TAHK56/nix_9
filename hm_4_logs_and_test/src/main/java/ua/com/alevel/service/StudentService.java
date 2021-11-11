package ua.com.alevel.service;

import ua.com.alevel.entity.Course;
import ua.com.alevel.entity.Student;

public interface StudentService extends BaseService<Student> {

    Course[] addCourse(Student student, String courseId);

    Course[] deleteCourse(Student student, String courseId);
}
