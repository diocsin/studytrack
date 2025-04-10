package manager;

import exception.CourseFullException;
import exception.DuplicateStudentException;
import exception.ScheduleConflictException;
import factory.LoggerFactory;
import model.*;

import java.util.ArrayList;
import java.util.List;

public class StudyManager {
    private final Logger logger = LoggerFactory.createLogger("studyManager");

    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();
    private List<Instructor> instructors = new ArrayList<>();

    private RegistrationService registrationService;

    public void registerStudent(Student student) {
        if (students.contains(student)) {
            logger.log("Студент уже" + student.getName()
                    + " зарегистрирован в системе");
        } else students.add(student);
        logger.log("Студент " + student.getName()
                + " зарегистрирован в системе");
    }

    public void createCourse(Course course) {
        if (courses.contains(course)) {
            logger.log("Курс уже" + course.getTitle() + " создан");
        } else courses.add(course);
        logger.log("Курс " + course.getTitle() + " создан");
    }

    public void assignInstructor(Course course, Instructor instructor) {
        instructor.assignCourse(course);
        course.setInstructor(instructor);
        instructors.add(instructor);
        logger.log("Преподаватель " + instructor.getName()
                + " назначен на курс " + course.getTitle());
    }

    public void enroll(Student student, Course course) {
        try {
            registrationService.registerStudentToCourse(student, course);
        } catch (DuplicateStudentException | ScheduleConflictException | CourseFullException e) {
            logger.log(e.getMessage());
        }
    }

    public void assignGrade(Student student, Course course, Grade grade) {
        student.assignGrade(course, grade);
        logger.log("Оценка " + grade
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
