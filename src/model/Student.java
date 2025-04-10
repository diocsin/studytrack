package model;
import factory.LoggerFactory;

import java.util.*;

public class Student {
    private final Logger logger = LoggerFactory.createLogger("student");
    private String id;
    private String name;
    private int age;
    private List<Course> enrolledCourses = new ArrayList<>();
    private Map<Course, Grade> grades = new HashMap<>();

    public Student(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

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

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void enroll(Course course) {
        if(!enrolledCourses.contains(course)){
            enrolledCourses.add(course);
        } else
            logger.log("Студент записан на курс");
    }

    public void assignGrade(Course course, Grade grade) {
        if(enrolledCourses.contains(course)){
            grades.put(course,grade);
            logger.log("Оценка выставлена студенту по курсу");
        } else {
            logger.log("Ошибка: студент не записан на курс");
        }
    }

    public double calculateAverageGrade() {
        double average_grade = 0 ;
        for(Map.Entry<Course,Grade> entry: grades.entrySet()){
            average_grade += entry.getValue().getValue();
        }
        average_grade = average_grade/grades.size();

        return average_grade;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
