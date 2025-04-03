package model;

import exception.DuplicateStudentException;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Course {

    private String courseId;
    private String title;
    private int capacity;
    private Schedule schedule;
    private Set<Student> enrolledStudents = new HashSet<>();
    private Instructor instructor;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(courseId, course.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(courseId);
    }

    public boolean hasSpace() {
        if (enrolledStudents.size() < capacity) {
            return true;
        }
        return false;
    }

    public void enrollStudent(Student student) {
        if (enrolledStudents.contains(student)) {
            System.out.println(" Студент уже зачислен на курс " + getTitle());
        }

        if (enrolledStudents.size() <= capacity) {
            enrolledStudents.add(student);
            System.out.println(" Студент зачислен на курс " + getTitle());
        } else {
            System.out.println("Ошибка: курс " + title + " заполнен");
        }
    }
}
