# 🎓 Система управления учебным процессом "StudyTrack"
💡 Что это?
"StudyTrack" — это симуляция реальной системы учебного центра, в которой управляют студентами, курсами, расписанием, преподавателями и оценками.

Проект создан для того, чтобы участники почувствовали себя настоящими разработчиками командного проекта, освоили ключевые принципы ООП, работу с коллекциями, исключениями и архитектурой приложений.

## 🎯 Цели проекта:
* Применить объектно-ориентированное программирование в реальной задаче
* Разделить проект на роли и зоны ответственности между разработчиками
* Изучить работу с коллекциями (List, Map, Set)
* Научиться обрабатывать исключения
* Освоить архитектурный подход: модель → сервис → менеджер → консольное меню
* Практиковать работу с Git и Pull Request'ами в командной среде

## 🧱 Основные сущности:
- Компонент	Назначение
- Student	Студент, записывающийся на курсы и получающий оценки
- Course	Учебный курс с расписанием и вместимостью
- Instructor	Преподаватель, ведущий один или несколько курсов
- Schedule	Расписание курса (день недели, время, аудитория)
- Grade	Перечисление оценок (A–F), каждая с числовым значением
- RegistrationService	Логика регистрации на курсы с проверками
- StatisticsService	Аналитика по успеваемости
- StudyManager	Централизованный координатор всего процесса
- ConsoleMenu	Консольный интерфейс пользователя

## 👥 Как работает проект
* Администратор добавляет курсы, студентов, преподавателей
* Студенты записываются на курсы (с проверкой расписания и вместимости)
* Преподаватели назначаются на курсы
* По завершению курсов студентам ставятся оценки
* Система собирает аналитику (средние баллы, топы, разбивка по оценкам)
* Через текстовое меню можно управлять всем учебным процессом

## 🛠 Технологии и ограничения:
* Язык: Java
* Без использования Stream API, JUnit, баз данных и файлов
* Только базовые коллекции и принципы ООП
* Весь ввод/вывод — через консоль
* Работа в GitHub с ветками и Pull Request'ами

## 💼 Сценарий применения
Представим, что вы разрабатываете внутреннюю систему для частного учебного центра, в котором:
* несколько преподавателей ведут десятки курсов
* поток студентов постоянно обновляется
* нужны простые инструменты записи, выставления оценок и отчётности

## Система должна быть:
* гибкой
* простой для использования через консоль
* легко расширяемой и поддерживаемой


## 1.

📁 model/Student.java
```java
    private String id;

    private String name;

    private int age;

    private List<Course> enrolledCourses = new ArrayList<>();

    private Map<Course, Grade> grades = new HashMap<>();
```    
### ✅ Метод: ```void enroll(Course course)``` 
Добавляет курс в список enrolledCourses, если курса ещё нет.

Выводит в консоль сообщение: "Студент <name> записан на курс <course title>"

Проверять на дубли (не добавлять повторно).

Если студент уже записан - то вывести сообщение "Студент <name> уже записан на курс <course title>"

### ✅ Метод: ```void assignGrade(Course course, Grade grade)```
Добавляет оценку в Map<Course, Grade> grades. И вывести сообщение в консоль "Оценка <grade> выставлена студенту <name> по курсу <course title>"

Если курс не в списке записанных — вывести предупреждение. "Ошибка: студент <name> не записан на курс <course title>"

Если всё ок — добавить/обновить оценку.


### ✅ Метод: ```double calculateAverageGrade()```
Вычисляет средний балл на основе grades

Использует grade.getValue() (A=5, F=1)

Возвращает 0.0, если нет оценок

## 2.

Файлы:
📁 model/Course.java

```java
  private String courseId;

  private String title;

  private int capacity;

  private Schedule schedule;

  private Set<Student> enrolledStudents = new HashSet<>();

  private Instructor instructor;
```

📁  model/Schedule.java

```java
  private String dayOfWeek;

  private String time;

  private String room;
  
```

Задача:
- Реализовать методы в Course:

  ### ✅ Метод: ```boolean hasSpace()```
    - Возвращает true, если количество студентов в enrolledStudents меньше capacity
    - Иначе — false

  ### ✅ Метод: ```void enrollStudent(Student student)```
    - Если студент уже записан — вывести: "Студент <name> уже записан на курс (title)"
    - Если есть место:
        - Добавить в enrolledStudents
        - Вывести: "Студент <name> зачислен на курс (title)"
    - Если нет места:
        - Вывести: "Ошибка: курс (title) заполнен"

