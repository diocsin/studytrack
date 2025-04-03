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
        } else System.out.println("Студент записан на курс");
    }

    public void assignGrade(Course course, Grade grade) {
        if(enrolledCourses.contains(course)){
            grades.put(course,grade);
            System.out.println("Оценка выставлена студенту по курсу");
        } else {
            System.out.println("Ошибка: студент не записан на курс");
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

}
