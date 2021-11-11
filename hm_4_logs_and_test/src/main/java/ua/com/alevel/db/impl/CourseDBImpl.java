package ua.com.alevel.db.impl;

import ua.com.alevel.db.CourseDB;
import ua.com.alevel.entity.Course;
import ua.com.alevel.entity.Student;
import ua.com.alevel.util.GenerateIdUtil;
import java.util.Optional;

public final class CourseDBImpl implements CourseDB {

    private final static int SIZE = 10;
    private final static int MAGNIFIER_SIZE = 2;

    private static CourseDBImpl instance;
    private static int countCourses = 0;

    private Course[] courses;

    private CourseDBImpl() {
        courses = new Course[SIZE];
    }

    public static CourseDBImpl getInstance() {
        if (instance == null) {
            instance = new CourseDBImpl();
        }
        return instance;
    }

    @Override
    public void create(Course course) {
        course.setId(GenerateIdUtil.generateId(courses));
        add(course);
    }

    @Override
    public void update(Course course) {
        Course current = findById(course.getId());
        current.setNameCourse(course.getNameCourse());
        current.setStudents(course.getStudents());
    }

    @Override
    public void delete(String id) {
        boolean contains = false;
        for (Course course : courses) {
            if (course != null && course.getId().equals(id)) {
                contains = true;
            }
        }
        if (!contains) return;

        Course[] tmp = new Course[courses.length - 1];
        int count = 0;

        for (int i = 0; i < tmp.length; i++) {
            if (courses[i] != null && courses[i].getId().equals(id)) {
                count++;
                tmp[i] = courses[++i];

            }
            if (i + count == courses.length) break;
            tmp[i] = courses[i + count];
        }
        courses = tmp;
        countCourses--;

    }

    @Override
    public Course findById(String id) {
        Optional<Course> optionalCourse = Optional.empty();
        for (Course course : courses) {
            if (course != null && course.getId().equals(id)) {
                optionalCourse = Optional.of(course);
            }
        }

        return optionalCourse.orElseThrow();
    }

    @Override
    public Course[] findAll() {
        return courses;
    }

    @Override
    public Student[] addStudent(Course course, String studentId) {
        Student[] students = course.getStudents();
        if (students.length == course.getCountStudents()) {
            Student[] tmp = new Student[students.length * MAGNIFIER_SIZE];
            System.arraycopy(students, 0, tmp, 0, students.length);
            students = tmp;
        }

        Student search = StudentDBImpl.getInstance().findById(studentId);
        students[course.getCountStudents()] = search;
        search.getCourses()[search.getCountCourses()] = course;
        course.setCountStudents(course.getCountStudents() + 1);
        return course.getStudents();
    }

    @Override
    public Student[] deleteStudent(Course course, String studentId) {
        Student[] students = course.getStudents();
        if (students.length > 0) {
            for (Student student : students) {
                if (student != null && student.getId().equals(studentId)) {
                    Student[] tmp =  new Student[students.length - 1];
                    int index = student.getCountCourses();
                    System.arraycopy(students, 0, tmp, 0, index);
                    System.arraycopy(students, index + 1, tmp, index, tmp.length - index);
                    students = tmp;
                    course.setCountStudents(course.getCountStudents() - 1);
                }
            }

        }
        return students;
    }

    private void add(Course course) {
        if (courses.length  == countCourses) {
            Course[] tmp = new Course[SIZE * MAGNIFIER_SIZE];
            System.arraycopy(courses, 0, tmp, 0, courses.length);
            courses = tmp;
        }
        courses[countCourses++] = course;
    }
}

