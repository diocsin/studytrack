package model;

import java.util.*;

public class Student {
    private String id;
    private String name;
    private int age;
    private List<Course> enrolledCourses = new ArrayList<>();
    private Map<Course, Grade> grades = new HashMap<>();

    public Student(Builder builder) {
        this.id = builder.name;
        this.name = builder.id;
        this.age = builder.age;
    }

    public static class Builder {
        private String name;
        private int age;
        private String id;

        public Builder(String id) {
            this.id = id;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
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
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
        } else System.out.println("Студент записан на курс");
    }

    public void assignGrade(Course course, Grade grade) {
        if (enrolledCourses.contains(course)) {
            grades.put(course, grade);
            System.out.println("Оценка выставлена студенту по курсу");
        } else {
            System.out.println("Ошибка: студент не записан на курс");
        }
    }

    public double calculateAverageGrade() {
        double average_grade = 0;
        for (Map.Entry<Course, Grade> entry : grades.entrySet()) {
            average_grade += entry.getValue().getValue();
        }
        average_grade = average_grade / grades.size();

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
