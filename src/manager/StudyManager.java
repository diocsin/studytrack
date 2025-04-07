package manager;

import exception.CourseFullException;
import exception.DuplicateStudentException;
import exception.ScheduleConflictException;
import model.Course;
import model.Grade;
import model.Instructor;
import model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudyManager {

    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();
    private List<Instructor> instructors = new ArrayList<>();

    public void registerStudent(Student student) {
        if (students.contains(student)) {
            System.out.println("Студент " + student.getName()
                    + " зарегистрирован в системе");
        } else students.add(student);
    }

    public void createCourse(Course course) {
        if (courses.contains(course)) {
            System.out.println("Курс " + course.getTitle() + " создан");
        } else courses.add(course);
    }

    public void assignInstructor(Course course, Instructor instructor) {
        instructor.assignCourse(course);
        course.setInstructor(instructor);
        instructors.add(instructor);
        System.out.println("Преподаватель " + instructor.getName()
                + " назначен на курс " + course.getTitle());
    }

    public void enroll(Student student, Course course) {
        try {
            RegistrationService.registerStudentToCourse(student, course);
        } catch (DuplicateStudentException | ScheduleConflictException | CourseFullException e) {
            System.out.println(e.getMessage());
        }
    }

    public void assignGrade(Student student, Course course, Grade grade) {
        student.assignGrade(course, grade);
        System.out.println("Оценка " + grade
                + " назначена студенту " + student.getName()
                + " за курс " + course.getTitle());
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }
}
