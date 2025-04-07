package manager;

import comparators.AverageGradeComparator;
import model.Course;
import model.Grade;
import model.Student;

import java.util.*;

public class StatisticsService {
    public double getAverageForCourse(Course course){
        double averageCourseGrade = 0.0;
        int countStudents = 0;
        for (Student enrolledStudent : course.getEnrolledStudents()) {
            if(enrolledStudent.getEnrolledCourses().contains(course)){
                countStudents++;
                averageCourseGrade += enrolledStudent.getGrades().get(course).getValue();
            }
        }
        if(countStudents != 0){
            averageCourseGrade /= countStudents;
        }
        return averageCourseGrade;
    }
    public List<Student> getTopStudents(List<Student> allStudents, int count){
        List<Student> topStudents = new ArrayList<>();
        allStudents.sort(new AverageGradeComparator());
        allStudents.reversed();
        if(count > allStudents.size()){
            topStudents.addAll(allStudents);
        } else {
            for (int i = 0; i < count; i++){
                topStudents.add(allStudents.get(i));
            }
        }
        return topStudents;
    }
    public Map<Grade, Integer> getCountByGrade(Course course){
        Map<Grade, Integer> countByGrade = new HashMap<>();
        for (Student enrolledStudent : course.getEnrolledStudents()) {
            Grade grade = enrolledStudent.getGrades().get(course);
            if(enrolledStudent.getGrades().containsKey(course)){
                if (grade != null) {
                    countByGrade.put(grade, countByGrade.getOrDefault(grade, 0) + 1);
                }
            }
        }
        return countByGrade;
    }
}
