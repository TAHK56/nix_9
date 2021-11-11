package ua.com.alevel.db;

import ua.com.alevel.entity.Course;
import ua.com.alevel.entity.Student;

public interface StudentDB extends BaseDB<Student> {

    Course[] addCourse(Student student, String courseId);

    Course[] deleteCourse(Student student, String courseId);

}
