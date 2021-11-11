package ua.com.alevel.dao;

import ua.com.alevel.entity.Course;
import ua.com.alevel.entity.Student;

public interface CourseDao extends BaseDao<Course> {

    Student[] addStudent(Course course, String studentId);

    Student[] deleteStudent(Course course, String studentId);
}
