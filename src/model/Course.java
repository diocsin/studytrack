package model;

import exception.DuplicateStudentException;
import factory.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class Course {
    private final Logger logger = LoggerFactory.createLogger("course");

    private String courseId;
    private String title;
    private int capacity;
    private Schedule schedule;
    private Set<Student> enrolledStudents = new HashSet<>();
    private Instructor instructor;

    public Course(String courseId, String title, int capacity, Schedule schedule) {
        this.courseId = courseId;
        this.title = title;
        this.capacity = capacity;
        this.schedule = schedule;
    }
    public boolean hasSpace() {
        if (enrolledStudents.size() < capacity) {
            return true;
        }
        return false;
    }

    public void enrollStudent(Student student) {
        if (enrolledStudents.contains(student)) {
            logger.log("Студент уже записан на " + title);
        }
        if (enrolledStudents.size() < capacity) {
            enrolledStudents.add(student);
        } else if (enrolledStudents.size() == capacity) {
            logger.log("Ошибка: курс " + title + " заполнен");
        }
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

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public void setEnrolledStudents(Set<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
