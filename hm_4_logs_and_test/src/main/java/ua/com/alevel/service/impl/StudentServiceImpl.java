package ua.com.alevel.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.dao.impl.StudentDaoImpl;
import ua.com.alevel.entity.Course;
import ua.com.alevel.entity.Student;
import ua.com.alevel.service.StudentService;

public class StudentServiceImpl implements StudentService {

    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    private final StudentDaoImpl  studentDao = new StudentDaoImpl();

    @Override
    public void create(Student student) {
        studentDao.create(student);
        LOGGER_INFO.info("student finish created");
    }

    @Override
    public void update(Student student) {
        studentDao.update(student);
    }

    @Override
    public void delete(String id) {
        LOGGER_WARN.warn("student start deleted");
        studentDao.delete(id);
        LOGGER_WARN.warn("student finish deleted");
    }

    @Override
    public Student findById(String id) {
        try {
            return studentDao.findById(id);
        } catch (Exception e) {
            LOGGER_ERROR.error("student not found by id: " + id);
        }
        return null;
    }

    @Override
    public Student[] findAll() {
        return studentDao.findAll();
    }

    @Override
    public Course[] addCourse(Student student, String courseId) {
        return studentDao.addCourse(student, courseId);
    }

    @Override
    public Course[] deleteCourse(Student student, String courseId) {
        return studentDao.deleteCourse(student, courseId);
    }
}
