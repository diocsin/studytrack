package model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
    private String id;
    private String name;
    private int age;
    private List<Course> enrolledCourses = new ArrayList<>();
    private Map<Course, Grade> grades = new HashMap<>();

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public Map<Course, Grade> getGrades() {
        return grades;
    }

    public void setGrades(Map<Course, Grade> grades) {
        this.grades = grades;
    }

    public void enroll(Course course) {

    }

    public void assignGrade(Course course, Grade grade) {

    }

    public double calculateAverageGrade() {
        return 0.0;
    }

}
