package service;

import exception.DuplicateStudentException;
import model.Course;
import model.Grade;
import model.Instructor;
import model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudyManager {

    List<Student> students = new ArrayList<>();
    List<Course> courses = new ArrayList<>();

    public void registerStudent(Student student) throws DuplicateStudentException {
        if (!students.contains(student)) {
            students.add(student);
            System.out.println("Студент " + student.getName() + " зарегистрирован в системе");
        } else {
            throw new DuplicateStudentException(
                    "студент с таким ID уже есть в системе" + student.getId()
            );
        }
    }

    public void createCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            System.out.println("Курс " + course.getTitle() + " создан");
        }
    }

    // toDo доделать
    public void assignInstructor(Course course, Instructor instructor) {
        instructor.assignCourse(course);
        course.setInstructor(instructor);
        System.out.println("Преподаватель " + instructor.getName() + " назначен на курс " + course.getTitle());
    }

    public void enroll(Student student, Course course) {
    }

    // toDo доделать
    public void assignGrade(Student student, Course course, Grade grade) {
        student.assignGrade(course, grade);
        System.out.println("Оценка " + grade
                + " назначена студенту " + student.getName()
                + " за курс " + course.getTitle());
    }
}
