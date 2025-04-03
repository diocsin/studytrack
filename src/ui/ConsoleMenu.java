package ui;

import java.util.Scanner;

public class ConsoleMenu {

    private Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            mainMenu();
            System.out.print("Выберите действие: ");
            int choose = scanner.nextInt();

            switch (choose) {
                case 1:
                    break;
                case 2:
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

}
