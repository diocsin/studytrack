package service;

import exception.CourseFullException;
import exception.ScheduleConflictException;
import model.Course;
import model.Student;

public class RegistrationService {

    void registerStudentToCourse(Student student, Course course) throws ScheduleConflictException, CourseFullException {
        if (student.getEnrolledCourses().contains(course)) {
            throw new ScheduleConflictException("Студент уже записан на курс");
        }
        if (!course.hasSpace()) {
            throw new CourseFullException("Ошибка: курс " + course.getTitle() + " заполнен");
        }
        if ()
    }
}
