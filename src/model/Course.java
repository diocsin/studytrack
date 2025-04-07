package model;

import java.util.HashSet;
import java.util.Set;

public class Course {

    private String courseId;
    private String title;
    private int capacity;
    private Schedule schedule;
    private Set<Student> enrolledStudents = new HashSet<>();
    private Instructor instructor;

    public Course(String courseId, String title, int capacity) {
        this.courseId = courseId;
        this.title = title;
        this.capacity = capacity;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getTitle() {
        return title;
    }

    public int getCapacity() {
        return capacity;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public Set<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public boolean hasSpace() {
        if (enrolledStudents.size() < capacity) {
            return true;
        }
        return false;
    }

    public void enrollStudent(Student student) {
        if (enrolledStudents.contains(student)) {
            System.out.println("Студент уже записан на " + title);
        }
        if (enrolledStudents.size() < capacity) {
            enrolledStudents.add(student);
        } else if (enrolledStudents.size() == capacity) {
            System.out.println("Ошибка: курс " + title + " заполнен");
        }
    }
}
