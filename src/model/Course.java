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


    public boolean hasSpace(){
        return false;
    }

    public void enrollStudent(Student student){

    }

    boolean conflictsWith(Schedule other){
        return true;
    }
}
