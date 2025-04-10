package manager;

import exception.CourseFullException;
import exception.DuplicateStudentException;
import exception.ScheduleConflictException;
import model.Course;
import model.Student;

public class RegistrationService {
    private static RegistrationService instance;

    private RegistrationService() {
    }

    private void registerStudentToCourse(Student student, Course course) throws DuplicateStudentException,
            CourseFullException, ScheduleConflictException {
        if (course.getEnrolledStudents().contains(student)) {
            throw new DuplicateStudentException("Студент " + student.getName() + " уже записан на курс ( " + course.getTitle() + " )");
        }
        if (!course.hasSpace()) {
            throw new CourseFullException("Ошибка: курс " + course.getTitle() + " заполнен");
        }
        for (Course enrolledCourses : student.getEnrolledCourses()) {
            if (enrolledCourses.getSchedule().conflictsWith(course.getSchedule())) {
                throw new ScheduleConflictException("Ошибка: конфликт расписания у студента: " + student.getName() + " с курсом " + course.getTitle());
            }
        }
        course.enrollStudent(student);
        student.enroll(course);
    }

    public static RegistrationService getInstance(){
        if(instance == null){
            instance = new RegistrationService();
        }
        return instance;
    }


}
