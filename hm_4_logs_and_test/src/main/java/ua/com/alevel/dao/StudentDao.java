package ua.com.alevel.dao;

import ua.com.alevel.entity.Course;
import ua.com.alevel.entity.Student;

public interface StudentDao extends BaseDao<Student> {

    Course[] addCourse(Student student, String courseId);

    Course[] deleteCourse(Student student, String courseId);

}
