package manager;

import comparator.AverageGradeComparator;
import model.Course;
import model.Grade;
import model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticsService {
    public double getAverageForCourse(Course course){
        double averageCourseGrade = 0.0;
        for (Student enrolledStudent : course.getEnrolledStudents()) {
            if(enrolledStudent.getEnrolledCourses().contains(course)){
                averageCourseGrade = enrolledStudent.getGrades().get(course).getValue();
            }
        }
        return averageCourseGrade;
    }
    public List<Student> getTopStudents(List<Student> allStudents, int count){
        List<Student> topStudents = new ArrayList<Student>();
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
        Map<Grade, Integer> countByGrade = new HashMap<Grade, Integer>();
        for (Student enrolledStudent : course.getEnrolledStudents()) {
            Grade grade = enrolledStudent.getGrades().get(course);
            if(enrolledStudent.getGrades().containsKey(course)){
                countByGrade.putIfAbsent(grade, 1);
                if(countByGrade.containsKey(grade)){
                    countByGrade.put(grade, countByGrade.get(grade) + 1);
                }
            }
        }
        return countByGrade;
    }
}