- Реализовать метод в Schedule:

  ### ✅ Метод: ```boolean conflictsWith(Schedule other)```
    - Если совпадает день и время — возвращает true
    - Иначе — false
    - Пример: если у курса A и курса B оба `Понедельник` и `10:00–11:30`, то конфликт

Советы:
- Использовать equals по id в Course и Student
- String сравнивать через equals (для day и time)
- Выводить все действия через System.out.println


## 3.
Файлы:
📁  model/Grade.java
```java
enum GRADE { 
    A, B, C, D, F;

  public int getValue() {
  return switch (this) {
  case A -> 5;
  case B -> 4;
  case C -> 3;
  case D -> 2;
  case F -> 1;
  };
  }
}
```
📁  model/Instructor.java
```java
    private String id;

    private String name;

    private List<Course> courses = new ArrayList<>();
```
Задача:
- Grade (enum) уже реализован — ничего менять не нужно.

 Реализовать методы в Instructor:

  ### ✅ Метод: ```void assignCourse(Course course)```
    - Добавляет курс в список courses преподавателя (если ещё не добавлен)
    - Выводит: "Преподаватель <name> назначен на курс <course title>"
    - Если уже ведёт этот курс — вывести: "Преподаватель <name> уже ведёт курс <course title>"

  ### ✅ Метод: ```List<Course> getCourses()```
    - Возвращает список всех курсов, назначенных этому преподавателю

Советы:
- Переопредели equals/hashCode в Course по courseId
- Используй System.out.println для наглядности
- Если поле courses не инициализировано — обязательно проинициализировать его (например, в конструкторе или сразу при объявлении)
- Можно использовать ArrayList

## 4. 

Файл:
📁 service/RegistrationService.java

Задача:
Реализовать регистрацию студента на курс. Проверить:

### ✅ Метод: ```void registerStudentToCourse(Student student, Course course)```

- Если студент уже записан на курс:
  → Вывести: "Студент (name)уже записан на курс (title)"
  → Не выполнять регистрацию повторно.
  → Бросить исключение DuplicateStudentException

- Если в курсе нет свободных мест (использовать course.hasSpace()):
  → Вывести: "Ошибка: курс (title) заполнен"
  → Бросить CourseFullException

- Если расписание курса конфликтует с другими курсами студента (использовать schedule.conflictsWith):
  → Вывести: "Ошибка: конфликт расписания у студента (name) с курсом (title)"
  → Бросить ScheduleConflictException

- Иначе:
  → Вызвать course.enrollStudent(student)
  → Вызвать student.enroll(course)


Советы:
- Бросать исключения из пакета exception/
- Обрабатывать только логику регистрации (без оценки)
- Использовать System.out.println для объяснения результата
- Метод должен быть максимально изолированным, чтобы его можно было переиспользовать из других сервисов
  */


## 5.
Файл:
📁 service/StudyManager.java

Задача:
Реализовать менеджер, который управляет всей системой.
Хранит список студентов, курсов, преподавателей.
Вызывает методы из других сервисов (например, RegistrationService).

### ✅ Методы:

```void registerStudent(Student student)```
- Добавляет студента в список
- Выводит: "Студент (name) зарегистрирован в системе"
- Проверка на дубликаты (по id)

```void createCourse(Course course)```
- Добавляет курс в список
- Выводит: "Курс (title) создан"
- Проверка на дубликаты (по courseId)

```void assignInstructor(Course course, Instructor instructor)```
- Вызвать instructor.assignCourse(course)
- Установить course.setInstructor(instructor)
- Вывод: "Преподаватель (name) назначен на курс (title)"

```void enroll(Student student, Course course)```
- Вызвать метод RegistrationService.registerStudentToCourse(student, course)
- Обработать исключения через try-catch

```void assignGrade(Student student, Course course, Grade grade)```
- Вызвать student.assignGrade(course, grade)
- Вывод: "Оценка (grade) назначена студенту (name) за курс (title)"

Советы:
- Использовать List<Student>, List<Course>, List<Instructor>
- Вызывать логику у моделей, не реализовывать вручную
- Все действия выводить через System.out.println


## 6.
Файл:
📁 service/StatisticsService.java

