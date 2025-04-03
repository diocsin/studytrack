package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Instructor {
    private String id;

    private String name;

    private List<Course> courses = new ArrayList<>();

    public Instructor(String id, String name, List<Course> courses) {
        this.id = id;
        this.name = name;
        this.courses = courses;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
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
        courses.add(course);
        System.out.println("Преподаватель " + name + "назначен на курс " + courses.getTitle());
        if(instructor);
            System.out.println("Преподаватель " + name +"уже ведёт курс " + courses.getTitle());
    }
    public List<Course> getCourses() {
        return courses;
    }
}
