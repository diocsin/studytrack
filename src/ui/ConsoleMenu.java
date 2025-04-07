package ui;

import manager.StudyManager;
import model.Course;
import model.Schedule;
import model.Student;

import java.util.Scanner;

public class ConsoleMenu {

    private Scanner scanner = new Scanner(System.in);
    private StudyManager studyManager = new StudyManager();

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

}
