package ua.com.alevel.dao.impl;

import ua.com.alevel.dao.CourseDao;
import ua.com.alevel.db.impl.CourseDBImpl;
import ua.com.alevel.entity.Course;
import ua.com.alevel.entity.Student;

public class CourseDaoImpl implements CourseDao {

    private final CourseDBImpl instance = CourseDBImpl.getInstance();

    @Override
    public void create(Course course) {
        instance.create(course);
    }

    @Override
    public void update(Course course) {
        instance.update(course);
    }

    @Override
    public void delete(String id) {
        instance.delete(id);
    }

    @Override
    public Course findById(String id) {
        return instance.findById(id);
    }

    @Override
    public Course[] findAll() {
        return instance.findAll();
    }

    @Override
    public Student[] addStudent(Course course, String studentId) {
        return CourseDBImpl.getInstance().addStudent(course, studentId);
    }

    @Override
    public Student[] deleteStudent(Course course, String studentId) {
        return CourseDBImpl.getInstance().deleteStudent(course, studentId);
    }
}
