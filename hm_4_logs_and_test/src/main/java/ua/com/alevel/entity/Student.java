package ua.com.alevel.entity;

public class Student extends BaseEntity {

    private final static int SIZE = 10;

    private String firstName;
    private String lastName;
    private Course[] courses = new Course[SIZE];
    private int countCourses;

    public Student() {
        super();
    }

    public int getCountCourses() {
        return countCourses;
    }

    public void setCountCourses(int countCourses) {
        this.countCourses = countCourses;
    }

    public Course[] getCourses() {
        return courses;
    }

    public void setCourses(Course[] courses) {
        this.courses = courses;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + getId() + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", countCourses=" + countCourses +
                '}';
    }
}
