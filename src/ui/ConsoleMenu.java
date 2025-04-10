package ui;

import manager.StudyManager;
import model.Course;
import model.Instructor;
import model.Schedule;
import model.Student;

import java.util.Scanner;

public class ConsoleMenu {

    private final Scanner scanner = new Scanner(System.in);
    private final StudyManager studyManager = new StudyManager();

    public void start() {
        while (true) {
            Student student;
            Course course;

            mainMenu();
            System.out.print("Выберите действие: ");
            int choose = scanner.nextInt();

            switch (choose) {
                case 1:
                    student = addStudentMenu();
                    studyManager.registerStudent(student);
                    break;
                case 2:
                    course = addCourseMenu();
                    studyManager.createCourse(course);
                    break;
                case 3:
                    setInstructorMenu();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
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
        System.out.println("8. Показать всех преподователей и их курсы");
        System.out.println("9. Показать все курсы с расписанием");
        System.out.println("10. Выход");
    }

    public Student addStudentMenu() {
        String id;
        String name;
        int age;

        System.out.print("Имя студента: ");
        name = scanner.next();
        System.out.println("Возраст: ");
        age = scanner.nextInt();
        System.out.println("ID: ");
        id = scanner.next();

        return new Student(id, name, age);
    }

    public Course addCourseMenu() {
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

        return new Course(id, title, capacity, schedule);
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

        if (course == null) {
            System.out.println("Курс с таким ID не найден");
            return;
        }

        if (instructor == null) {
            System.out.println("Преподаватель с таким ID или именем не найден");
            return;
        }

        studyManager.assignInstructor(course, instructor);
    }

    public void setStudentMenu() {
        String id;
        String courseId;
        Student student = null;
        Course course = null;

        System.out.println("ID студента: ");
        id = scanner.next();
        System.out.println("ID курса: ");
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

}
