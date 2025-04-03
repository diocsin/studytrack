package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Instructor {
    private final String id;

    private final String name;

    private List<Course> courses = new ArrayList<>();

    public Instructor(String id, String name, List<Course> courses) {
        this.id = id;
        this.name = name;
        this.courses = courses;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Instructor that = (Instructor) o;
        return Objects.equals(courses, that.courses);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(courses);
    }

    void assignCourse(Course course) {
        if (course.getInstructor().getName().contains(course.getTitle())) {
            System.out.println("Преподаватель " + name + "уже ведёт курс " + course.getTitle());
        } else {
            courses.add(course);
            System.out.println("Преподаватель " + name + "назначен на курс " + course.getTitle());
        }
    }

    public List<Course> getCourses() {
        return courses;
    }
}
