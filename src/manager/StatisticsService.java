package manager;

import model.Course;
import model.Grade;
import model.Student;

import java.util.*;

public class StatisticsService {
    private static StatisticsService instance;

    private StatisticsService() {
    }
    public static StatisticsService getInstance(){
        if (instance == null) {
            instance = new StatisticsService();
        }
        return instance;
    }

    public double getAverageForCourse(Course course) {
        double averageCourseGrade = 0.0;
        int countStudents = 0;
        for (Student enrolledStudent : course.getEnrolledStudents()) {
            if (enrolledStudent.getEnrolledCourses().contains(course)) {
                countStudents++;
                averageCourseGrade += enrolledStudent.getGrades().get(course).getValue();
            }
        }
        if (countStudents != 0) {
            averageCourseGrade /= countStudents;
        }
        return averageCourseGrade;
    }

    public List<Student> getTopStudents(List<Student> allStudents, int count) {
        allStudents.sort((Student s1, Student s2) -> Double.compare(s2.calculateAverageGrade(), s1.calculateAverageGrade()));
        if (count > allStudents.size()) {
            return allStudents;
        } else {
            allStudents.subList(0, count);
        }
        return allStudents;
    }

    public Map<Grade, Integer> getCountByGrade(Course course) {
        Map<Grade, Integer> countByGrade = new HashMap<>();
        for (Student enrolledStudent : course.getEnrolledStudents()) {
            Grade grade = enrolledStudent.getGrades().get(course);
            if (enrolledStudent.getGrades().containsKey(course)) {
                if (grade != null) {
                    countByGrade.put(grade, countByGrade.getOrDefault(grade, 0) + 1);
                }
            }
        }
        return countByGrade;
    }
}
