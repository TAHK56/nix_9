package ua.com.alevel.service;

import org.junit.jupiter.api.*;
import ua.com.alevel.entity.Course;
import ua.com.alevel.entity.Student;
import ua.com.alevel.service.impl.CourseServiceImpl;
import ua.com.alevel.service.impl.StudentServiceImpl;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentServiceImplTest {

    private final static CourseServiceImpl courseServiceImpl = new CourseServiceImpl();
    private final static StudentServiceImpl studentServiceImpl = new StudentServiceImpl();
    private final static int STUDENT_SIZE = 10;
    private final static int MAGNIFIER_SIZE = 2;

    @BeforeAll
    public static void setUp() {
        for (int i = 0; i < STUDENT_SIZE; i++) {
            Student student = StudentGenerationUtil.generateStudent(StudentGenerationUtil.FIRST_NAME + i, StudentGenerationUtil.LAST_NAME + i);
            studentServiceImpl.create(student);

        }
        Assertions.assertEquals(STUDENT_SIZE, studentServiceImpl.findAll().length);
    }

    @Order(1)
    @Test
    public void shouldBeCreateStudentWhenNameIsEmpty() {
        Student student = new Student();
        student.setFirstName(null);
        student.setLastName(null);
        studentServiceImpl.create(student);

        verifyStudentArrayWhenStudentsArrayIsNotEmpty(STUDENT_SIZE * MAGNIFIER_SIZE);

    }

    @Order(2)
    @Test
    public void shouldBeDeleteStudent() {
        String id = getRandomIdFromStudentArray();
        studentServiceImpl.delete(id);

        verifyStudentArrayWhenStudentsArrayIsNotEmpty(studentServiceImpl.findAll().length);
    }

    @Order(3)
    @Test
    public void shouldBeUpdateStudent() {
        String id = getRandomIdFromStudentArray();
        Student student = getRandomStudentFromStudentArray(id);
        student.setFirstName("Hugo");
        student.setLastName("Boss");
        studentServiceImpl.update(student);

        student = studentServiceImpl.findById(id);

        Assertions.assertEquals("Hugo", student.getFirstName());
        Assertions.assertEquals("Boss", student.getLastName());
    }

    @Order(4)
    @Test
    public void shouldBeFindStudentWhenIdIsRandom() {
        Student student = getRandomStudentFromStudentArray(getRandomIdFromStudentArray());

        Assertions.assertNotNull(student);
    }

    @Order(5)
    @Test
    public void shouldBeAddCoursesWhenCoursesArrayIsEmpty() {
        Student[] students = studentServiceImpl.findAll();
        Course[] courses = courseServiceImpl.findAll();
        students[0].setCourses(courses);

        Assertions.assertEquals(students[0].getCourses().length, courses.length);

    }

    private void verifyStudentArrayWhenStudentsArrayIsNotEmpty(int size) {
        Student[] students = studentServiceImpl.findAll();
        Assertions.assertTrue(students.length != 0);
        Assertions.assertEquals(size, studentServiceImpl.findAll().length);
    }

    private String getRandomIdFromStudentArray() {
        int random = (int) (Math.random() * STUDENT_SIZE);
        Student[] students = studentServiceImpl.findAll();
        return students[random].getId();
    }

    private Student getRandomStudentFromStudentArray(String id) {
        return studentServiceImpl.findById(id);
    }
}
