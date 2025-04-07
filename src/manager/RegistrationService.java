package manager;

import exception.CourseFullException;
import exception.DuplicateStudentException;
import exception.ScheduleConflictException;
import model.Course;
import model.Schedule;
import model.Student;

public class RegistrationService {

    public void registerStudentToCourse(Student student, Course course) throws DuplicateStudentException,
            CourseFullException, ScheduleConflictException {
        if (course.getEnrolledStudents().contains(student)) {
            throw new DuplicateStudentException("Студент " + student.getName() + " уже записан на курс ( " + course.getTitle() + " )");
        }
        if (!course.hasSpace()) {
            throw new CourseFullException("Ошибка: курс " + course.getTitle() + " заполнен");
        }
        for (Course enrolledCours : student.getEnrolledCourses()) {
            if (enrolledCours.getSchedule().conflictsWith(course.getSchedule())){
                throw  new ScheduleConflictException("Ошибка: конфликт расписания у студента: " + student.getName() + " с курсом "+ course.getTitle());
            } else {
                course.enrollStudent(student);
                student.enroll(course);
            }
        }
        //Если расписание курса конфликтует с другими курсами студента (использовать schedule.conflictsWith): → Вывести: "Ошибка: конфликт расписания у студента (name) с курсом (title)" → Бросить ScheduleConflictException
        //Иначе: → Вызвать course.enrollStudent(student) → Вызвать student.enroll(course)
    }


}