Задача:
Реализовать аналитику по студентам и курсам. Использовать только циклы, без Stream API.

### ✅ Методы:

```double getAverageForCourse(Course course)```
- Считает средний балл всех студентов по конкретному курсу
- Проходит по всем студентам, у которых есть оценка по этому курсу
- Если таких студентов нет — возвращает 0.0

```List<Student> getTopStudents(List<Student> allStudents, int count)```
- Сортирует студентов по среднему баллу (calculateAverageGrade()) по убыванию
- Возвращает top N студентов
- Если студентов меньше, чем count — вернуть всех
- Реализация сортировки через обычный цикл и Collections.sort() с Comparator

```Map<Grade, Integer> getCountByGrade(Course course)```
- Подсчитать, сколько студентов получили каждую оценку по конкретному курсу
- Вернуть Map, где ключ — Grade, значение — количество
- Если нет оценок — вернуть пустую Map или Map с нулями

Советы:
- Все методы должны быть простыми и понятными
- Не использовать Stream API
- Печатать промежуточные результаты через System.out.println при отладке


## 7.
Файл:
📁 ui/ConsoleMenu.java

Задача:
Реализовать простое текстовое меню для взаимодействия с пользователем через консоль.

### ✅ Обязательные действия в меню:

### 1. Добавить нового студента
   - Ввод имени, возраста, id
   - Вызов studyManager.registerStudent(...)

### 2. Добавить курс
   - Ввод title, id, capacity, расписания
   - Вызов studyManager.createCourse(...)

### 3. Назначить преподавателя
   - Ввод id курса и преподавателя
   - Вызов studyManager.assignInstructor(...)

### 4. Записать студента на курс
   - Ввод id студента и курса
   - Вызов studyManager.enroll(...)

### 5. Назначить оценку
   - Ввод id студента, курса и оценку (буквой: A, B, ...)
   - Вызов studyManager.assignGrade(...)

### 6. Показать статистику по курсу
   - Вызов методов StatisticsService
   Средний балл по курсу
   И Оценки студентов каждый с новой строки.

### 7. Показать всех студентов, их курсы и оценки
   - Все студенты в studyManager
### 8. Показать всех преподавателей и их курсы
   - Все преподаватели в studyManager
### 9. Показать все курсы с расписанием
   - Все курсы в studyManager
### 10. Выйти из программы

### ✅ Реализация:
- Использовать Scanner для считывания с консоли
- Построить меню через while + switch/case
- Все действия обернуть в try-catch (чтобы программа не падала при ошибке ввода)
- Отделить меню от логики (вызывать StudyManager и StatisticsService)

Советы:
- Можно добавить метод printMenu() для повторного показа действий
- Работать с ID (студента, курса, преподавателя), искать их по спискам
- Не забыть про System.out.println для подтверждений действий


## 8.
Файлы:
- 📁 exception/DuplicateStudentException.java
- 📁 exception/CourseFullException.java
- 📁 exception/StudentNotFoundException.java
- 📁 exception/GradeNotFoundException.java
- 📁 exception/CourseNotFoundException.java
- 📁 exception/ScheduleConflictException.java

Задача:
Реализовать собственные классы исключений. Каждое исключение должно наследоваться от `Exception` (не от `RuntimeException`). Исключения будут использоваться в других частях проекта (например, при регистрации студентов, назначении оценок и т.д.).

### ✅ Требования к каждому классу:
- Имя класса соответствует названию исключения (например, DuplicateStudentException.java)
- Наследуется от Exception
- Должен иметь как минимум один конструктор с параметром message:

```java
public class DuplicateStudentException extends Exception {
    public DuplicateStudentException(String message) {
        super(message);
    }
}
```

### ✅ Назначение исключений:
- DuplicateStudentException — студент с таким ID уже есть в системе
- CourseFullException — курс не может принять больше студентов
- StudentNotFoundException — студент с указанным ID не найден
- GradeNotFoundException — нет оценки по курсу
- CourseNotFoundException — курс с указанным ID не найден
- ScheduleConflictException — у студента уже есть курс с таким расписанием

Советы:
- Создай отдельный класс для каждого исключения в пакете `exception`
- Используй meaningful сообщения ("Студент уже зарегистрирован: " + student.getId())
- Исключения не должны содержать бизнес-логику — только конструкторы и сообщения
