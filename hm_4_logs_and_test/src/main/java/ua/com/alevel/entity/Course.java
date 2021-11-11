package ua.com.alevel.entity;

public class Course extends BaseEntity {

    private final static int SIZE = 10;

    private String nameCourse;
    private Student[] students = new Student[SIZE];
    private int countStudents;

    public Course() {
        super();
    }

    public int getCountStudents() {
        return countStudents;
    }

    public void setCountStudents(int countStudents) {
        this.countStudents = countStudents;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + getId() + '\'' +
                ", nameCourse='" + nameCourse + '\'' +
                ", countStudents=" + countStudents +
                '}';
    }
}
