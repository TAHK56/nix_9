package ua.com.alevel.service;

import org.junit.jupiter.api.*;
import ua.com.alevel.entity.Course;
import ua.com.alevel.entity.Student;
import ua.com.alevel.service.impl.CourseServiceImpl;
import ua.com.alevel.service.impl.StudentServiceImpl;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CourseServiceImplTest {

    private final static CourseServiceImpl courseServiceImpl = new CourseServiceImpl();
    private final static StudentServiceImpl studentServiceImpl = new StudentServiceImpl();
    private final static int COURSES_SIZE = 10;
    private final static int MAGNIFIER_SIZE = 2;

    @BeforeAll
    public static void setUp() {
        for (int i = 0; i < COURSES_SIZE; i++) {
            Course course = CourseGenerationUtil.generateCourse(CourseGenerationUtil.NAME + i);
            courseServiceImpl.create(course);

        }
        Assertions.assertEquals(COURSES_SIZE, courseServiceImpl.findAll().length);
    }

    @Order(1)
    @Test
    public void shouldBeCreateCourseWhenNameIsEmpty() {
        Course course = new Course();
        course.setNameCourse(null);
        courseServiceImpl.create(course);

        verifyCourseArrayWhenCoursesArrayIsNotEmpty(COURSES_SIZE * MAGNIFIER_SIZE);

    }

    @Order(2)
    @Test
    public void shouldBeDeleteCourse() {
        String id = getRandomIdFromCourseArray();
        courseServiceImpl.delete(id);
        verifyCourseArrayWhenCoursesArrayIsNotEmpty(courseServiceImpl.findAll().length);
    }

    @Order(3)
    @Test
    public void shouldBeUpdateCourse() {
        String id = getRandomIdFromCourseArray();
        Course course = getRandomCourseFromCourseArray(id);
        course.setNameCourse("Update");
        courseServiceImpl.update(course);

        course = courseServiceImpl.findById(id);

        Assertions.assertEquals("Update", course.getNameCourse());
    }

    @Order(4)
    @Test
    public void shouldBeFindCourseWhenIdIsRandom() {
        Course course = getRandomCourseFromCourseArray(getRandomIdFromCourseArray());

        Assertions.assertNotNull(course);
    }

    @Order(5)
    @Test
    public void shouldBeAddStudentsWhenStudentArrayIsEmpty() {
        Student[] students = studentServiceImpl.findAll();
        Course[] courses = courseServiceImpl.findAll();
        courses[0].setStudents(students);

        Assertions.assertEquals(courses[0].getStudents().length, students.length);

    }


    private void verifyCourseArrayWhenCoursesArrayIsNotEmpty(int size) {
        Course[] courses = courseServiceImpl.findAll();
        Assertions.assertTrue(courses.length != 0);
        Assertions.assertEquals(size, courseServiceImpl.findAll().length);
    }

    private String getRandomIdFromCourseArray() {
        int random = (int) (Math.random() * COURSES_SIZE);
        Course[] courses = courseServiceImpl.findAll();
        return courses[random].getId();
    }

    private Course getRandomCourseFromCourseArray(String id) {
        return courseServiceImpl.findById(id);
    }
}
