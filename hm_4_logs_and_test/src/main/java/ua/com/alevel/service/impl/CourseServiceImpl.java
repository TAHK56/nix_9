package ua.com.alevel.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.dao.impl.CourseDaoImpl;
import ua.com.alevel.entity.Course;
import ua.com.alevel.entity.Student;
import ua.com.alevel.service.CourseService;

import java.util.NoSuchElementException;

public class CourseServiceImpl implements CourseService {

    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    private final CourseDaoImpl courseDao = new CourseDaoImpl();

    @Override
    public void create(Course course) {
        courseDao.create(course);
        LOGGER_INFO.info("course finish created");
    }

    @Override
    public void update(Course course) {
        courseDao.update(course);
    }

    @Override
    public void delete(String id) {
        LOGGER_WARN.warn("course start deleted");
        courseDao.delete(id);
        LOGGER_WARN.warn("course finish deleted");
    }

    @Override
    public Course findById(String id) {
        try {
            return courseDao.findById(id);
        } catch (NoSuchElementException e) {
            LOGGER_ERROR.error("course not found by id: " + id);
        }
        return null;
    }

    @Override
    public Course[] findAll() {
        return courseDao.findAll();
    }

    @Override
    public Student[] addStudent(Course course, String studentId) {
        return courseDao.addStudent(course, studentId);
    }

    @Override
    public Student[] deleteStudent(Course course, String studentId) {
        return courseDao.deleteStudent(course, studentId);
    }
}
