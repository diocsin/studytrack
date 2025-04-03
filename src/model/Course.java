package model;

import exception.DuplicateStudentException;

import java.util.HashSet;
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

    public boolean hasSpace(){
        if (enrolledStudents.size()<capacity){
            return true;
        }
        return false;
    }

    public void enrollStudent(Student student)throws DuplicateStudentException {



    }

    boolean conflictsWith(Schedule other){
        return true;
    }
}
