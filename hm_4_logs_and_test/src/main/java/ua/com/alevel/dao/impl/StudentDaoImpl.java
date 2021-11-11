package ua.com.alevel.dao.impl;

import ua.com.alevel.dao.StudentDao;
import ua.com.alevel.db.impl.StudentDBImpl;
import ua.com.alevel.entity.Course;
import ua.com.alevel.entity.Student;

public class StudentDaoImpl implements StudentDao {

    private final StudentDBImpl instance = StudentDBImpl.getInstance();

    @Override
    public void create(Student student) {
        instance.create(student);
    }

    @Override
    public void update(Student student) {
        instance.update(student);
    }

    @Override
    public void delete(String id) {
        instance.delete(id);
    }

    @Override
    public Student findById(String id) {
        return instance.findById(id);
    }

    @Override
    public Student[] findAll() {
        return instance.findAll();
    }

    @Override
    public Course[] addCourse(Student student, String courseId) {
        return StudentDBImpl.getInstance().addCourse(student, courseId);
    }

    @Override
    public Course[] deleteCourse(Student student, String courseId) {
        return StudentDBImpl.getInstance().deleteCourse(student, courseId);
    }
}
