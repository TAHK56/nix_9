package ua.com.alevel.db.impl;

import ua.com.alevel.db.StudentDB;
import ua.com.alevel.entity.Course;
import ua.com.alevel.entity.Student;
import ua.com.alevel.util.GenerateIdUtil;
import java.util.Optional;

public class StudentDBImpl implements StudentDB {

    private final static int SIZE = 10;
    private final static int MAGNIFIER_SIZE = 2;

    private static StudentDBImpl instance;
    private static int countStudents = 0;

    private Student[] students;

    private StudentDBImpl() {
        students = new Student[SIZE];
    }

    public static StudentDBImpl getInstance() {
        if (instance == null) {
            instance = new StudentDBImpl();
        }
        return instance;
    }

    @Override
    public void create(Student student) {
        student.setId(GenerateIdUtil.generateId(students));
        add(student);
    }

    @Override
    public void update(Student student) {
        Student current = findById(student.getId());
        current.setFirstName(student.getFirstName());
        current.setLastName(student.getLastName());
        current.setCourses(student.getCourses());
    }

    @Override
    public void delete(String id) {
        boolean contains = false;
        for (Student student : students) {
            if (student != null && student.getId().equals(id)) {
                contains = true;
            }
        }
        if (!contains) return;

        Student[] tmp = new Student[students.length - 1];
        int count = 0;

        for (int i = 0; i < tmp.length; i++) {
            if (students[i] != null && students[i].getId().equals(id)) {
                count++;
                tmp[i] = students[++i];

            }
            if (i + count == students.length) break;
            tmp[i] = students[i + count];
        }
        students = tmp;
        countStudents--;

    }

    @Override
    public Student findById(String id) {
        Optional<Student> optionalStudent = Optional.empty();
        for (Student student : students) {
            if (student != null && student.getId().equals(id)) {
                optionalStudent = Optional.of(student);
            }
        }

        return optionalStudent.orElseThrow();
    }

    @Override
    public Student[] findAll() {
        return students;
    }

    @Override
    public Course[] addCourse(Student student, String courseId) {
        Course[] courses = student.getCourses();
        if (courses.length == student.getCountCourses()) {
            Course[] tmp = new Course[courses.length * MAGNIFIER_SIZE];
            System.arraycopy(courses, 0, tmp, 0, courses.length);
           courses = tmp;
        }
        Course search = CourseDBImpl.getInstance().findById(courseId);
        courses[student.getCountCourses()] = search;
        search.getStudents()[search.getCountStudents()] = student;
        student.setCountCourses(student.getCountCourses() + 1);
        return student.getCourses();
    }

    @Override
    public Course[] deleteCourse(Student student, String courseId) {
        Course[] courses = student.getCourses();
        if (courses.length > 0) {
            for (Course course : courses) {
                if (course != null && course.getId().equals(courseId)) {
                    Course[] tmp =  new Course[courses.length - 1];
                    int index = course.getCountStudents();
                    System.arraycopy(courses, 0, tmp, 0, index);
                    System.arraycopy(courses, index + 1, tmp, index, tmp.length - index);
                    courses = tmp;
                    student.setCountCourses(student.getCountCourses() - 1);
                }
            }

        }
        return courses;
    }


    private void add(Student student) {
        if (students.length <= countStudents) {
            Student[] tmp = new Student[SIZE * MAGNIFIER_SIZE];
            System.arraycopy(students, 0, tmp, 0, students.length);
            students = tmp;
        }
        students[countStudents++] = student;
    }

}
