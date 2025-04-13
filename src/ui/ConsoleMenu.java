package ui;

import manager.StatisticsService;
import manager.StudyManager;
import model.*;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ConsoleMenu {

    private final Scanner scanner = new Scanner(System.in);
    private final StudyManager studyManager = StudyManager.getInstance();
    private final StatisticsService statisticsService = StatisticsService.getInstance();

    public void start() {
        while (true) {
            mainMenu();
            System.out.print("Выберите действие: ");
            int choose = scanner.nextInt();

            switch (choose) {
                case 1:
                    addStudentMenu();
                    break;
                case 2:
                    addCourseMenu();
                    break;
                case 3:
                    setInstructorMenu();
                    break;
                case 4:
                    setStudentMenu();
                    break;
                case 5:
                    setStudentGradeMenu();
                    break;
                case 6:
                    showCourseStatisticMenu();
                    break;
                case 7:
                    showAllStudentsMenu();
                    break;
                case 8:
                    showAllInstructorsMenu();
                    break;
                case 9:
                    showAllCourseWMenu();
                    break;
                case 10:
                    return;
            }
        }
    }

    private void mainMenu() {
        System.out.println("==== Учебный центр ====");
        System.out.println("1. Добавить студента");
        System.out.println("2. Добавить курс");
        System.out.println("3. Назначить преподавателя");
        System.out.println("4. Записать студента на курс");
        System.out.println("5. Назначить оценку");
        System.out.println("6. Показать статистику по курсу");
        System.out.println("7. Показать всех студентов, их курсы и оценки");
        System.out.println("8. Показать всех преподавателей и их курсы");
        System.out.println("9. Показать все курсы с расписанием");
        System.out.println("10. Выход");
    }

    public void addStudentMenu() {
        String id;
        String name;
        int age;

        System.out.print("Имя студента: ");
        name = scanner.next();
        System.out.print("Возраст: ");
        age = scanner.nextInt();
        System.out.print("ID: ");
        id = scanner.next();

        Student student = new Student.Builder(id)
                .name(name)
                .age(age)
                .build();

        studyManager.registerStudent(student);
        System.out.println("Студент " + name + " зарегистрирован в системе");
    }

    public void addCourseMenu() {
        String id;
        String title;
        String dayOfWeek;
        String time;
        String room;
        Schedule schedule;
        int capacity;

        System.out.print("Название курса: ");
        title = scanner.next();
        System.out.print("ID курса: ");
        id = scanner.next();
        System.out.print("Вместимость: ");
        capacity = scanner.nextInt();
        System.out.print("День недели: ");
        dayOfWeek = scanner.next();
        System.out.print("Время: ");
        time = scanner.next();
        System.out.print("Аудитория: ");
        room = scanner.next();

        schedule = new Schedule(dayOfWeek, time, room);

        Course course = new Course(id, title, capacity, schedule);
        studyManager.createCourse(course);
        System.out.println("Курс " + title + " создан");
    }

    public void setInstructorMenu() {
        String name;
        String id;
        String courseId;
        Instructor instructor = null;
        Course course = null;

        System.out.print("Имя преподавателя: ");
        name = scanner.next();
        System.out.print("ID преподавателя: ");
        id = scanner.next();
        System.out.print("ID курса для назначения: ");
        courseId = scanner.next();

        for (Course c : studyManager.getCourses()) {
            if (c.getCourseId().equals(courseId)) {
                course = c;
            }
        }

        for (Instructor i : studyManager.getInstructors()) {
            if (i.getId().equals(id) && i.getName().equals(name)) {
                instructor = i;
            }
        }

        studyManager.assignInstructor(course, instructor);
    }

    public void setStudentMenu() {
        String id;
        String courseId;
        Student student = null;
        Course course = null;

        System.out.print("ID студента: ");
        id = scanner.next();
        System.out.print("ID курса: ");
        courseId = scanner.next();

        for (Student s : studyManager.getStudents()) {
            if (s.getId().equals(id)) {
                student = s;
            }
        }

        for (Course c : studyManager.getCourses()) {
            if (c.getCourseId().equals(courseId)) {
                course = c;
            }
        }

        studyManager.enroll(student, course);
    }

    public void setStudentGradeMenu() {
        String id;
        String courseId;
        Student student = null;
        Course course = null;
        Grade grade;
        String strGrade;

        System.out.print("ID студента: ");
        id = scanner.next();
        System.out.print("ID курса: ");
        courseId = scanner.next();
        System.out.print("Оценка (A, B, C, D, F): ");
        strGrade = scanner.next();

        for (Student s : studyManager.getStudents()) {
            if (s.getId().equals(id)) {
                student = s;
            }
        }

        for (Course c : studyManager.getCourses()) {
            if (c.getCourseId().equals(courseId)) {
                course = c;
            }
        }


        try {
            grade = Grade.valueOf(strGrade);
        } catch (IllegalArgumentException e) {
            System.out.println("Такой оценки не существует");
            return;
        }

        studyManager.assignGrade(student, course, grade);
    }

    public void showCourseStatisticMenu() {
        String courseId;
        Course course = null;

        System.out.println("ID курса: ");
        courseId = scanner.next();

        for (Course c : studyManager.getCourses()) {
            if (c.getCourseId().equals(courseId)) {
                course = c;
            }
        }

        System.out.println(statisticsService.getAverageForCourse(course));
        Map<Grade, Integer> countByGrade = statisticsService.getCountByGrade(course);

        for (Map.Entry<Grade, Integer> entry : countByGrade.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public void showAllStudentsMenu() {
        List<Student> students = studyManager.getStudents();

        for (Student student : students) {
            System.out.println("Студент: " + student.getName());

            Map<Course, Grade> grades = student.getGrades();

            for (Map.Entry<Course, Grade> entry : grades.entrySet()) {
                System.out.println("  Курс: " + entry.getKey().getTitle() + " | Оценка: " + entry.getValue());
            }
        }
    }

    public void showAllInstructorsMenu() {
        List<Instructor> instructors = studyManager.getInstructors();

        for (Instructor instructor : instructors) {
            System.out.println("Преподаватель: " + instructor.getName());

            List<Course> courses = instructor.getCourses();

            for (Course c : courses) {
                System.out.println("  Введёт курс: " + c.getTitle());
            }
        }
    }

    public void showAllCourseWMenu() {
        List<Course> courses = studyManager.getCourses();

        for (Course c : courses) {
            Schedule schedule = c.getSchedule();
            System.out.println("Курс: " + c.getTitle() + " | ID: " + c.getCourseId() + " | Вместимость: " + c.getCapacity() + " День: " + schedule.getDayOfWeek() + " | Время: " + schedule.getTime() + " | Аудитория: " + schedule.getRoom());
        }
    }

}
