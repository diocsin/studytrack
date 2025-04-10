package model;

import factory.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Instructor {
    private final Logger logger = LoggerFactory.createLogger("instructor");
    private final String id;

    private final String name;

    private List<Course> courses = new ArrayList<>();

    public Instructor(String id, String name, List<Course> courses) {
        this.id = id;
        this.name = name;
        this.courses = courses;
    }

    public void assignCourse(Course course) {
        if (courses.contains(course)) {
           logger.log("Преподаватель " + name + "уже ведёт курс " + course.getTitle());
        } else {
            courses.add(course);
            logger.log("Преподаватель " + name + "назначен на курс " + course.getTitle());
        }
    }

    public List<Course> getCourses() {
        return courses;
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
}